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
import collection.*;

public class MyQueue {

    public SLListNode front;
    public SLListNode rear;

    public MyQueue() {
        front = rear = null;
    }

    public void insertBack(Object element)
    {
        if (front == null) {
            front = rear = new SLListNode(element, null);
        } else {
            rear = rear.next = new SLListNode(element, null);
        }
    }

    public Object removeFront() {
        if (front == null) {
            return null;
        }
        Object temp = front.data;
        if (front == rear) {
            front = rear = null;
        } else {
            front = front.next;
        }
        return temp;
    }

    public Object front() {
        if (front == null) {
            return null;
        }
        return front.data;

    }

    public String toString() {
        String out = "";
        if (front == null) {
            out += "this list is empty";
        }
        int i = 1;
        SLListNode ref = front;
        while (ref != null) {
            if (i == 1) {
                out += " " + ref.data + " " + " ";
                ref = ref.next;
                i++;
            } else {
                out += " " + ref.data + " ";
                ref = ref.next;
                i++;
            }

        }

        return out;
    }
    public void clear()
    {
        front=rear=null;
    }
    

}
