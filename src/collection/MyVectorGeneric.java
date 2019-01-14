/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package collection;

/**
 *
 * @author kdriley0
 */
public class MyVectorGeneric < T extends Comparable <T>> implements Cloneable 
{
    private static final int INITAL_CAPACITY =100;
    private Object[] data;
    private int size;
    
    public void append(T element)
    {
         if( size ==data.length){
            expand();
        }
        
            data[size++]=element;
        
        
    }
    public T elementAt(int index)
    {
        if(index < 0|| index >=size)
        {
            return null;
        }
        return(T)data[index];
    }
     private void expand(){
        Object[] temp= new Object[data.length*2];
        for(int i = 0; i< size;++i)
        {
         temp[i]=data[i];   
        }
        data=temp;
    }
     public int indexOf(Object element){//returns the int index that the object resides in 
        for(int i = 0; i< size;++i){
            if(element.equals(data[i])){
                return i;
            }
    }
        return -1;      
    }
     public void clear(){// clears the srray data 
        for(int i = 0; i< size;++i){
            data[i]=null;
        }
        size=0;
    }
      public boolean contains(Object element)
      {
        for(int i = 0; i< size;++i){
            if(element.equals(data[i]))
            {
                return true;
            }
        }
        return false;
    }
      public boolean isEmpty(){//returns true if the vector is empty
        return size==0; 
    }
     
    
        
}
