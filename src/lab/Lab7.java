/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lab;
import collection.*;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintStream;
import java.text.Format;
import java.util.Random;

/**
 *
 * @author kdriley0
 */
public class Lab7 {
      public static void test()throws IOException
    {
        
        PrintStream fileOut = new PrintStream(new File("COSC241_L7_Output_kdriley0.txt"));
        int[] numbers =new int[60]; 
         MyQueue queue = new MyQueue();
         MyStack stack = new MyStack();
         Random r = new Random();
         r.setSeed(System.currentTimeMillis());
         for(int i =0; i< 60; ++i)
         {
             numbers[i]=r.nextInt(500);
         }
         for(int i =0; i< 60; ++i)
         {
             stack.push(numbers[i]);
             queue.insertBack(numbers[i]);
         }
         
  
         for(int i =0; i< 30; ++i)
         {
             stack.pop();
             
         }
          for(int i =0; i<= 30; ++i)
              queue.removeFront();
          
         FileWriter f =new FileWriter("../COSC241_L7_Output_kdriley0.txt");
         BufferedWriter b=new BufferedWriter(f);
         b.write(queue.toString());
         b.newLine();
         b.flush();
         b.write(stack.toString());
         b.flush();
         b.close();
         f.close();
         
          
         
         

         
    }
}
