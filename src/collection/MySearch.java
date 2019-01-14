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
public class MySearch implements Comparable{
    private MySearch(){}
    /**linearSearchSorted searches though one by one  
     * to find the target
     * @param v
     * @param target
     * @return 
     */
    public static int linearSearchSorted(MyVector v, Comparable target)
    {
        int i;//declares the int variable 
        for(i = 0;i < v.size; ++i)
                    {
            if(target.compareTo(v.elementAt(i))<=0)//checks to see if object is smalller than the first object in the vector 
                break;//then checks every element until it finds the object we are searhing for 
                    }
        if(i==v.size)//if it has checked though the entire list and it is not found return -1
             return -1;
        if(target.compareTo(v.elementAt(i))==0)// if it is found than return i
            return i;
        return -1;// if it finds nothing return -1 so the code can compile
    }
    /**
     * does a binary search for the target in the given vector
     * @param v
     * @param target
     * @return 
     */
    public static int binarySearch(MyVector v, Comparable target)
    {
        int first = 0 , last = v.size-1, middle =0;//declare the int values 
        
        while(first < last)//keeps it going until it has searched the whole vector
        {
          
        
            middle=(first+last)/2;//setting the middle to the middle
        if( target.compareTo(v.elementAt(middle))<0)//checking the first half
            last=middle - 1;//if it is in the first half cut off the back half
        else if( target.compareTo(v.elementAt(middle))>0)//checks to see if the target isin the back half of the list 
            first=middle;//if it is sets the first = to the middle therefor cutting off the back half of the list
        else if(target.compareTo(v.elementAt(middle))==0);//checks to see if if element is = to the middle 
             return middle + 1;// returns the target which = middle +1
        }
         return -1;   //else if it is not in the list return -1
    } 

    @Override
    public int compareTo(Object o) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
} 
