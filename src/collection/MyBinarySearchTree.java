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
 * @author kdriley0
 */
public class MyBinarySearchTree extends MyBinaryTree
{
    public  MyBinarySearchTree()
    {
        root=null;
    }
    public void insert(Object newItem)
    {
          root = insertHelper(root, new MyBinaryTreeNode(newItem));
    }
    private  MyBinaryTreeNode insertHelper(MyBinaryTreeNode rt, MyBinaryTreeNode newNode)
    {
      if(rt==null)
      {
          rt=newNode;
          return rt;
      }
      if(newNode.compareTo(rt)<0)
      {
          rt.left=insertHelper(rt.left, newNode);
      }
      else//>=
      {
          rt.right=insertHelper(rt.right, newNode);
      }
      return rt;
    }
    public Object next()
    {
        if(root ==null) return null;
        return maxHelper(root).data;
        
            
    }
    private MyBinaryTreeNode maxHelper(MyBinaryTreeNode rt)
    {
       if(rt.right==null) return rt;
       return maxHelper(rt.right);
    }
    public MyBinaryTreeNode find(Object target)
    {
        return findHelper(root,new MyBinaryTreeNode(target));
    }
   private MyBinaryTreeNode findHelper(MyBinaryTreeNode rt, MyBinaryTreeNode targetNode)
    {
        if(rt ==null) return null;
        if(targetNode.compareTo(rt)<0)
        {
            return findHelper(rt.left, targetNode);
        }
        if(targetNode.compareTo(rt)>0)
        {
            return findHelper(rt.right, targetNode);
        }
        
            return rt;
        
        
         
    }
   public Object max(MyBinaryTreeNode rt)
   {
       if(rt==null)return null;
       return maxHelper(rt).data;
   }
   public Object min(MyBinaryTreeNode rt)
   {
       if(rt==null)return null;
       return minHelper(rt).data;
   }
   private MyBinaryTreeNode minHelper(MyBinaryTreeNode rt)
   {
       if(rt.left==null) return rt;
       return minHelper(rt.left);
   }
    private MyBinaryTreeNode findParent(MyBinaryTreeNode rt, MyBinaryTreeNode targetNode)
    {
        if( targetNode.compareTo(rt)<0)
        {
            if(rt.left==null)
            {
                return null;
            }
        
            else if(targetNode.compareTo(rt.left)==0)
            {
                return rt;
            }
            else 
            {
                    return findParent(rt.left, targetNode);
            }
        
         }
        else 
        if( targetNode.compareTo(rt)>0)
        {
            if(rt.right==null)
            {
                return null;
            }
        
            else if(targetNode.compareTo(rt.right)==0)
            {
                return rt;
            }
            else 
            {
                    return findParent(rt.right, targetNode);
            }
        
         }
        return null;
    }
    private MyBinaryTreeNode successorParent(MyBinaryTreeNode rt)
    {
        if(rt==null)
            return null;
        if(rt.right==null)
            return null;
        if(rt.right.left==null)
            return rt;
        MyBinaryTreeNode temp= rt.right;
        while(temp.left.left!=null)
        {
            temp=temp.left;
        }
        return temp;
    }
    public void remove (Object target)
    {
        if(root ==null)return;
        
        MyBinaryTreeNode targetNode= new MyBinaryTreeNode(target);
        if(targetNode.compareTo(root)==0)
        {
            MyBinaryTreeNode sp1= successorParent(root);
            if(sp1==null)
            {
                root=root.left;
            }
            else if(sp1==root)
            {
                root.right.left=root.left;
                root=root.left;
            }
            else
            {
                MyBinaryTreeNode rightChildOfSucc=sp1.left.right;
                sp1.left.left=root.left;
                sp1.left.right=root.right;
                root=sp1.left;
                sp1.left=rightChildOfSucc;
                return;
            }
        }
        MyBinaryTreeNode targetParent=findParent(root, targetNode);
        if(targetParent==null)return;
        if(targetParent.left!=null)
        {
            if(targetParent.left.compareTo(targetNode)==0)
            {
                MyBinaryTreeNode rNode=targetParent.left;
                MyBinaryTreeNode sp2 = successorParent(rNode);
                if(rNode.left==null&&rNode.right==null)
                {
                    targetParent.left=null;
                }
                else if(sp2==null&&rNode!=null)
                {
                    targetParent.left=rNode.left;
                }
                else if( sp2==rNode)
                {
                    sp2.right.left=rNode.right;
                    targetParent.left=rNode.right;
                }
                else
                {
                    MyBinaryTreeNode rightChildOfSucc=sp2.left.right;
                    sp2.left.left=rNode.left;
                    sp2.left.right=rNode.right; 
                    targetParent.left=sp2.left;
                    sp2.left=rightChildOfSucc;
                }
                return;
            }
        }
         if(targetParent.right!=null)
         {
              if(targetParent.right.compareTo(targetNode)==0)
              {
                MyBinaryTreeNode rNode=targetParent.right;
                MyBinaryTreeNode sp3 = successorParent(rNode);
                    if(rNode.left==null&&rNode.right==null)
                    {
                        targetParent.right=null;
                    }
                    else if(sp3==null&&rNode!=null)
                    {
                        targetParent.right=rNode.left;
                    }
                    else if(sp3==rNode)
                    {
                        sp3.right.left=rNode.left;
                        targetParent.right=rNode.left;
                    }
                    else
                    {
                         MyBinaryTreeNode rightChildOfSucc=sp3.left.right;
                         sp3.left.left=rNode.left;
                         sp3.left.right=rNode.right;
                         targetParent.right=sp3.left;
                         sp3.left=rightChildOfSucc;
                    }
                    return;
                        
              }
         }
        
        
    }
        
}
