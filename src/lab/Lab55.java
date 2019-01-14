/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lab;

import collection.MySort;
import collection.MyVector;
import java.util.Random;


/**
 *
 * @author kevin
 */

public class Lab55 {
    static Random r = new Random();// creates a new static random variable named r
     public  static void test()throws IndexOutOfBoundsException
    {
        Lab55 l5 = new Lab55();//creates a new lab5 object called l5
          MyVector vec = new MyVector();
         l5.randomG(vec);
        r.setSeed(20170327); //sets the seed to 20170327
        
         Comparable[] temp = new Comparable[vec.size()];
          MySort.mergeSort(vec, 0 , vec.size()-1, temp);
          MySort.quickSort(vec, 0, vec.size()-1);
        
    }
       
     public void randomG(MyVector v)//the randomG method with takes a vector and fills it with 30,000 random numbers from 0 to 99,999
     {
         for(int i = 0; i < 10;++i)
        {
            v.append(r.nextInt(99));
        }
     }
}
