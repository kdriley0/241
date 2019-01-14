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
public class MySort {

    private MySort() {
    }
        /**bubble sort 
         * sorts by "bubbling" the values from low to high
         * so that the low values are at the beginning and high values at the end  
         * @param v 
         * 
         */
    public static void bubbleSort(MyVector v) {
        int i, j, n = v.size();// declares the int values that this sort is going to use 
        Comparable first = 0, second;// the values  that we can use to compare with each other to see which is greater/less than 
        for (i = 1; i < n; ++i)//the outer for loop which goes from index 1  to size 
        {
            for (j = n - 1; j >= i; --j) //the inner for loop which starts at the end and works its way down  which compares the values 
            {
                first = (Comparable) v.elementAt(j - 1);//sets the comparable first to the index j-1 so one less than the second 
                second = (Comparable) v.elementAt(j);//sets second to be = to j or one greater than first
                if (first.compareTo(second) > 0) //checks to see if the first is greater than the second
                {
                    swap(v, j - 1, j);// if it is then it swaps the first and the second
                }
            }
        }
    }
   /**the swap method  
    * 
    * @param v
    * @param index1
    * @param index2
    * swaps the object at index1 with the object at index2  
    */
    public static void swap(MyVector v, int index1, int index2)
    {
        Object temp = v.elementAt(index1);// establishes a object variable and initalises it to the object at index 1
        v.replace(index1, v.elementAt((index2)));// switches the object at index one with the object at index2
        v.replace(index2, temp);//puts the object origionally held in index1 in index2
    }

    public static void selectionSort(MyVector v) //this method takes a MyVector parameter 
    {
        int i, j, n = v.size(), smallPos;//declares the int values that this method is going to use
        Comparable smallest, current;//the two values that this sort needs to compare
        for (i = 0; i < n - 1; ++i) //the outer for loop going from 0 to n-1 so through the whole array
        {
            smallPos = i;//setting the small position = to i 
            smallest = (Comparable) v.elementAt(smallPos);//setting the comparable smallest = to the element at small position
            for (j = i + 1; j < n; ++j)//the inner for loop going from i+1 so the beginning till the end
            {
                current = (Comparable) v.elementAt(j);//setting the current = to  the element at j 
                if (current.compareTo(smallest) < 0) //checking to see if the current is smaller than the object at smallest
                {
                    smallPos = j;//if it is the smallest is set the index held by that object  
                    smallest = current;//and set the current to smallest 
                }
            }
            if (smallPos != i);//checks to see if the index has changed
            swap(v, i, smallPos);// if it has changed out it to the beginning 
        }
    }
    public static void insertionSort(MyVector v, int left, int right)//this method takes 3 parameters the vecotor the integer  at the right position and the integer at the lef moat  
    {
        int inner, outer;//initalizes two int variables named inner and outer 
        Comparable current, previous;//initalizes two comparable variables named current, previous
        Object target;//initalizes a object named target
        for(outer = left +1;outer<=right;++outer)//a for loop starting at left +1 while outer <= right
        {
            target =v.elementAt(outer);//sets the object target = to the element at outer
            inner=outer;//sets the variable inner = to the outer 
            while(inner>left&&((Comparable)v.elementAt(inner-1)).compareTo(target)>0)//loops while the inner > than the left and the element at inner - 1 > than the target 
            {
                v.replace(inner,v.elementAt(inner-1));// replaces the element at the inner with the object at the inner - 1 
                --inner; //decrements the inner 
            }//end of while 
            v.replace(inner,target);// replaces the object at inner with the target 
        }
        
    }
    /**
     * shell sort 
     * @param v
     * takes a MyVector parameter 
     */
    public static void shellSort(MyVector v)
    {
        int inner, outer, size=v.size();//initalizes and int named inner, outer, and initalizes and sets the int size = to the size ov the array
        Object target;//initalizes an object variable 
        int h =1;//initalizes and set a int named h to 
        while(h<= size/3)//loops while h <= the size of the array 
        {
            h=3*h+1;//sets h = to 3h +1 
        }
        while(h>0)//loops while h> 0
        {
            for(outer =h;outer<size;++outer)//loops while outer < size ++outer
            {
                target=v.elementAt(outer);//sets the target = to the element at outer
                inner=outer;//sets the inner = to the outer 
                while(inner>=h&&((Comparable)v.elementAt(inner-h)).compareTo(target)>0)//loops while the inner >= h and the element at inner -h > target 
                {
                    v.replace(inner,v.elementAt(inner-h));//replaces the element at inner with the element at inner -h
                    inner-=h;//sets the inner = to inner - h
                }//end of  inner while
                v.replace(inner,target);//replaces the object at inner with the target
            }//end of inner while
            h=(h-1)/3;//sets h = to (h-1)/3
        }//end of outer while 
    }
    /**
     * median of 3 
     * @param v
     * @param left
     * @param right 
     */
    
