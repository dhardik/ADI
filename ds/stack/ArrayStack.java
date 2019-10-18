package ds.stack;

public class ArrayStack<E> {
    public static final int CAPACITY=1000;
    private E[] data;
    private int t = -1;

    public ArrayStack() {
        data = (E[])new Object[CAPACITY];
    }

    public ArrayStack(int capacity) {
        data = (E[])new Object[capacity];
    }

    public int size() {
        return (t+1);
    }

    public boolean isEmpty() {
        if(t == -1) {
            return true;
        }
        return false;
    }

    public void push(E element) {
        data[++t] = element;
    }

    public E top() {
        return data[t];
    }

    public E pop() {
        if(isEmpty()) {
            return null;
        }
        return data[t--];
    }

    public String toString() {
        StringBuilder sb = new StringBuilder("(");
        for(int i=0;i<=t;i++) {
            sb = sb.append(data[i]);
            if(i != t) {
                sb = sb.append(", ");
            } 
        }
        sb.append(")");
        return sb.toString();
    }
}