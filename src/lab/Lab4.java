/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lab;

import java.util.Scanner;

/**
 *
 * @author kevin
 */
public class Lab4 
{
    public static void test()
    {
        
    boolean bool;// declare a boolean named bool that will tell if if the word is a palindrome
    Scanner sc = new Scanner(System.in);//declares a new scanner object named sc
    System.out.println("Please type in a string that (contains no white space characters \njust hit enter to exit");
    String userInput = sc.nextLine();//sets the user input = to the next line
    
    while(userInput.length() != 0 )
    {
    
    bool = isPalindrome(userInput);//sets the boolean bool = to the recursive method isPalindrome
    System.out.println( " the string is a palindrome = " +bool);//displays if the string is a palindrome
    System.out.println("Please type in a string that (contains no white space characters \njust hit enter to exit");
    userInput= sc.nextLine();
    }
    }

public static boolean isPalindrome(String s)//compares a piece of the string then cut it off when I call the method again 
{
    
     int n = s.length();
    String beg= s.substring(0,1);//declares and initilizes a string called beg to the first letter of the word
    String end= s.substring(n-1,n); //declaresand initilizes a string called end to the last letter in the word 
if(s.length()<=2&&(beg.equalsIgnoreCase(end)))return true;//end it if the String s is less than or = to 2 and both letter are the same  returns true
if(s.length() ==2&&(!beg.equalsIgnoreCase(end)))return false;//end it if the String s has 2 letter that are  different return false
        s= s.substring(1, n-1);//sets the string = to the string - the chars beg and end
    System.out.println( " the beg is "+beg+" and the end is "+end);
   if(beg.equalsIgnoreCase(end))//if the strings beg and end are = it calls itself 
   {
       return  isPalindrome(s);
   }
  
   return false;//if they are not it returns false


}
}
