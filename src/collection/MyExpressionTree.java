/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package collection;

import Collection.MyBinaryTreeNode;
import Collection.MyBinaryTree;

/**
 *
 * @author kevin
 */
public class MyExpressionTree extends MyBinaryTree
{
    public MyExpressionTree()
    {
        root=null;
    }
  public int eval(MyBinaryTreeNode rt)
     {
         if(rt.data instanceof  Integer){ 
            // System.out.println("leafnode"+ rt.data);
              return (int) rt.data;
         } 
         {
             try{
             //char root=(char)rt.data;
                 switch ((char)rt.data)
                      {


                     
                         case '+':
//                             System.out.println("addtion");
                             return eval(rt.left)+eval(rt.right);
                         case '-':
                             return eval(rt.left)-eval(rt.right); 
                         case '/':
                             return eval(rt.left)/eval(rt.right);
                         case '*':
//                             System.out.println("multiplication");    
                             return eval(rt.left)*eval(rt.right);
                         case '%':
                             return eval(rt.left)%eval(rt.right);
                         default:
                             return 0;
                 }
             } catch( ArithmeticException e){
                 return -1;
             }
                 
         }
     }
  public void clear()
  {
      root=null;
  }
  
    

}
