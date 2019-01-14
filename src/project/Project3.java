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
public class Project3 {

    static int amountOfProblems = 0;
    String currentP = "";
    static MyQueue queue = new MyQueue();
    static MyStack stack = new MyStack();
    static int result = 0;

    public void input() throws IOException {
        int i = 0, result = 0, j,k;
        String problem = "";
        int paraC = 0;

        FileWriter f = new FileWriter("../COSC241_P3_Output_kdriley0.txt");
        BufferedWriter b = new BufferedWriter(f);
        boolean properEq = false;

        File in = new File("../COSC241_P3_Input.txt");
        Scanner scan = new Scanner(in);
        while (scan.hasNext()) {
            properEq = true;
            paraC = 0;
            currentP = scan.nextLine();
            currentP = currentP.trim();

            boolean[] digit = null;
            boolean[] oper = null;
            while (currentP.length() == 0) 
            {
                currentP = scan.nextLine();
            }
            digit = new boolean[currentP.length()];
            oper = new boolean[currentP.length()];
            for (i = 0; i < currentP.length(); ++i) //begin for loop
            {
               
                amountOfProblems++;
                char currentC = currentP.charAt(i);
                if (!Character.isWhitespace(currentC)) {
                    try {
                        if (Character.isDigit(currentC)) {
                            queue.insertBack(currentC);
                            digit[i] = true;
                           // if()
                        } else if (currentC == '(') {
                            stack.push(currentC);
                            paraC++;
                        } else if (currentC == ')') {
                            paraC--;
                            while ((char) stack.top.data != '(') {
                                if (stack.top != null && (char) stack.top.data != '(') {
                                    queue.insertBack(stack.pop());
                                    oper[i] = true;
                                } else {
                                    stack.pop();
                                    oper[i] = true;
                                }

                            }
                            if ((char) stack.top.data == '(') {
                                stack.pop();
                            }

                        } else if (stack.isEmpty(stack) || (precidence((char) stack.top()) < precidence((char) currentC)))//if char on top > new char
                        {
                            stack.push(currentC);
                            oper[i] = true;
                        } else if (precidence((char) stack.top()) >= precidence(currentP.charAt(i)))// if the char on top is a higher presidece or = precidence
                        {
                            queue.insertBack(stack.pop());
                            stack.push(currentC);
                            oper[i] = true;

                        }
                        if (paraC != 0 && i == currentP.length() - 1) {
                            queue.clear();
                            queue.insertBack("this problem does not compute because it has an odd number of parathencies");
                            properEq = false;
                        }
                        if (isOperator(currentC) && i == currentP.length() - 1) {
                            properEq = false;
                        }

                        if (i == 0 && oper[i] == true) {
                            properEq = false;
                        }
                    } catch (ArrayIndexOutOfBoundsException e) {

                    }
                    // System.out.println(oper.length);

                }

            }//for end 
             j = 0;
             k=0;
            for (i = 0; i < currentP.length(); ++i)
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
                    properEq=false;
                }
                if(k <   1&&i == currentP.length() - 1)
                {
                    properEq=false;
                }
                
            }
            for (i = 1; i < currentP.length(); ++i) 
            {
                 j=0;
                 if(i>=1 &&oper[i]&&oper[i-1])
                {
                         properEq=false;
                }
                if (i >= 1 && digit[i] && digit[i - 1]) 
                {
                    properEq = false;
                }
                
            }
            while (stack.top != null && properEq) 
            {
                if ((char) stack.top.data == '(') 
                {
                    stack.pop();
                } else 
                {
                    Object op = stack.pop();
                    queue.insertBack(op);
                }
            }

            //System.out.println(queue.toString());
            b.write("Original Infix: \t ");
            b.write(currentP);
            b.newLine();
            if (properEq)
            {
                b.write("Corresponding Postfix:\t");
                b.write(queue.toString());
                calculation(stack, queue);
                b.newLine();
                b.write("Evaluation Result \t = ");
                b.write(stack.pop().toString());
                b.newLine();
                
            } else {
                b.write("**Invalid expression**");
                 b.newLine();
            }
        
           
            b.newLine();
            b.newLine();
            b.flush();
            while (!stack.isEmpty(stack)) 
            {
                stack.pop();
            }
            queue.clear();

        }//while end

    }//method end

    public static void test() throws IOException {
        FileWriter f = new FileWriter("../COSC241_L8_Output_kdriley0.txt");
        BufferedWriter b = new BufferedWriter(f);
        Project3 p3 = new Project3();
        p3.input();

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

    public int calculation(MyStack s, MyQueue q) {
        char frontC = (char) q.front.data;

        while (!isOperator(frontC)) {
            s.push(q.removeFront());
            frontC = (char) q.front();
        }
        while (q.front != null) {
            if (!isOperator((char) q.front.data)) {
                s.push(q.removeFront());

            }
            calc(s, q);
        }
      
        return result;
    }

    public static void calc(MyStack s, MyQueue q) {
       
        if ((q.front.data).equals('*')) 
        {
            result = times(Integer.parseInt(s.pop().toString()), (Integer.parseInt(s.pop().toString())));
            q.removeFront();
//            System.out.println("the result is " +result);
            s.push(result);
        } else if ((q.front.data).equals('/')) 
        {
            result = div(Integer.parseInt(s.pop().toString()), (Integer.parseInt(s.pop().toString())));
            q.removeFront();
//            System.out.println("the result is " +result);
            s.push(result);
        } else if ((q.front.data).equals('+'))
        {
            result = plus(Integer.parseInt(s.pop().toString()), (Integer.parseInt(s.pop().toString())));
            q.removeFront();
//            System.out.println("the result is " +result);
            s.push(result);
        } else if ((q.front.data).equals('%')) 
        {
            result = mod(Integer.parseInt(s.pop().toString()), (Integer.parseInt(s.pop().toString())));
            q.removeFront();
//            System.out.println("the result is " +result);
            s.push(result);
        } else if ((q.front.data).equals('-')) 
        {
            result = min(Integer.parseInt(s.pop().toString()), (Integer.parseInt(s.pop().toString())));
            q.removeFront();
//            System.out.println("the result is " +result);
            s.push(result);
        }
        
    }

    public static int div(int l, int r) {
        return r / l;
    }

    public static int times(int l, int r) {
        return r * l;
    }

    public static int plus(int l, int r) {
        return l + r;
    }

    public static int min(int l, int r) {
        return r - l;
    }

    public static int mod(int l, int r) {
        return r % l;
    }

    public static boolean isOperator(char c) {
        if (c == '+' || c == '-' || c == '*' || c == '/' || c == '%') {
            return true;
        }
        return false;
    }

}

