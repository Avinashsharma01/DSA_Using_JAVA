package Queue;

public class CustomQueueWithCercular {
    protected int[] arr;
    private static final int DEFAULT_SIZE=10;
    protected int end =0;
    protected int front=0;
    protected int size=0;

    public CustomQueueWithCercular(){
        this(DEFAULT_SIZE);
    }

    public CustomQueueWithCercular(int size){
        this.arr= new int[size];
    }

    public boolean insert(int item)throws Exception{
        if (isFull()){
            throw new Exception("Queue is full");
        }
        arr[end++] = item;
        end=end%arr.length;
        size++;
        return true;
    }

    public int remove() throws Exception{
        if (isEmpty()){
            throw new Exception("Queue is full");
        }
        int removed = arr[front++];
        front = front% arr.length;
        size--;
        return removed;
    }

    public int front() throws Exception{
        if (isEmpty()){
            throw new Exception("Queue is empty");
        }

        return arr[front];
    }


    public void Display() throws Exception{
       if (isEmpty()){
           throw new Exception("Queue is empty");
       }
//       int i=front;
//       do {
//           System.out.print(arr[i]+ "<-- ");
//           i++;
//           i=i%arr.length;
//       }while (i!=end);
//        System.out.println("END");


        int count = 0;
        int i = front;

        while (count < size) {
            System.out.print(arr[i] + " <--- ");
            i = (i + 1) % arr.length;
            count++;
        }
        System.out.println("END");

    }



    public boolean isEmpty(){
        return size==0;
    }
    public boolean isFull(){
        return size==arr.length;
    }

    public static void main(String[] args) throws Exception{
        CustomQueueWithCercular queue = new CustomQueueWithCercular();

        for (int i=1; i<=10; i++){
            queue.insert(i*5);
        }

        queue.Display();
        System.out.println(queue.remove());
        queue.Display();
    }
}
