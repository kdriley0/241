/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package project;

import Collection.MyBinaryTreeNode;
/**
 *
 * @author kevin
 */import collection.*;
import java.io.*;
import java.util.Scanner;
public class Project4 
{
    static int result = 0;
    static   MyExpressionTree tree = new MyExpressionTree();
    static MyStack stack = new MyStack();
    static MyDeque deq = new MyDeque();
    
    

    public void input() throws IOException
    {
        int i, j,k, paraC;
        String currP="0";
        
        FileWriter f = new FileWriter("../COSC241_P4_Output_kdriley0.txt");
        BufferedWriter b = new BufferedWriter(f);
        boolean validEq = false;
        
        File in = new File("../COSC241_P4_Input.txt");
        Scanner scan = new Scanner(in);
        while (scan.hasNext()) 
        {
            currP=scan.nextLine();
            currP=currP.trim();
            
            validEq=true;
            paraC=0;
            
            boolean[] digit = null;
            boolean[] oper = null;
            if (currP.length() == 0) 
            {
                //currP = scan.nextLine();
                continue;
            }
            digit = new boolean[currP.length()];
            oper = new boolean[currP.length()];
            for(i = 0;i <currP.length();++i)
            {
                char currentC = currP.charAt(i);
//                System.out.println("======" + currentC + "====");
                 if (!Character.isWhitespace(currentC)) 
                 {
                    try
                    {
                        
                    
                    
                        if (Character.isDigit(currentC)) 
                        {
//                            System.out.println("IsDigit: " + currentC);
                            MyBinaryTreeNode newNode= new MyBinaryTreeNode(Character.getNumericValue(currentC));
                            deq.insertBack(newNode);
                            digit[i]=true;
                        }
                        else if (currentC == '(') 
                        {
                            stack.push(currentC);
                            paraC++;
                        } else if (currentC == ')') 
                        {
                            paraC--;
                            while ((char) stack.top.data != '(') 
                            {
                                if (stack.top != null && (char) stack.top.data != '(') 
                                {
                               MyBinaryTreeNode right = (MyBinaryTreeNode)deq.removeBack();
                               MyBinaryTreeNode left = (MyBinaryTreeNode)deq.removeBack();
                               MyBinaryTreeNode newNode = new MyBinaryTreeNode(stack.pop(), left, right );
                                deq.insertBack(newNode);
                                    oper[i] = true;
                                } else {
                                    stack.pop();
                                    oper[i] = true;
                                }

                            }
                            if ((char) stack.top.data == '(') 
                            {
                                stack.pop();
                            }

                        } 
                        else if (stack.isEmpty(stack) || (precidence((char) stack.top()) < precidence((char) currentC)))//if char on top > new char
                        {
//                            System.out.println("IsHigherOP: " + currentC);
                            stack.push(currentC);
                            oper[i] = true;
                        } else if (precidence((char) stack.top()) >= precidence(currP.charAt(i)))// if the char on top is a higher presidece or = precidence
                        {
//                            System.out.println("IsLowerOP: " + currentC);
                           MyBinaryTreeNode right = (MyBinaryTreeNode)deq.removeBack();
                           MyBinaryTreeNode left = (MyBinaryTreeNode)deq.removeBack();
                           MyBinaryTreeNode newNode = new MyBinaryTreeNode(stack.pop(), left, right );
                           deq.insertBack(newNode);

                            stack.push(currentC);
                            oper[i] = true; 
                         }
                        if (paraC != 0 && i == currP.length() - 1) 
                        {
                            
                            validEq = false;
                        }
                        if (isOperator(currentC) && i == currP.length() - 1) {
                            validEq = false;
                        }

                        if (i == 0 && oper[i] == true) {
                            validEq = false;
                        }
                    } catch (ArrayIndexOutOfBoundsException e) 
                    {

                    }
                 }//end of if 
                 
            }//end of for
            j = 0;
             k=0;
            for (i = 0; i < currP.length(); ++i)
            {
               
                if(digit[i])
                {
                    j++;
                }
                if(oper[i])
                {
                    k++;
                }
                if(k==1&&j==0)
                {
                    validEq=false;
                }
                if(k <   1&&i == currP.length() - 1)
                {
                    validEq=false;
                }
                
            }
             for (i = 1; i < currP.length(); ++i) 
            {
                 j=0;
                 if(i>=1 &&oper[i]&&oper[i-1])
                {
                         validEq=false;
                }
                if (i >= 1 && digit[i] && digit[i - 1]) 
                {
                    validEq = false;
                }
                if(currP.length()>i+1)
                {
                    if((digit[i+1]&&digit[i-1])&&!oper[i])
                    {
                        validEq = false;
                    }
                }
               
                
            }
            b.write("Original Infix: \t ");
            b.write(currP);
            b.newLine();
            
           while (stack.top != null && validEq)
            {
                if ((char) stack.top.data == '(') 
                {
                    stack.pop();
                } else 
                {
             MyBinaryTreeNode right = (MyBinaryTreeNode)deq.removeBack();
                
             MyBinaryTreeNode left = (MyBinaryTreeNode)deq.removeBack();
//             System.out.println("Stack pop: ");
             MyBinaryTreeNode newNode = new MyBinaryTreeNode(stack.pop(), left, right );
             
             deq.append(newNode);
             
                }
            }
           
           if(validEq)
           { 
            tree.root = (MyBinaryTreeNode) deq.head.data;
//            System.out.println("Tree size: " + tree.size());
            b.write("Preorder traversal:\t");
            b.write(tree.preorderTraversel());
            b.newLine();
            b.write("Inorder traversal:\t");
            b.write(tree.inorderTravesel());
            b.newLine();
            b.write("Postorder traversal:\t");
            b.write(tree.postorderTravesel());
            b.newLine();
            b.write("Evaluation Result \t =");
            result=tree.eval(tree.root);
            System.out.println("result: " + result);
            b.write("" +result +"\r\n\r\n");
            b.newLine();
            result=0;
           }
           else
           {
             b.write("**Invalid expression**\r\n\r\n");  
             b.newLine();
           }  
          // tree.postorderTravesel();
           System.out.println(tree.preorderTraversel());
           System.out.println(tree.inorderTravesel());
           System.out.println(tree.postorderTravesel());
          // System.out.println("result:" + result);
           while (!stack.isEmpty(stack)) 
            {
                stack.pop();
            }
           deq.clear();
           tree.clear();
        }//end of while
        b.newLine();
        b.newLine();
        b.flush();
    }
    public static void test() throws IOException
    {
        FileWriter f = new FileWriter("../COSC241_L8_Output_kdriley0.txt");
        BufferedWriter b = new BufferedWriter(f);
        Project4 p4 = new Project4();
        p4.input();

    }
     public static int precidence(char nTop) 
    {
        if (nTop == '+' || nTop == '-') {
            return 1;
        }
        if (nTop == '*' || nTop == '/' || nTop == '%') {
            return 2;
        }
        if (nTop == '(' || nTop == ')') {
            return 0;
        }

        return 0;

    }
     public static boolean isOperator(char c) 
     {
        if (c == '+' || c == '-' || c == '*' || c == '/' || c == '%') {
            return true;
        }
        return false;
    }

      
     
       
     
}
