/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lab;
import collection.*;
import java.util.Random;
/**
 *
 * @author kdriley0
 */
public class Lab9 
{
     public static void test()
     {
      MyBinarySearchTree BST = new MyBinarySearchTree();
      BST.insert(100);
      BST.insert(50);
      BST.insert(150);
      
      Random r = new Random();
      r.setSeed(System.currentTimeMillis());
      for(int i = 0; i < 50;++i)
      {
          BST.insert(r.nextInt(300));
      }
      BST.inorderTravesel();
      BST.preorderTraversel();
      BST.postorderTravesel();
      
      Object max;
      Object min;
      max=BST.max(BST.root);
      min=BST.min(BST.root);
      
     
      BST.remove(min);
      BST.remove(max);
      BST.remove(50);
      BST.remove(100);
      BST.remove(150);
      System.out.println();
      BST.inorderTravesel();
      BST.preorderTraversel();
      BST.postorderTravesel();
              
      
     
    
      }
}
