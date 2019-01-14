/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package collection;

/**
 *
 * @author kdriley0

public class MySort2 {
    private MySort2(){};
    
    public void myBubbleSort(MyVector v)
    {
        Comparable first, second;
        int i,j,n=v.size;
        
        
        for( i =0;i < n;++i)
        {
            for( j=n-1;j>=i;--j)
            {
            first=(Comparable)v.elementAt(j-1);
            second=(Comparable)v.elementAt(j);
            if(first.compareTo(second)<0)
                swap(v, (j-1),j);
            }
        }
    }
        public static void swap(MyVector v,int index1,int index2)
        {
            Object temp = v.elementAt(index1);
            v.replace(index1,v.elementAt(index2));
            v.replace(index2,temp);
            
        }
        
    public void mySelectionSort(MyVector v)
    {
     int i, j, n = v.size, smallPos;
     Comparable smallest, current;
        for(i = 0;i < (n-1);++i )
        {
            smallPos = i;
            smallest =(Comparable) v.elementAt(i);
                for( j=i+1;j < n;j++ )
                {
                  current = (Comparable)v.elementAt(j);
                    if(current.compareTo(smallest)<0)
                    {
                        smallPos=j;
                        smallest=current;
                    
                   
                }
                }if()
        } 
    }
        
        
      
    
}*/
