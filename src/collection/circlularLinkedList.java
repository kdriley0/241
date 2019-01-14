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
public class circlularLinkedList
{
    private SLListNode head;
    private SLListNode tail;
    
    public circlularLinkedList()
    {
        head=tail=null;
    }
    public void append(Object element)
    {
        if(head == null)
        {
            head = tail = new SLListNode(element, null);
            head.next= tail;
            tail.next=head;
        }
        else
        {
            tail=tail.next=new SLListNode(element, head);
            
        }
    
    }
    public void insert(Object element)
    {
        if(head == null)
        {
            head = tail = new SLListNode(element, null);
            head.next= tail;
            tail.next=head;
        }
        else
        {
            SLListNode ref= head;
            head = new SLListNode(element,ref);
            tail.next=head;
            
        }
    }
    public boolean isEmpty(SLList ssl)
    {
        return (ssl==null);
    }
    public boolean remove(Object element)
    {
        if(head == null)return false;
        
        if(((Comparable)head.data).compareTo(element)==0)
        {
            if(head == tail)
            {
                head=tail=null;
                return true;
            }
            else
            {
            head=head.next; 
            return true;
            }
            
            
        }
        if(head == tail)return false;
        SLListNode ref = head;
        while(ref.next!=tail)
        {
            if(((Comparable)ref.data).compareTo(element)==0)
            {
                ref.next=ref.next.next;
                return true;
            }
            ref = ref.next;
        }
        if(((Comparable)ref.data).compareTo(element)==0)
        {
            tail=ref;
            ref.next = head;
            return true;
            
        }
        return false;
        
            
        
    }
    @Override
    public String toString()
    {
        String out= "";
        SLListNode ref= head;

        while(ref.next != head)
        {
            System.out.println(ref.data);
            out+= "this Circular linked list contains head -->  "+ ref.data+ " ";
            
            ref=ref.next;
        } 
        out+= ref.data;
        System.out.println("yo");
        return out;
    }
}

    
                
            
    
    
    

