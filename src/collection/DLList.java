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
public class DLList 
{
    public DLLinkNode head;
    public DLLinkNode tail;
    DLList()
    {
        head =tail=null;
    }
    public void append(Object element)
    {
         if(head == null)
        {
            head=tail=new DLLinkNode(element, null, null);
        }else
             
        {
            tail=tail.next=new DLLinkNode(element, tail, null);
        }
        
    }
     public void insert(Object element)
         {
             if(head == null)
             {
                  head=tail=new DLLinkNode(element, null, null);
                  return;
             }
             head=head.prev= new DLLinkNode(element, null, head);
         }
     public void remove(Object element)
     {
         if(head == null) return;
         if(((Comparable)head.data).compareTo(element)==0)
             if(head == tail)
             {
                 head=tail=null;
             }else
             {
                 head =head.next;
                 head.prev=null;
                 return;
             }
            if(head==tail)return;
            DLLinkNode ref =head.next;
            while(ref.next!=tail)
            {
                if(((Comparable)ref.data).compareTo(element)==0)
                {
                    ref.prev.next=ref.next;
                    ref.next.prev=ref.prev;
                    return;
                }
                ref= ref.next;
            }
            if(((Comparable)ref.data).compareTo(element)==0)
            {
                tail=tail.prev;
                tail.next=null;
            }
            
         
     }
     public String toString()
     {
         String out = "";
         if( head == null)
         {
             out += " empty DLList";
             return out;
         }
         else 
         {
             out+= "DLList  head --> ";
             DLLinkNode ref = head;
             while(ref.next !=null)
             {
                 out+=ref.data+" ";
                 ref=ref.next;
             }
             out+= " tail";
         }
             
             
         
         return out;
     }
}
