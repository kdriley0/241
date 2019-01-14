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
public class SortedSLList 
{
    private int size;
    private  SLListNode head;
    private  SLListNode tail;
   public SortedSLList()
   {
       size=0;
       head=tail=null;
   } 
   public void clear()
   {
   head=tail=null;   
   }
   public boolean isEmpty()
   {
       return head ==null;
   }
   public int getSize()
   {
       return size;
   }
    public void insert(Object element)
        {
            SLListNode newNode = new SLListNode(element, null);
            SLListNode ref= head;
            if(head == null)
                {
                    head=tail=newNode;
                    ++size;
                    return;
                }
            if(((Comparable)(ref.data)).compareTo(element)>=0)
                    {
                        head= new  SLListNode(element, head);
                        ++size;
                        return;
                    }
              while(ref.next!=null)
              {
                   if(((Comparable)(ref.next.data)).compareTo(element)>=0)
                   {
                       newNode.next=ref.next;
                       ref.next=newNode;
                       ++size; 
                       return;
                   }
                   ref = ref.next;
              }
              tail.next=newNode;
              tail=newNode;
              ++size;
                      
        }
    public boolean remove(Object element)
    {
        if(head == null) return false;
        if(((Comparable)(head.data)).compareTo(element)==0)
        {
            if(head==tail)
            {
                head=tail=null;
            }
            else 
            {
                head=head.next;
                --size;
                return true;
            }
        }    
            if(head==tail)return false;
            SLListNode ref = head;
            while(ref.next!=tail)
            {
                 if(((Comparable)(ref.next.data)).compareTo(element)==0)
                         {
                             ref.next=ref.next.next;
                             --size;
                             return true;
                         }
                 if(((Comparable)(ref.next.data)).compareTo(element)>0)
                 {
                     return false;
                 }
                 ref=ref.next;
                             
            }
            if(((Comparable)(tail.data)).compareTo(element)==0)
            {
                tail=ref;
                tail.next=null;
                --size;
                return true;
            }
            return false;
                
        
    }
     @Override
    public String toString()
    {
        String out =" the SortedSList contains";
        if (head== null)
        {
            return out + " 0 nodes";
        }
        else out+= " head -> ";
         SLListNode ref = head;
         int m=0;
        while(ref.next !=null)
        {
            if(m %5 ==0)
            {
                out+="\n";
            }
            out+=ref.data +" \t -> \t " ; 
            ref=ref.next;
            
            ++m;
        }
        out += ref.data + "\t -> null";
        return out;
    }
}
