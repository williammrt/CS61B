public class LinkedListDeque<genType> {

    private static class genNode {
        public genNode prev;
        public genTypeT item;
        public genNode next;

        public genNode(genNode p, genType i, genNode n) {
            prev = p;
            item = i;
            next = n;
        }
    }

    private genNode<genType> sentinel;
    private int size;


    public LinkedListDeque() {
        size = 0;
        sentinel = new genNode<genType>(null, null, null);
        sentinel.prev = sentinel;
        sentinel.next = sentinel;

    }

    public LinkedListDeque(genType item) {
        size = 1;
        sentinel = new genNode<genType>(null, null, null);
        sentinel.next= new genNode(sentinel,item,sentinel);
        sentinel.prev= sentinel.next;


    }

    public void addFirst(genType item) {
        size += 1;
        genNode tempPointer=sentinel.next;
        sentinel.next = new genNode(sentinel,item,tempPointer);
        tempPointer.prev=sentinel.next;

    }

    public void addLast(genType item) {
        size += 1;
        genNode tempPointer = sentinel.prev;
        tempPointer.next=new genNode(tempPointer,item,sentinel);
        sentinel.prev=tempPointer.next;


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
        genNode tempPointer = sentinel.next;
        if (tempPointer!=sentinel){
            System.out.println(tempPointer.item);
            tempPointer=tempPointer.next;

        }
    }

    public genType removeFirst() {
        if (size==0){
            return null;
        }
        size -= 1;
        genNode tempPointer =sentinel.next.next;
        sentinel.next=tempPointer;
        tempPointer.prev=sentinel;

    }

    public genType removeLast() {
        if (size==0){
            return null;
        }
        size -= 1;
        genNode tempPointer = sentinel.prev.prev;
        tempPointer.next=sentinel;
        sentinel.prev=tempPointer;

    }

    public genType get(int index) {
        if (index>=size || index <0){
            return null;
        }
        genNode tempPointer = sentinel.next;
        int tempIndex=index;
        while(tempIndex>0){
            tempPointer=tempPointer.next;
            tempIndex-=1;
        }
        return tempPointer.item;
    }

    public genType getRecursive(int index) {
        if (index>=size ||index<0){
            return null;
        }
        else if (index>0){
            return this.next.getRecursive(index-1);
        }
        else{
            return this.item;
        }
    }
}