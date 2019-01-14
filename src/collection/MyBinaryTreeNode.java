/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Collection;

/**
 *
 * @author kdriley0
 */
public class MyBinaryTreeNode implements Comparable <MyBinaryTreeNode>
{
    public Object data;
    public MyBinaryTreeNode left;
    public MyBinaryTreeNode right;
    public MyBinaryTreeNode(Object d)
    {
        data=d;
        left=right =null;
    }
    public MyBinaryTreeNode(Object d, MyBinaryTreeNode l, MyBinaryTreeNode r)
    {
        data =d;
        left =l;
        right=r;
    }
    public String toString()
    {
        return data.toString();
    }
    
    public int compareTo(MyBinaryTreeNode target)
    {
        return ((Comparable)this.data).compareTo(target.data);
    }
}
