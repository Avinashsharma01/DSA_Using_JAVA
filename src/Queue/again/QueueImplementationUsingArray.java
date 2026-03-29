package Queue.again;

public class QueueImplementationUsingArray {

    public static class Myqueue{
        int front = 0;
        int rear = 0;
        protected int size =0;
        final int DEFAULT_SIZE = 10;
        int[] arr;

        public Myqueue(){
            this.arr = new int[DEFAULT_SIZE];
        }

        public Myqueue(int size){
            this.arr = new int[size];
        }

        /**
         * Adds an element to the rear of the regular array queue.
         *
         * Time Complexity: O(1)
         * Drawback: Once the array fills up, it cannot be reused even if elements
         * are removed from the front (unless elements are shifted back).
         */
        public boolean add(int data){
            if (isFull()){
                System.out.println("You can not add into full Queue");
            }
            arr[rear++] = data;
            size++;
            return true;
        }

        /**
         * Removes an element from the front by simply incrementing the `front` pointer.
         *
         * Time Complexity: O(1)
         * This avoids O(N) shifting but leads to "false full" situations where `rear`
         * reaches the end but `front` has advanced, leaving unused space.
         */
        public int remove(){
            if (isEmpty()){
                System.out.println("You can not remove from empty Queue");
                return -1;
            }
            int removed = arr[front];
            front++;
            size--;
            return removed;
        }

        public int peek(){
            if (isEmpty()){
                System.out.println("You can not peek from the empty queue");
                return -1;
            }
            return arr[front];
        }

        public void display(){
            if (isEmpty()){
                System.out.println("Queue is empty");
                return;
            }
            for (int i = front; i<rear-1; i++){
                System.out.print(arr[i]+" <--");
            }
            System.out.println(arr[rear-1]);
        }

        public boolean isEmpty(){
            return size==0;
        }
        public boolean isFull(){
            return size==arr.length;
        }
    }

    public static void main(String[] args) {
        Myqueue q = new Myqueue();
        q.add(10);
        q.add(20);
        q.add(30);
        q.add(40);
        q.add(50);

//        System.out.println(q.size);
//        q.remove();
//        System.out.println(q.size);
//        System.out.println(q.peek());


        q.display();
        System.out.println(q.peek());
    }
}
