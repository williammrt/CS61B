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
        nextFirst = items.length - 1;
        nextLast = items.length / 2;
    }

    private void downSize() {
        T[] smaller = (T[]) new Object[items.length / 2];
        int startPos = (nextFirst + 1) % items.length;
        int endPos = (nextLast - 1 + items.length) % items.length;
        if (startPos < endPos) {
            System.arraycopy(items, startPos, smaller, 0, items.length);
        } else {
            System.arraycopy(items, startPos, smaller, 0, items.length - startPos);
            System.arraycopy(items, 0, smaller, items.length - startPos, endPos + 1);
        }


        /* missing*/
        items = smaller;
        nextFirst = items.length - 1;
        nextLast = items.length / 2;
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
        System.out.print("underlying: ");
        for (int i = 0; i < items.length; i++) {
            System.out.print(items[i]);
        }
        System.out.println();

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
        //if (size <= items.length / 4 && items.length / 4 >= 8) {
        //    downSize();
        // }
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
        // if (size <= (items.length / 4) && (items.length / 2) >= 8) {
        //    downSize();
        //}
        return retreive;

    }

    public T get(int index) {
        if (size == 0) {
            return null;
        }
        int actualIndex = (nextFirst + 1 + index) % items.length;
        return items[actualIndex];
    }

    /* public static void main(String[] args) {

        ArrayDeque<Integer> test1 = new ArrayDeque<Integer>();
        for (int i = 0; i < 8; i++) {
            test1.addLast(i);
        }
        test1.addFirst(9);
        test1.removeLast();
        test1.removeLast();
        test1.removeLast();
        test1.removeLast();
        test1.removeLast();
        test1.removeLast();
        test1.removeLast();

        ArrayDeque<Integer> test2 = new ArrayDeque<Integer>();
        test2.addFirst(0);
        test2.addFirst(1);
        test2.addFirst(2);
        test2.addLast(3);
        test2.addLast(4);
        test2.removeLast();
        test2.addLast(6);
        test2.get(4);
        test2.addFirst(8);
        test2.addFirst(9);
        test2.get(6);    // ==> 6
        test2.addFirst(11);
        test2.addLast(12);
        test2.removeLast(); //==> 12
        test2.removeFirst();//==> 11
        test2.get(4);// ==> 0
        test2.removeFirst();//  ==> 9
        test2.removeFirst(); // ==> 8
        test2.removeLast();


    }*/

}
