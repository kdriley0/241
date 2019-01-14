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
import java.util.Scanner;

/**
 *
 * @author kdriley0
 */
public class Lab8 {

    public static void test() throws IOException 
    {   int start = 0, i = 0, j, finish = 0;
        DLLinkNode front, back;
        boolean isP = false;
        String currentLine = "";
        MyDeque simpleDeque = new MyDeque();
        File in = new File("../COSC241_L8_Input.txt");
        Scanner scan = new Scanner(in);
        FileWriter f =new FileWriter("../COSC241_L8_Output_kdriley0.txt");
        BufferedWriter b=new BufferedWriter(f);
        while (scan.hasNext()) 
        {
            currentLine = scan.nextLine();
            System.out.println(currentLine);
            System.out.println(currentLine.length());

            currentLine = currentLine.trim();
            for (i = 0; i < currentLine.length(); ++i) {
                simpleDeque.append(currentLine.charAt(i));
            }

        
        
        b.write(currentLine + " this is a palindrome = " + isPallendrom(simpleDeque));
        b.newLine();
        simpleDeque.clear();
        }
        b.flush();
    }

    public static boolean isPallendrom(MyDeque d) {

        while (d.front() != null && d.front().equals(d.back())) {
            d.removeBack();
            d.removeFront();

            if (d.front() != null && !d.front().equals(d.back())) {
                return false;
            }
        }
        return true;
    }

}
