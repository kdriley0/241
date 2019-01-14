/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lab;

import collection.MyVector;
import java.util.Random;

/**
 *
 * @author kdriley0
 */
public class Lab10
{
    
 
        static Random r = new Random();// creates a new static random variable named r

     public  static void test()throws IndexOutOfBoundsException
    {
       
        
         Lab10 l10 = new Lab10();
        r.setSeed(20170327); //sets the seed to 20170327
        MyVector vec = new MyVector();//initializes and declares a new vector named vec 
        MyVector vec1 = new MyVector();//initializes and declares a new vector named vec1
        MyVector vec2 = new MyVector();//initializes and declares a new vector named vec2 
        MyVector vec3 = new MyVector();//initializes and declares a new vector named vec3
        MyVector vec4 = new MyVector();//initializes and declares a new vector named vec4
        MyVector vec5 = new MyVector();//initializes and declares a new vector named vec5 
        l10.randomG(vec);//calls the randomG method to generate the random numbers and put them in the vector vec
        
        
        
    }
     public void randomG(MyVector v)//the randomG method with takes a vector and fills it with 30,000 random numbers from 0 to 99,999
     {
         for(int i = 0; i < 30000;++i)
        {
            v.append(r.nextInt(99999));
        }
     }
}