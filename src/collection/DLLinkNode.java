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
public class DLLinkNode 
{
    public Object data;
    public DLLinkNode next;
    public DLLinkNode prev;
    
    public DLLinkNode(Object d, DLLinkNode p, DLLinkNode n)
    {
        data =d;
        prev =p;
        next =n;
    }
    
}
