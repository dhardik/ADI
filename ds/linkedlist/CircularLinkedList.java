package ds.linkedlist;
import java.util.*; 
public class CircularLinkedList<E extends Comparable <E>>
{
	private static class Node<E>
	{
		private E element;            
        private Node<E> next;
        public Node(E e, Node<E> n) 
        {
            element=e;
            next=n;
        }
        public E getElement() 
        {
            return element;
        }
        public Node<E> getNext() 
        { 
            return next;
        }
        public void setNext(Node<E> n) 
        { 
            next=n;
        }
	}
	private Node<E> head = null;
    private Node<E> tail = null;
    private int size = 0;
    public CircularLinkedList() 
    { 
        
    }
    public int size() 
    {  
        return size;
    }
    public boolean isEmpty() 
    { 
        if(size==0)
            return true;
        return false;
    }
    public E first()
    {
        if(head!=null)
            return head.getElement();
        return null;
    }
    public E last() 
    {
        if(tail!=null)
            return tail.getElement();
        return null;
    }
    public void addFirst(E e) 
    {
        Node<E> n=new Node<>(e,head);
        head=n;
        if(tail==null)
        {
            tail=n;
            tail.setNext(head);
        }
        ++size;
    }
    public void addLast(E e) 
    {
        Node<E> n=new Node<>(e,null);
        if(tail==null)
        {
            head=n;
        }
        else
        {
            tail.setNext(n);
        }
        tail=n;
        tail.setNext(head);
        ++size;
    }
    public E removeFirst() 
    {
        if(head!=null)
        {
            E x=head.getElement();
            if(head==tail)
            	head=tail=null;
            else
            {
            	head=head.getNext();
            	tail.setNext(head);
            }
            --size;
            return x;
        }
        return null;
    }
    public String toString() 
    {
        StringBuilder s=new StringBuilder("(");
        if(head!=null)
        {
            Node<E> n=new Node<>(head.getElement(),head.getNext());
    		do
            {
                s=s.append(n.getElement());
                n=n.getNext();
                if(n!=head)
                    s=s.append(", ");
            }while(n!=head);
        }
        s=s.append(")");
        return s.toString();
    }
}