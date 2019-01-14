/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package project;
import collection.*;
import java.io.*;
import java.util.Scanner;

/**
 * ../../wordList.txt
 *../wordList.txt
 * @author kdriley0
 */
public class Project2 
{
    static int[] name =//creates an array that represents the numbers on a phone 3 2's corresponding to a, b , c
    {2,2,2,//a,b,c
    3,3,3,//,d,e,f,
    4,4,4,//g,h,i
    5,5,5,//j,k,l
    6,6,6,//m,n,o
    7,7,7,7,//p,q,r,s
    8,8,8,//t,u,v
    9,9,9,9};//w,x,y,z
    
     public static void test()
        throws FileNotFoundException// throws the IO exception so that it will run
     {     
        
    //     Project2 p2 = new Project2();
         String userIn="";// declare and initilizes a string named user in userIn to store 
         File f = new File("../wordList.txt");// declares and initalizes a file named f
         MyVector wordList = new MyVector();//creates a empty vector to store the word list in  
         MyVector list = new MyVector();//creates a new vector to store words in number form 
         
          Scanner sc = new Scanner(System.in);//initializes and declares a new Scanner oobject named sc that will read the user input
          
          Scanner in = new Scanner(f);//initializes and declares a new Scanner named in that reads the file
          while( in.hasNextLine())//loops though the file  
          {
              String word =in.nextLine();//initializes and declares a new String named word that will hold the current line or word from the file 
              
               wordList.append(word);//adds the word to the word list
               String num = "";// //initializes and declares a new string named num to hold the number values of the word
               for(int i =0;i<word.length();++i)//loops through the whole word 
               {
                   int index = (word.charAt(i)-97);//initializes and declares a new integer = to the int value of the letter a will = 0  
                   num+=""+name[index];//adds the number value of the word to the String num so aah will = 224
               }list.append(num);//adds the full number/ 
          }
          //System.out.println(wordList.size());
          System.out.println(" please enter the 7 digit number that you want to see what words there are");//asks the user to input a number 
          userIn = sc.nextLine();//sets the string user in = to the the input of the user 
          while(userIn.length()!=7 || userIn.contains("0")||userIn.contains("1"))//error traps it so the user submits a proper integer which = 7 long and no 0's or  1's
          {
                System.out.println("error -please type in a 7 digit number without 0's or 1's");
                System.out.println(" please enter the 7 digit number that you want to see what words there are");
                userIn = sc.nextLine();
              
          }
    
            int numberOfWords=0;////initializes and declares a new int to hold the number of words 

          for(int i =0; i<list.size();++i)//loops through the whole wordlist 
          {
               if((list.elementAt(i).toString()).equalsIgnoreCase(userIn))//if the number the user inputed = a number on the list it outputs the word and incremnts number of words 
              {
                       System.out.println(wordList.elementAt(i));
                       numberOfWords++;
              }
                  
          }
         
            
          System.out.print("the number of words that was found matching you input of "+userIn + " was = to "+numberOfWords);//output the number the user used and the number of matching words 
          System.out.println();
         
        
     }

}
