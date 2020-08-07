public class LinkedListDeque<T> {

    private class GenNode {
        private GenNode prev;
        private T item;
        private GenNode next;

        public GenNode(GenNode p, T i, GenNode n) {
            prev = p;
            item = i;
            next = n;
        }
    }

    private GenNode sentinel;
    private int size;


    public LinkedListDeque() {
        size = 0;
        sentinel = new GenNode(null, null, null);
        sentinel.prev = sentinel;
        sentinel.next = sentinel;

    }

    /**
     * public LinkedListDeque(T item) {
     * size = 1;
     * sentinel = new GenNode(null, null, null);
     * sentinel.next = new GenNode(sentinel, item, sentinel);
     * sentinel.prev = sentinel.next;
     * <p>
     * <p>
     * }
     */

    public void addFirst(T item) {
        size += 1;
        GenNode tempPointer = sentinel.next;
        sentinel.next = new GenNode(sentinel, item, tempPointer);
        tempPointer.prev = sentinel.next;

    }

    public void addLast(T item) {
        size += 1;
        GenNode tempPointer = sentinel.prev;
        tempPointer.next = new GenNode(tempPointer, item, sentinel);
        sentinel.prev = tempPointer.next;


    }

    public boolean isEmpty() {
        if (size == 0) {
            return true;
        }
        return false;
    }

    public int size() {
        return size;
    }

    public void printDeque() {
        GenNode tempPointer = sentinel.next;
        if (tempPointer != sentinel) {
            System.out.println(tempPointer.item);
            tempPointer = tempPointer.next;

        }
    }

    public T removeFirst() {
        if (size == 0) {
            return null;
        }
        size -= 1;
        T tempItem = sentinel.next.item;
        GenNode tempPointer = sentinel.next.next;
        sentinel.next = tempPointer;
        tempPointer.prev = sentinel;
        return tempItem;

    }

    public T removeLast() {
        if (size == 0) {
            return null;
        }
        size -= 1;
        T tempItem = sentinel.prev.item;
        GenNode tempPointer = sentinel.prev.prev;
        tempPointer.next = sentinel;
        sentinel.prev = tempPointer;
        return tempItem;


    }

    public T get(int index) {
        if (index >= size || index < 0) {
            return null;
        }
        GenNode tempPointer = sentinel.next;
        int tempIndex = index;
        while (tempIndex > 0) {
            tempPointer = tempPointer.next;
            tempIndex -= 1;
        }
        return tempPointer.item;
    }

    public T getRecursive(int index) {
        if (index >= size) {
            return null;
        }
        if (index == 0) {
            return sentinel.item;
        }
        return sentinel.next.getRecursive(index - 1);

    }


}