    public static void medianOf3(MyVector v, int left, int right)//sorts the element at left right and the element at the middle 
    {
        int mid=(left+right)/2;//initalizes and sets the int mid to left + right / 2 
        if(((Comparable)v.elementAt(left)).compareTo(v.elementAt(mid))>0)
            swap(v,left , mid);
        if(((Comparable)v.elementAt(mid)).compareTo(v.elementAt(right))>0)
            swap(v,mid , right);
        if(((Comparable)v.elementAt(left)).compareTo(v.elementAt(mid))>0)
            swap(v,left , mid);
    }
    /**
     * 
     * @param v
     * @param left
     * @param right
     * @return 
     */
    public static int partition(MyVector v, int left, int right)//sorts the partition 
    {
        Object pivot = v.elementAt((left+right)/2);//initalizes and sets  the object named pivot to the element at the middle  
        while(true)//loops till left <= right 
        {
            while(((Comparable)v.elementAt(++left)).compareTo(pivot)<0);//loops while the object at left is < than the pivot increasing left 
            while(((Comparable)v.elementAt(--right)).compareTo(pivot)>=0);//loops while the object at right is >=  the pivot decreasing right
            if(left>right)//breaks once left >= right
            {
                break;
            }
            swap(v, left, right);//swaps left and right 
        }
        return left;// returns the value of left 
    }
    /**
     * 
     * @param v
     * @param left//where the vector starts 
     * @param right // and finishes 
     */
    public static void quickSort(MyVector v, int left, int right)//quickly sorts the vector 
    {
        if(right-left<12)//if the list is smaller than 12 call the insertion sort 
        {
            insertionSort(v, left, right);
        }
        else
        {
            medianOf3(v, left, right);//else calls the median of 3 method 
                    int leftPtr = partition(v, left , right);//initalizes and sets  the int named leftPtr to the partition of the left and the right   
                    quickSort(v, left, leftPtr-1);//calls itself wih the the values left and leftPtr -1
                    quickSort(v, leftPtr, right);//calls itself with the parameters of leftPtr, and right 
        }
        
    }
    /**
     * 
     * @param v
     * @param left
     * @param right
     * @param temp 
     */
    public static void mergeSort(MyVector v, int left, int right, Comparable[] temp)//seperates the vector into small pieces and the puts it back sorted into a temporary comparable array then puts it back into the  array sorted  
    {
        
    
    
        if(left ==right)return;
        int mid =(left+right)/2;//initalizes and declares a int named mid to the middle of left and right 
        mergeSort(v, left, mid, temp);//merge sorts the left side
        mergeSort(v, mid+1, right, temp);//merge sorts the right side
        int i , j ,k;//initalizes three int variables 
        for(j=left;j <= right;++j)//goes through the whole vector  
        {
            temp[j]=((Comparable)v.elementAt(j));
        }
        i=left;
        k=mid+1;
        for(j=left;j<=right;++j)
        {
            if(i ==mid+1)
            {
                v.replace(j,temp[k++]);
            }
            else
           {
                if(k>right)
                {
                    v.replace(j, temp[i++]);
                }
            
                else
                {
                    if(temp[i].compareTo(temp[k])<0)
                    {
                        v.replace(j, temp[i++]);
                        
                    }else
                    {
                        v.replace(j,temp[k++]);
                    }
                }
            }
        }
    }

}
