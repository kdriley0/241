/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lab;

import java.util.Vector;

/**
 *
 * @author kdriley0
 */
public class lab1 {
 
public static void test(String[] args){
    
    Vector<Object> vector = new Vector<Object>(); 
    int primitiveInt = 241;
    Integer wrapperInt = new Integer(2017);
    String str = "Kevin Riley";
    vector .add(primitiveInt);
    vector.add(wrapperInt);
    vector.add(str);
    vector.add(2, new Integer(2172));
    System.out.println("The elements of vector: " + vector); 
    System.out.println("The size of vector is: " + vector.size());
    System.out.println("The element at position 2 is: " + vector.elementAt(2));
    System.out.println("the first element is at " + vector.firstElement());
    System.out.println("the last emement is at " + vector.lastElement());
    vector.removeElementAt(1);
    System.out.println("The elements of vector:" + vector);
    System.out.println("The size of the vector is " + vector.size());
    System.out.println("the element at position 2 is:" + vector.elementAt(2));
    System.out.println("The last element of vector is: " + vector.lastElement());
    vector.clear();
for(int i = 0 ; i < args.length;i++)//goes through the arguments 
{
    int x = Integer.parseInt(args[i]);
    vector.add(x);
}
System.out.println(vector);
for(int i =  vector.size()-1 ; i >0;i--)//goes through the aruments backward so as to not count any agrument twice
{
    if(i%2 ==1){//selecting ever odd index element  
    
    vector.remove(i);//removing every odd index element
    }   
}
System.out.println(vector);

}
    
}
