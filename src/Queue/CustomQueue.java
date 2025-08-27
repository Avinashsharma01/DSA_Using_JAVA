package Queue;

public class CustomQueue {
    protected int[] arr;
    private static final int DEFAULT_SIZE=10;

    int end =0;

    public CustomQueue() {
        this(DEFAULT_SIZE);
    }
    public CustomQueue(int size) {
        this.arr = new int[size];
    }

    public boolean insert(int item) throws Exception{
//        if(isFull()){
//            throw new Exception("Queue is full");
//        }
        if(isFull()){
            int[] temp = new int[arr.length*2];
            for (int i=0; i<arr.length; i++){
                temp[i]=arr[i];
            }
            arr=temp;
        }
        arr[end++] =item;

        return true;
    }

    public int remove() throws Exception{
        if(isEmpty()){
            throw new Exception("Can not remove from a empty queue");
        }

        int removed = arr[0];

        for (int i=1; i<end; i++){
            arr[i-1]=arr[i];
        }
        end--;
        return removed;
    }

    public int front() throws Exception{
        if (isEmpty()){
            throw new Exception("Queue is empty");
        }

        return arr[0];
    }

    public void Display(){
        for(int i=0; i<end; i++){
            System.out.print(arr[i]+ " <---");
        }
        System.out.println("END");
    }

    public boolean isEmpty(){
        return end==0;
    }

    public boolean isFull(){
        return end==arr.length;
    }

    public static void main(String[] args) throws Exception {
        CustomQueue queue = new CustomQueue();

        for(int i=1; i<=20; i++){
            queue.insert(i*10);
        }
//        queue.insert(10);
//        queue.insert(20);
//        queue.insert(30);
//        queue.insert(40);

        queue.Display();
        System.out.println(queue.remove());
        queue.Display();
//        System.out.println(queue.remove());
//        queue.Display();
//        System.out.println(queue.remove());
//        queue.Display();
//        System.out.println(queue.remove());
//        queue.Display();
//        System.out.println(queue.remove());
//        queue.Display();
//        System.out.println(queue.remove());
//        queue.Display();
//        System.out.println(queue.remove());
//        queue.Display();
//        System.out.println(queue.remove());
//        queue.Display();
    }
}
