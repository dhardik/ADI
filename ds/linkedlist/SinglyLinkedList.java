package ds.linkedlist;
import java.util.*; 
public class SinglyLinkedList<E> {
  private class Node<E> {
    private E element;
    private Node<E> next;
    public Node(E e,Node<E> n) {
      element = e;
      next = n;
    }
    public E getElement() {
      return element;
    }
    public Node<E> getNext() {
      return next;
    }
    public void setNext(Node<E> n) {
      this.next = n;
    }
  }
  private Node<E> head = null;
  private Node<E> tail = null;
  private int size = 0;
  public SinglyLinkedList() {};
  public int size() {
    return size;
  }
  public boolean isEmpty() {
    if(size == 0) {
      return true;
    }
    return false;
  }
  public E first() {
    if(head != null) {
      return head.getElement();
    }
    return null;
  }
  public E last() {
    if(tail != null) {
      return tail.getElement();
    }
    return null;
  }
  public void addFirst(E e) {
    Node<E> n = new Node<>(e,head);
    head = n;
    if(tail == null) {
      tail = n;
    }
    size++;
  }
  public void addLast(E e) {
    Node<E> n = new Node<>(e,null);
    if(tail != null) {
      tail.setNext(n);
    }
    else {
      head = n;
    }
    tail = n;
    size++;
  }
  public E removeFirst() {
    if(head != null) {
      E x = head.getElement();
      head = head.getNext();
      if(head == null) {
        tail = null;
      }
      size--;
      return x;
    }
    return null;
  }
  public String toString() {
    StringBuilder s = new StringBuilder("(");
    if(head != null) {
      Node<E> n = head;
      while(n != null) {
        E ele = n.getElement();
        s = s.append(ele);
        n = n.getNext();
        if(n != null) {
          s = s.append(",");
        }
      }
    }
    s = s.append(")");
    return s.toString();
  }
  public E findMid() {
    if(!isEmpty()) {
      return findNthFromStart((size/2)+1);
    }
    return null;
  }
  public E findNthFromStart(int n) {
    if(n>0 && n<=size) {
      int targetIndex = n-1;
      Node<E> node = head;
      int count = 0;
      while(count < targetIndex) {
        node = node.getNext();
        count++;
      }
      return node.getElement();
    }
    return null;
  }
  public E findNthFromEnd(int n) {
    if(n>0 && n<=size) {
      int targetIndex = size-n+1;
      return findNthFromStart(targetIndex);
    }
    return null;
  }

  // public boolean isPallindrome() {
  //   if(size == 1 || size == 0) {
  //     return true;
  //   } 
  //   else {
  //     Node<E> slow = head;
  //     Node<E> fast = head;
  //     Node<E> slow_prev = null;
  //     int count = 0;
  //     while(fast != null && fast.next != null) {
  //       slow_prev = slow;
  //       slow = slow.next;
  //       fast = fast.next.next;
  //       count ++;
  //     }
  //     if(fast == null) {
  //       //even
  //       count--;
  //       int len = size - count;
  //       E arr[] = new E[len];
  //       slow_prev.next = null;
  //       // slow.reverseLinkedList();
  //       // System.out.println(slow_prev.next.getElement());
  //       // slow.reverseLinkedList();
  //       // System.out.println(slow.getElement());
  //       // System.out.println(head.toString());
  //     }
  //     return true;
  //   }
  // }

  public void reverseLinkedList() {
    if(head != null) {
      Node<E> prev = null;
      Node<E> curr = head;
      Node<E> next;
      while(curr != null) {
        next = curr.next;
        curr.next = prev;
        prev = curr;
        curr = next;
      }
      head = prev;
    }
  }

  public boolean containsLoop() {
    if(size > 2) {
      Node<E> slow = head;
      Node<E> fast = head;
      while(fast != null && fast.next != null && slow != null) { 
        slow = slow.next;
        fast = fast.next.next;
        if(fast == slow){
          removeLoop(fast);
          return true;
        }
      }
      return false;
    }
    return false;
  }

  public void removeLoop(Node<E> node1) {
    Node<E> ptr1 = this.head;
    Node<E> ptr2;
    while(true) {
      ptr2 = node1;
      while(ptr2.next != ptr2 && ptr2.next != ptr1) {
        ptr2 = ptr2.next;
      }
      if(ptr2.next == ptr1) {
        break;
      }
      ptr1 = ptr1.next;
    }
    ptr2.next = null;
  }
}
