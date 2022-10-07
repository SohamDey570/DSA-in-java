//import package 
import java.util.Iterator;

public class StackUsingLinkedList<Item> implements Iterable<Item> {
    private Node head;
    private int N;
    
// A linked list node
    public class Node {
        Item item;
        Node next;
    }

    // boolean function to check the size of stack
    public boolean isEmpty() {//check if empty
        return N == 0;
    }

    public int size() {
        return N;
    }

    public void push(Item item) {
        Node oldFirst = head;
        head = new Node();
        head.item = item;
        head.next = oldFirst;
        N++;
    }

    public Item pop() {
        Item item = head.item;
        head = head.next;
        N--;
        return item;
    }

    @Override//using decorators
    public Iterator<Item> iterator() {
        return new stackIterator();
    }

    private class stackIterator implements Iterator<Item> {
        int i = N;
        Node temp = head;
        @Override
        public boolean hasNext() {
            return i > 0;
        }

        @Override
        public Item next() {
            Item item = temp.item;
            temp = temp.next;
            i--;
            return item;
        }

        @Override
        public void remove() {

        }
    }


}
