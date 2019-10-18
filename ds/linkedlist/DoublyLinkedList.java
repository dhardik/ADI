package ds.linkedlist;
import java.util.*; 
public class DoublyLinkedList<E extends Comparable <E>> 
{
    private static class Node<E> 
    {
        private E element;         
        private Node<E> prev;
        private Node<E> next;  
        public Node(E e, Node<E> p, Node<E> n) 
        {
            element=e;
            prev=p;
            next=n;
        }
        public E getElement() 
        { 
            return element; 
        }
        public Node<E> getPrev() 
        { 
            return prev; 
        }
        public Node<E> getNext() 
        { 
            return next; 
        }
        public void setPrev(Node<E> p) 
        { 
            prev=p; 
        }
        public void setNext(Node<E> n) 
        { 
            next=n; 
        }
    } 
    private Node<E> header;                   
    private Node<E> trailer;                   
    private int size = 0;                      
    public DoublyLinkedList() 
    {
        header=null;
        trailer=null;
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
        if(size!=0)
            return header.getElement();
        return null;
    }
    public E last() 
    {
        if(size!=0)
            return trailer.getElement();
        return null;
    }
    public void addFirst(E e) 
    {
        Node<E> n=new Node<>(e,null,header);
        if(isEmpty())
            trailer=n;
        else
            header.setPrev(n);
        header=n;
        ++size;
    }
    public void addLast(E e) 
    {
        Node<E> n=new Node<>(e,trailer,null);
        if(isEmpty())
            header=n;
        else
            trailer.setNext(n);
        trailer=n;
        ++size;
    }
    public E removeFirst() 
    {
        if(isEmpty())
            return null;
        E n=header.getElement();
        header=header.getNext();
        if(header==null)
            trailer=null;
        else
            header.setPrev(null);
        --size;
        return n;
    }
    public E removeLast() 
    {
        if(isEmpty())
            return null;
        E n=trailer.getElement();
        trailer=trailer.getPrev();
        if(trailer==null)
            header=null;
        else
            trailer.setNext(null);
        --size;
        return n;
    }
    private void addBetween(E e, Node<E> predecessor, Node<E> successor) 
    {
        Node<E> n=new Node<>(e,predecessor,successor);
        predecessor.setNext(n);
        successor.setPrev(n);
        ++size;
    }
    private E remove(Node<E> node) 
    {
        if(size==0)
            return null;
        E n=node.getElement();
        if(node.getNext()==null)
        {
            removeLast();
        }
        else if(node.getPrev()==null)
        {
            removeFirst();
        }
        else
        {
            node.getPrev().setNext(node.getNext());
            node.getNext().setPrev(node.getPrev());
            --size;
        }
        return n;
    }
    public String toString() 
    {
        StringBuilder s=new StringBuilder("(");
        if(size!=0)
        {
            Node<E> n=new Node<>(header.getElement(),header.getPrev(),header.getNext());
            while(n!=null)
            {
                s=s.append(n.getElement());
                n=n.getNext();
                if(n!=null)
                    s=s.append(", ");
            }
        }
        s=s.append(")");
        return s.toString();
    }
    public void merge(DoublyLinkedList n)
    {
        E x,y;
        Node<E> t1=new Node<>(header.getElement(),header.getPrev(),header.getNext());
        Node<E> t2=new Node<>(n.header.getElement(),n.header.getPrev(),n.header.getNext());
        while(t2!=null)
        {
            x=t1.getElement();
            y=t2.getElement();
            if(x.compareTo(y)>0)
            {
                if(t1.getPrev()==null)
                {
                    header=t2;
                    t2.setPrev(null);
                }
                else
                {
                    t1.getPrev().setNext(t2);   
                    t2.setPrev(t1.getPrev());
                }
                t1.setPrev(t2);
                t2=t2.getNext();
                t1.getPrev().setNext(t1);
                ++size;
            }
            else
            {
                if(t1.getNext()==null)
                    break;
                t1=t1.getNext();
            }
        }
        while(t2!=null)
        {
            t1.setNext(t2);
            t2=t2.getNext();
            t1.getNext().setPrev(t1);
            t1=t1.getNext();
            t1.setNext(null);
            ++size;
        }
    }
} 