public class ArrayDeque<T> {

    private int size;
    private T[] items;
    private int nextFirst;
    private int nextLast;

    public ArrayDeque() {
        items = (T[]) new Object[8];
        size = 0;
        nextFirst = 7;
        nextLast = 0;
    }

    private void upSize() {
        T[] bigger = (T[]) new Object[items.length * 2];
        /* missing*/
        int startPos = (nextFirst + 1) % items.length;
        if (startPos == 0) {
            System.arraycopy(items, 0, bigger, 0, items.length);
        } else {

            System.arraycopy(items, startPos, bigger, 0, items.length - startPos);
            System.arraycopy(items, 0, bigger, items.length - startPos, startPos);
        }


        items = bigger;
    }

    private void downSize() {
        T[] smaller = (T[]) new Object[items.length / 2];


        /* missing*/
        items = smaller;
    }

    public void addFirst(T item) {
        /* check size for resizing,when size is full, upsize*/
        if (size == items.length) {
            upSize();
        }
        size += 1;
        items[nextFirst] = item;

        /* check this change nextFirst algorithms*/
        nextFirst = (nextFirst - 1 + items.length) % items.length;


    }

    public void addLast(T item) {
        /* check size for resizing, when size is full, upsize*/
        if (size == items.length) {
            upSize();
        }
        size += 1;
        items[nextLast] = item;
        /* check this change nextLast algorithms*/
        nextLast = (nextLast + 1) % items.length;
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

    }

    public T removeFirst() {
        if (size == 0) {
            return null;
        }
        size -= 1;
        int retreivePos = (nextFirst + 1) % items.length;
        T retreive = items[retreivePos];
        items[retreivePos] = null;
        nextFirst = retreivePos;
        return retreive;

    }

    public T removeLast() {
        if (size == 0) {
            return null;
        }
        size -= 1;
        int retreivePos = (nextLast - 1 + items.length) % items.length;
        T retreive = items[retreivePos];
        items[retreivePos] = null;
        nextLast = retreivePos;
        return retreive;

    }

    public T get(int index) {
        if (size == 0) {
            return null;
        }
        int actualIndex = (nextFirst + 1 + index) % items.length;
        return items[actualIndex];
    }

}
