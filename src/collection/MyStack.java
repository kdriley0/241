/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package collection;

/**
 *
 * @author kdriley0
 */
public class MyStack 
{
    public SLListNode top;
    public MyStack()
    {
        top=null;
    }
    public Object pop()
    {
        if(top == null)
            return null;
        Object temp = top.data;
        top=top.next;
        return temp;
    }
    public void push(Object element)
    {
        top =new SLListNode(element, top);
    }
    public Object top()
    {
        if(top == null)
            return null;
        return top.data;
    }

    public String toString()
    {
        String out ="Contains";
        if(top==null)
        {
            out+= "this list is empty";
        }
          int i =1;
        SLListNode ref= top;
        while(ref.next!=null)
        {
            if(i==1)
             {
                  out+= " "+ ref.data +" "+ " ";
                   i++;
             }else
            {
               
            out+= ref.data+" " ;
            i++;
            ref=ref.next;
            }
            
        }
        return out;
    }
    public boolean isEmpty(MyStack ms)
    {
        return (ms.top==null);
    }
        
        
        
}
