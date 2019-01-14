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
    public class MyDeque extends DLList
{
    public MyDeque()
    {
        super();
    }
    public Object front()
    {
        if(head==null) return null;
        return head.data;
    }
    public Object back()
    {


            if(tail == null) return null;
            return tail.data;
    }
    public void insertBack(Object element)
    {
        append(element);

    }
    public Object removeFront()
    {
        if (head==null) return null;
        Object temp = head;
     if(head == tail)
    {
        head = tail = null;
    }   
     else
     {
          head=head.next;
          
     }
        
          return temp;      
        
            
    }
    public Object removeBack()
    {
    if(tail==null) return null;
    Object temp = tail.data;
    if(head == tail)
    {
        head = tail = null;
    }
    else
    {
        tail=tail.prev;
        tail.next = null;
        
    }
    return temp;
    }
    
    public void insert(Object element)
    {
        insert(element);
    }
            
    
    @Override
    public void remove(Object element)
    {
        return;
    }
    public void clear()
    {
        this.head =this.tail=null;
    }
}
