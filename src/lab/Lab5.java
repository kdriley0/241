/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lab;
import collection.*;
import java.util.Random;
/**
 *
 * @author kdriley0
 */
public class Lab5 
{
    static Random r = new Random();// creates a new static random variable named r
     public  static void test()throws IndexOutOfBoundsException
    {
        Lab5 l5 = new Lab5();//creates a new lab5 object called l5
        
         
        r.setSeed(20170327); //sets the seed to 20170327
        MyVector vec = new MyVector();//initializes and declares a new vector named vec 
        MyVector vec1 = new MyVector();//initializes and declares a new vector named vec1
        MyVector vec2 = new MyVector();//initializes and declares a new vector named vec2 
        MyVector vec3 = new MyVector();//initializes and declares a new vector named vec3
        MyVector vec4 = new MyVector();//initializes and declares a new vector named vec4
        MyVector vec5 = new MyVector();//initializes and declares a new vector named vec5 
        l5.randomG(vec);//calls the randomG method to generate the random numbers and put them in the vector vec
        
            vec1 =vec.clone();//clones the vector vec and puts the colone into the respective vector 
            vec2 =vec.clone();
            vec3 =vec.clone();
            vec4 =vec.clone();
            vec5 =vec.clone();
        
        
        
     
        
        long startTime= System.currentTimeMillis();//initializes and declares a new long named start time at the current time in nanoseconds
        MySort.bubbleSort(vec);//uses the bunnle sort to sort the vector
        System.out.println("bubbleSort"+" "+ (System.currentTimeMillis()-startTime)+ " milliseconds");// prints out the vector used + the time it took  
        System.out.println(vec.elementAt(0)+" "+vec.elementAt(1)+" "+vec.elementAt(2)+" "+vec.elementAt(9999)// prints out the required elements
        +" "+vec.elementAt(19999)+" "+vec.elementAt(29999));
        
        
        startTime= System.currentTimeMillis();//reinitializes the startTime
        MySort.selectionSort(vec1);//uses the selecton sort to sort the vector 
        System.out.println("selectionSort"+" "+ (System.currentTimeMillis()-startTime));// prints out the vector used + the time it took 
        System.out.println(vec1.elementAt(0)+" "+vec1.elementAt(1)+" "+vec1.elementAt(2)+" "+vec1.elementAt(9999)// prints out the required elements
        +" "+vec1.elementAt(19999)+" "+vec1.elementAt(29999));
        
         //l5.randomG(vec);
        startTime= System.currentTimeMillis();//reinitializes the startTime
        MySort.shellSort(vec2);//uses the shellSort sort to sort the vector 
        System.out.println("shellSort"+" "+ (System.currentTimeMillis()-startTime)+ " milliseconds");// prints out the vector used + the time it took 
        System.out.println(vec2.elementAt(0)+" "+vec2.elementAt(1)+" "+vec2.elementAt(2)+" "+vec2.elementAt(9999)// prints out the required elements
        +" "+vec2.elementAt(19999)+" "+vec2.elementAt(29999));
        
   
        
        startTime= System.currentTimeMillis();//reinitializes the startTime
        MySort.quickSort(vec4, 0, vec4.size()-1 );//uses the quickSort sort to sort the vector 
        System.out.println("quickSort"+" "+ (System.currentTimeMillis()-startTime)+ " milliseconds");// prints out the vector used + the time it took 
        System.out.println(vec4.elementAt(0)+" "+vec4.elementAt(1)+" "+vec4.elementAt(2)+" "+vec4.elementAt(9999)// prints out the required elements
        +" "+vec4.elementAt(19999)+" "+vec4.elementAt(29999));
        

        startTime= System.currentTimeMillis();//reinitializes the startTime
        MySort.insertionSort(vec5, 0 , vec.size()-1);//uses the insertionSort sort to sort the vector 
        System.out.println("insertionSort"+" "+ (System.currentTimeMillis()-startTime)+ " milliseconds");// prints out the vector used + the time it took 
        System.out.println(vec4.elementAt(0)+" "+vec4.elementAt(1)+" "+vec4.elementAt(2)+" "+vec4.elementAt(9999)// prints out the required elements
        +" "+vec4.elementAt(19999)+" "+vec4.elementAt(29999));
        
        
        startTime= System.currentTimeMillis();//reinitializes the startTime
        Comparable[] temp = new Comparable[vec.size()];//initializes and declares a new Comparable array named temp so that the merge sort can use it
        MySort.mergeSort(vec3, 0 , vec.size()-1, temp);//uses the insertionSort sort to sort the vector
        System.out.println("mergeSort"+" "+ (System.currentTimeMillis()-startTime)+ " milliseconds");// prints out the vector used + the time it took 
        System.out.println(vec3.elementAt(0)+" "+vec3.elementAt(1)+" "+vec3.elementAt(2)+" "+vec3.elementAt(9999)// prints out the required elements
        +" "+vec3.elementAt(19999)+" "+vec3.elementAt(29999));
        
    }
     public void randomG(MyVector v)//the randomG method with takes a vector and fills it with 30,000 random numbers from 0 to 99,999
     {
         for(int i = 0; i < 30000;++i)
        {
            v.append(r.nextInt(99999));
        }
     }


}
