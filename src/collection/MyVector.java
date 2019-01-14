/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package collection;

/**
 *Implement the vector ADT as MyVector class (implements Cloneable) 
 * @author Kevin Riley 
 */
public class MyVector implements Cloneable{
 
    private static final int INITIAL_CAPACITY = 100; 
    protected int size =0;
    protected Object [] data;
    /**
     * constructor that creates a MyVector object that has an initial size of 0 
     * and an array named data with the initial capacity of 100 
     */
    public MyVector(){
        int size =0;
        data = new Object[INITIAL_CAPACITY ];
    }
    public void append(Object element){//appends the object element onto the data array
        if( size ==data.length){
            expand();
        }
        
            data[size++]=element;
        
    }
    public void clear(){// clears the srray data 
        for(int i = 0; i< size;++i){
            data[i]=null;
        }
        size=0;
    }
    /**
     * checks if the object is in the array 
     */
    public boolean contains(Object element){
        for(int i = 0; i< size;++i){
            if(element.equals(data[i])){
                return true;
            }
        }
        return false;
    }
/**
 * 
 * @param index
 * @return 
 */    
    public Object elementAt(int index){// returns the Object variable at the int 
        if( index < 0 || index >= size){
            return null;
        }
        return data[index];
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
    public boolean insertAt(int index, Object element){//inserts an object element  at int intdex
        if( index < 0 || index >= size){
            return false;
            }
        if(size == data.length) expand();
        for(int i =size;i >index;i--)
        {
            data[i]=data[i -1];  
        }
        data[index]=element;
        return true;
    }
    public boolean isEmpty(){//returns true if the vector is empty
        return size==0; 
    }
    public Object removeAt(int index){// removes the object at the selected index
        if( index < 0 || index >= size) 
            return null;
        Object temp = data[index];
        for(int i =index;i <= size -2;++i)
        {
            data[i]= data[++i];
        }
        data[--size]=null;
        return temp;
    }
    public boolean remove(Object element){//removes the selected object
        return removeAt(indexOf(element))!=null;
    }
    public boolean replace(int index, Object element ){//replaces the object at the index(int) with the selected object 
        if( index < 0 || index >= size) 
            return false;
        data[index]=element;
        return true;
    }
    public int size(){ //returns size 
        return size;
    }
    public void ensureCapicity(int minCapacity){//ensures the capacity of the array data my increasing the size 2 fold size= size *2
        if(minCapacity <= data.length-size)
            return;
        Object[] temp = new Object[size+ minCapacity];
        for(int i =0;i<size;i++){
            temp[i]=data[i];
        }
        data = temp; 
    }
    /**
     *  removes a range of objects 
     * from index to to index --
     */
    public void removeRange(int fromIndex, int toIndex){
        if(fromIndex >= toIndex)return;
        if(fromIndex < 0)
            fromIndex =0;
        if (toIndex > size)
            toIndex = size;
        int num =toIndex -fromIndex;
        for(int i = fromIndex;i<size-num;++i){
            data[i]=data[i +num];
        }
            for(int j = size-num ; j < size;++j){
                data[j]=null;
        } size-=num;
    }
    public MyVector clone(){//copies the vector and returns a copy 
         MyVector vecCopy = new MyVector();
         vecCopy.ensureCapicity(this.size);
         for(int i =0; i<size;++i){
             vecCopy.data[i]=this.data[i];
         }
         vecCopy.size=this.size;
         return vecCopy;     
    }
   
   /**
    * provides a to string method for MyVector
    * that provides the size
    * the current capacity
    *  and the elements with a new line every 5th element 
    */
    @Override
    public String toString(){//
        
    String str = "+++++++++++++++++++\n" +
           "The current vector contains:";
    str+= "size = "+size + "\n";
    str+= "capacity = "+data.length + "\n";
    
    for(int i =0; i<size;i++){
        str+= i+ " : " + data[i] + "\t";
        if((i+1)%5==0){
            str+="\n";
        }
    }        
        str+="\n+++++++++++++++++\n";
    
       return str;
    }
    public void reverse(){//reverses the vector
        Object temp;
        for(int i = 0;i<size/2 ;++i){
            temp=data[i];
            data[i]=data[size -i-1];
            data[size-i-1]= temp;
        }
    }
    public void merge(MyVector vector2){// adds the vector vector2 to the end of vector 1 
        if ( vector2.size ==1) 
                append(vector2);
        int s = vector2.size;
        for(int i = 0;i < s;i++ ){
            append(vector2.data[i]);
        }
        
    }
 //MyVector v1 = new MyVector();
}
   
    

    
