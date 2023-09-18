public class LinkedListMultiSet<E> implements MultiSet<E> {
    private Node head;
    private int size;

    private class Node {
        E item;
        int count;
        Node next;

        Node(E item) {
            this.item = item;
            this.count = 1;
        }
    }

    @Override
    public boolean add(E item) {
        if (head == null) {
            head = new Node(item);
            size++;
            return true;
        }
        Node current = head;
        while (current != null) {
            if (current.item.equals(item)) {
                current.count++;
                size++;
                return true;
            }
            if (current.next == null) {
                current.next = new Node(item);
                size++;
                return true;
            }
            current = current.next;
        }
        return false;
    }

    @Override
    public void remove(E item) {
        if (head == null) return;
        if (head.item.equals(item)) {
            if (head.count > 1) {
                head.count--;
            } else {
                head = head.next;
            }
            size--;
            return;
        }
        Node current = head;
        while (current.next != null) {
            if (current.next.item.equals(item)) {
                if (current.next.count > 1) {
                    current.next.count--;
                } else {
                    current.next = current.next.next;
                }
                size--;
                return;
            }
            current = current.next;
        }
    }

    @Override
    public boolean contains(E item) {
        Node current = head;
        while (current != null) {
            if (current.item.equals(item)) {
                return true;
            }
            current = current.next;
        }
        return false;
    }

    @Override
    public boolean isEmpty() {
        return size == 0;
    }

    @Override
    public int count(E item) {
        Node current = head;
        while (current != null) {
            if (current.item.equals(item)) {
                return current.count;
            }
            current = current.next;
        }
        return 0;
    }

    @Override
    public int size() {
        return size;
    }

}
