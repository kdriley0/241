/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lab;

/**
 *
 * @author kdriley0
 */
import collection.*;
public class Lab6 
{
    
      public static void test()
    {
      SLList  simpleList = new SLList();

         for( int i = 1;i <31;++i)
         {
             if(i%2==1)
             {
                 simpleList.insert(i*i);
             }
             else
             {
                 simpleList.append(i*i);
             }
         }
     System.out.println(simpleList.toString());
     simpleList.remove(25);
     simpleList.remove(36);
     simpleList.remove(64);
     simpleList.remove(100);
     simpleList.remove(400);
     
     System.out.println(simpleList.toString());
     SortedSLList sortedList = new SortedSLList();
     for( int i = 1;i <31;++i)
         {
                 sortedList.insert(i*i);     
         }
     System.out.println(sortedList);

     sortedList.remove(1);//removing the numbers
     sortedList.remove(25);
     sortedList.remove(36);
     sortedList.remove(64);
     sortedList.remove(144);
     sortedList.remove(400);
     sortedList.remove(900);
     
     System.out.println(sortedList);
     sortedList.insert(1);
     sortedList.insert(64);
     sortedList.insert(400);
     sortedList.insert(900);
      System.out.println(sortedList);
     
     
     
    }
}
