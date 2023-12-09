package lang;

public class LinkedList<E> {


   private Node dummyHead;

   private int size;

    public LinkedList() {
        size = 0;
        dummyHead = new Node();
    }

    private class Node {
        E e;
        Node next;

        public Node(E e, Node next) {
            this.e = e;
            this.next = next;
        }

        public Node(E e) {
            this(e, null);
        }

        public Node() {
            this(null, null);
        }

        @Override
        public String toString() {
            return e.toString();
        }
    }

    // 获取链表中元素的个数
    public int getSize() {
        return size;
    }

    public boolean isEmpty() {
        return size == 0;
    }

    // 添加元素
    public void addFirst(E e) {
//        Node node = new Node(e);
//        node.next = head;
//        head = node;
        add(0, e);
    }


    public void addLast(E e) {
        add(size, e);
    }

    public void add(int index, E e) {
        if (index < 0 && index >= size)
            throw new IllegalArgumentException("Add Failed, Illegal index.");
        Node prev = dummyHead;
        for (int i = 0; i < index; i++) {
            prev = prev.next;
        }
        prev.next = new Node(e, prev.next);
        size ++;
    }

    public E get(int index) {
        if (index < 0 && index > size)
            throw new IllegalArgumentException("Add Failed, Illegal index.");
        Node cur = dummyHead.next;
        for (int i = 0; i < index; i++) {
            cur = cur.next;
        }
        return cur.e;
    }

    public E getFirst() {
        return get(0);
    }

    public E getLast() {
        return get(size - 1);
    }

    public void set(int index, E e) {
        Node cur = dummyHead.next;
        for (int i = 0; i < index; i++) {
            cur = cur.next;
            cur.e = e;
        }
    }

    public boolean contains(E e) {
        Node cur = dummyHead.next;
        while (cur != null) {
            if (e.equals(cur.e)) {
                return true;
            }
            cur = cur.next;
        }
        return false;

    }
//    public int find(E e) {
//
//    }

    public E removeFirst() {
        return remove(0);
    }

    public E removeLast() {
        return remove(size - 1);
    }

    public E remove(int index) {
        if (index < 0 && index >= size)
            throw new IllegalArgumentException("Add Failed, Illegal index.");
        Node prev = dummyHead;
        for (int i = 0; i < index; i++) {
            prev = prev.next;
        }
        Node retNode = prev.next;
        prev.next = retNode.next;
        retNode.next = null;
        size --;
        return retNode.e;
    }

    @Override
    public String toString() {
        StringBuilder res = new StringBuilder();
        Node cur = dummyHead.next;
        while (cur != null) {
            res.append(cur).append("->");
            cur = cur.next;
        }
        res.append("NULL");
        return res.toString();
    }


    // 删除元素
}


