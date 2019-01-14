/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package project;

import collection.MySet;
import lab.lab2;

/**
 *
 * @author kdriley0
 */
public class Project1 {
    
    public static void test(){
        MySet primeNumSet = new MySet();//makes a new MySet called  primeNumSet to store the  prime numbers into
        MySet fibonacciNumSet = new MySet();//creates a new MySet object to store the  fibonacci numbers in
        MySet symm_diff_set = new MySet();//creates a new MySet object to store the  symmetric Difference in
        MySet unionSet = new MySet();//creates a new MySet object to store the  union in
           lab2 l2= new  lab2();// creating a new lab 2 object called l2 so that I can call the fibonacciNumbers method 
           Project1 p1=new  Project1();//creating a new project1 object called p1 so that I can call the primeNumber method 
           int[] fibonacciNumbers_array= new int[26];//creating an array that can hold the fibonacci numbers
           int[] primeNumSet_array= new int[26];///creating an array that can hold the prime numbers
           fibonacciNumbers_array= l2.fibonacciNumbers(26);//loading 26 numbers into fibonacciNumbers_array
          primeNumSet_array= p1.primeNumber(26);//loading the 26 prime numbers into the array 
        for(int i =0;i<26;i++){// adding the fibonacciNumbers into vector v1 
           fibonacciNumSet.add(fibonacciNumbers_array[i]);//adding the fibonacciNumbers into the array one at a time 
           primeNumSet.add(primeNumSet_array[i]);//adding the prime number into the array one at a time
       }
        System.out.println("The fibonacci numbers are: \n"+fibonacciNumSet.toString());
        System.out.println("The prime numbers are: \n"  + primeNumSet.toString());
        System.out.println("The intersection is:\n"+fibonacciNumSet.intersection(primeNumSet));
       symm_diff_set =fibonacciNumSet.symmetricDifference(primeNumSet);//putting the symmetric difference between the prime numbers and the fibonacci numbers into the symm_diff_set
        System.out.println("The symmetric difference is :\n"+symm_diff_set.toString());
        unionSet=primeNumSet.union(fibonacciNumSet);//putting the primme numbers and the fibonacci numbers into the union set
        System.out.println("the union of the two sets is: \n"+unionSet.toString());
    }

   public int[] primeNumber(int endAt){//a method that puts all the prime # up to endAt into an array called primeN which it retuns 
       int[] primeN = new int[endAt];//makes a new array called primeN to store the prime numbers in 
       boolean prime =true;//defaults the boolean prime to true 
       int curr =2,size=0;//initilzes curr to 2 and size to 0
       
      while(size<primeN.length)//keeps it going until it reaches endAt
      {
         for(int i=2; i<=Math.sqrt(curr);i++)//goes from 2 to the square root of the currrent number as to check every number
        {
                  if(curr%i==0)//check to see if any number divided by it
                  {
                      prime=false;// if anynumber is divided by it set prime ot false
                      break;//start with next number
                  }
         }
          if(prime)
          {
              primeN[size++]=curr;// if prime is true add it to size while adding one to size so it is ready for the next number

          }
          curr++;//add 1 to curr
          prime=true;//reset prime to true 
         }
return primeN;
        }
    
}

