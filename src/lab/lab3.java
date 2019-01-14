/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lab;

import collection.MyVector;
import java.util.Random;
import collection.MySort;
import collection.MySearch;
import java.util.Scanner;

/**
 *
 * @author kdriley0
 */
public class lab3 {
    public static void test()
    {
        MyVector numVec = new MyVector();//creakes a new MyVector named numVec to store the random generated numbers
        Random r = new Random();//creates a new random object
        r.setSeed(System.nanoTime());//sets the seed to the nano time
        for(int i =0;i<500;++i)
        {
          numVec.append(r.nextInt(899)+100);//adds the numbers in one at a time from a random int from 100 to 999
        }
        int var=0,var2, indexOf = 0,index2 = 0;//declares the int variables
        
       MySort.bubbleSort(numVec);//sorts the numVec using the bubble sorts
       System.out.println(numVec.toString());//prints the numVec
       Scanner sc = new Scanner(System.in);// declares a new scanner object named sc
       
       System.out.println("please type a number to search for");
       var =sc.nextInt();// set the variable the user just entered into the variable var
       indexOf= MySearch.linearSearchSorted(numVec, var);//searches the through using the linear search and putting  the value into the variable indexof
       System.out.println( indexOf);//printing out the index the value was found at 
       numVec.removeRange(50, 350);// removing the index values 50 to 349 so removing 200 values  
       numVec.reverse();//reversing the vector
       //MySort.SelectionSort(numVec);//sorting the vec using the selection sort
       System.out.println(numVec.toString());// printing the numVec to the screen 
       System.out.println("please type a number to search for");
        var2 =sc.nextInt();// storing the value the user just entered into the variable var2
       index2=MySearch.binarySearch(numVec,var2);//seaching the list using the binary search method and putting that value into the var index2 
       System.out.println( index2);//printing out the index the value was found at 
       
    }
}
