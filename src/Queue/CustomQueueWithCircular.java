package Queue;

public class CustomQueueWithCircular {
    protected int[] arr;
    private static final int DEFAULT_SIZE=10;
    protected int end =0;
    protected int front=0;
    protected int size=0;

    public CustomQueueWithCircular(){
        this(DEFAULT_SIZE);
    }

    public CustomQueueWithCircular(int size){
        this.arr= new int[size];
    }

    /**
     * Inserts an element into the circular queue.
     * Places the item at the 'end' index. Instead of just incrementing 'end' and potentially
     * going out of bounds, it uses modulo operator (`end % arr.length`) to wrap around to
     * the beginning of the array if there is space.
     *
     * Time Complexity: O(1)
     */
    public boolean insert(int item)throws Exception{
        if (isFull()){
            throw new Exception("Queue is full");
        }
        arr[end++] = item;
        end=end%arr.length;
        size++;
        return true;
    }

    /**
     * Removes and returns the element at the 'front' of the queue.
     * Like insert, it uses the modulo operator to advance the 'front' pointer,
     * allowing it to wrap around correctly.
     * This avoids the O(N) shifting penalty of a standard array queue.
     *
     * Time Complexity: O(1)
     */
    public int remove() throws Exception{
        if (isEmpty()){
            throw new Exception("Queue is full");
        }
        int removed = arr[front++];
        front = front% arr.length;  // this is circular queue
        size--;
        return removed;
    }

    /**
     * Peeks at the front element without removing it.
     */
    public int front() throws Exception{
        if (isEmpty()){
            throw new Exception("Queue is empty");
        }

        return arr[front];
    }


    /**
     * Displays all elements currently in the circular queue from 'front' to 'end'.
     * It handles the wrap-around by using a counter and the modulo operator.
     *
     * Time Complexity: O(N) where N is current size of the queue.
     */
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
        CustomQueueWithCircular queue = new CustomQueueWithCircular();

        for (int i=1; i<=10; i++){
            queue.insert(i*5);
        }

        queue.Display();
        System.out.println(queue.remove());
        queue.Display();
    }
}
