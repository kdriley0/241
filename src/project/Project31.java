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
 *
 * @author kdriley0
 */
public class Project31 

{
    static int amountOfProblems = 0;
    String currentP = "";
    MyVector problems = new MyVector();
    MyQueue queue = new MyQueue();
    MyStack stack = new MyStack();
    public void infix()throws IOException 
    {
        int paraC = 0;
        FileWriter f = new FileWriter("../COSC241_L8_Output_kdriley0.txt");
        BufferedWriter b = new BufferedWriter(f);
        boolean properEq = false;
        File in = new File("../COSC241_P3_Input.txt");
        Scanner scan = new Scanner(in);
          while (scan.hasNext()) 
          {
            properEq = true;
            paraC=0;
            currentP = scan.nextLine();
            currentP.trim();
             for (int i = 0; i < currentP.length(); ++i) 
            {
                char currentC=currentP.charAt(i);
                switch (currentC)
                {
                    case ' ':
                        continue;
                    case '(':
                        paraC++;
                        break;
                    case '+':
                         if (stack.isEmpty(stack) || (precidence((char) stack.top()) < precidence((char)currentC)))
                         {
                             stack.push(currentC);
                         }
                         break;
                    case '-':    
                        if (stack.isEmpty(stack) || (precidence((char) stack.top()) < precidence((char)currentC)))
                         {
                             stack.push(currentC);
                         }
                         break;
                    case '*':
                        if (stack.isEmpty(stack) || (precidence((char) stack.top()) < precidence((char)currentC)))
                         {
                             stack.push(currentC);
                         }
                         break;
                    case '/':
                        if (stack.isEmpty(stack) || (precidence((char) stack.top()) < precidence((char)currentC)))
                         {
                             stack.push(currentC);
                         }
                         break;
                    case '%':
                        if (stack.isEmpty(stack) || (precidence((char) stack.top()) < precidence((char)currentC)))
                         {
                             stack.push(currentC);
                         }
                         break; 
                    case ')':
                        paraC--;
                         while((char)stack.top.data != '(')
                         {
                              if (stack.top != null&&(char)stack.top.data != '(') 
                             {
                                 queue.insertBack(stack.pop());
                             }else
                             {
                                 stack.pop();
                             }
                         }
                          if ((char)stack.top.data == '(')
                         {
                             stack.pop();
                         }
                    case '0':
                    case '1':
                    case '2':
                    case '3':
                    case '4':
                    case '5':
                    case '6':
                    case '7':
                    case '8':
                    case '9':
                    queue.insertBack(currentC);
                    break;
                }//end of switch
                if(paraC != 0) 
                {
                    queue.clear();
                    queue.insertBack("this problem does not compute because it has an odd number of parathencies");
                    break;
                }
                while (stack.top != null) 
            {
                Object op = stack.pop();
                queue.insertBack(op);
            }
                System.out.println(queue.toString());
            }//end of for
          }//end of while
    }//end of method
     public static int precidence(char nTop) 
     {
        if (nTop == '+' || nTop == '-') {
            return 1;
        }
        if (nTop == '*' || nTop == '/' || nTop == '%') {
            return 2;
        }
        if(nTop=='(' || nTop==')')
        return 0;
        return 0;
        
    }
      public static void test() throws IOException {
        FileWriter f = new FileWriter("../COSC241_L8_Output_kdriley0.txt");
        BufferedWriter b = new BufferedWriter(f);
        Project31 p31 = new Project31();
        p31.infix();

    }
}
