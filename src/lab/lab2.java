/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lab;
import collection.MyVector;
/**
 *
 * @author kdriley0
 */
public class lab2 {
     //MyVector v1= new MyVector();
     
    public static void test(String[] args){
        MyVector v1= new MyVector();// creating an intance of the my vector object called v1
        MyVector c_v= new MyVector();//creating an intance of the my vector object called c_v for cloned MyVector -- for the clone to reside in 
        int[] fibonacciNumbers_array= new int[30];//making an array called fibonacciNumbers_array to put the first 30 fibonacci numbers into 
        lab2 l2= new  lab2();// creating a new lab 2 object called l2 so that I can call the fibonacciNumbers method 
       fibonacciNumbers_array= l2.fibonacciNumbers(30);//loading 30 numbers into fibonacciNumbers_array
       for(int i =0;i<30;i++){// adding the fibonacciNumbers into vector v1 
           v1.append(fibonacciNumbers_array[i]);//adding the fibonacciNumbers into vector v1 one at a time 
       }
      System.out.println(v1.toString());//printing out the vector 
      v1.reverse();//reversing the vector 
      c_v=v1.clone();//putting the clone of the MyVector in to the clone vector c_v
      System.out.println(v1.toString());//printing out the reversed vector 
      for(int i =v1.size();i>0;i--){//a for loop that is going backward as to remove every elemt at an odd index 
          if(i %2== 1 ){
             v1.removeAt(i);
          } 
      }
       System.out.println(v1.toString());//printing out the vector with having removed every odd element 
       c_v.reverse();// reversing the clone so that it is back to ascending order 
       System.out.println(c_v.toString());//printing out the cloned method which is back to ascending order
       v1.merge(c_v);//merging the two so that it starts with the decsending order with half of the elements missing then the full vector that is in ascending
       System.out.println(v1.toString());
    }
    public int[] fibonacciNumbers(int endAt){// loads the fibonacci numbers into an array that ends at the int endAt which is given  
        int[] fN= new int[endAt];//creats a array called fN to hold the array that gets sent back
        fN[0] = 0;//loading the number 0 into the index 0 of the array
        fN[1] = 1;//loading the number 1 into the index 1 of the array
        for(int i = 2; i < endAt;++i){//for loop that loads the rest of the fibonacci numbers ending at the int end at 
            fN[i] = fN[i-1] + fN[i-2];
            
        }
        return fN;//returns the filled array of fibonacci numbers
        
    }
}
