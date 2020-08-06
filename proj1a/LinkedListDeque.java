public class LinkedListDeque<T>{

    private static class genNode<insideT>{
        public genNode prev;
        public insideT item;
        public genNode next;
        
        public genNode(insideT i,genNode n){
            item = i;
            next=n;
        }
    }

    private genNode<T> sentinel;
    private genNode<T> last;
    private int size;


    public LinkedListDeque(){
        size=0;
    }
    public LinkedListDeque(T item){
        size=1;
    }

    public void addFirst(T item){
        size+=1;
    }
    public void addLast(T item){
        size+=1;
        last.next = new genNode<T>(item,null);
        last = last.next;



    }
    public boolean isEmpty(){
        if (size==0){
            return true;
        }
        return false;
    }

    public int size() {
        return size;
    }

    public void printDeque(){}
    public T removeFirst(){
        size-=1;
    }
    public T removeLast(){
        size-=1;
    }
    public T get(int index){}
    public T getRecursive(int index){}
}