package Queue.again;

public class CircularQueueUsingArray {
    public static class Myqueue{
        int[] arr;
        int front =0;
        int rear = 0;
        int size =0;
        final int DEFAULT_SIZE = 5;

        public Myqueue(){
            this.arr = new int[DEFAULT_SIZE];
        }

        public Myqueue(int QueueSize){
            this.arr = new int[QueueSize];
        }


        /**
         * Inserts an element at the rear of the circular queue.
         * The `rear` index wraps around to 0 when it reaches the end of the array using modulo calculation.
         *
         * Time Complexity: O(1)
         */
        public boolean add(int data){
            if (isFull()){
                System.out.println("Queue is full");
                return false;
            }

            arr[rear] = data;
            rear = (rear+1) % arr.length;
            size++;
            return true;
        }

        /**
         * Removes and returns the element at the front of the circular queue.
         * The `front` index wraps around to 0 when it reaches the end of the array.
         *
         * Time Complexity: O(1) - avoiding O(N) shifting!
         */
        public int remove(){
            if (isEmpty()){
                System.out.println("Queue is empty");
                return -1;
            }

            int remove = arr[front];
            front = (front+1) % arr.length;
            size--;
            return remove;
        }

        /**
         * Peeks at the front element without removing it.
         */
        public int peek(){
            if (isEmpty()){
                System.out.println("Queue is empty");
                return -1;
            }

            return arr[front];
        }

        /**
         * Alternative display logic specifically handling wrap-around.
         */
        public void display1() {
            if (isEmpty()) {
                System.out.println("Queue is empty");
                return;
            }

            if (front < rear) {
                for (int i = front; i < rear; i++) {
                    System.out.print(arr[i] + " <-- ");
                }
            } else {
                for (int i = front; i < arr.length; i++) {
                    System.out.print(arr[i] + " <-- ");
                }

                for (int i = 0; i < rear; i++) {
                    System.out.print(arr[i] + " <-- ");
                }
            }

            System.out.println("END");
        }

        /**
         * Simpler logic to print elements using a counter.
         */
        public void display(){
            if (isEmpty()){
                System.out.println("Queue is full");
                return;
            }

            int i = front;
            int count =0;
            while (count < size){
                System.out.print(arr[i] + " <- ");
                i = (i+1) % arr.length;
                count++;
            }
            System.out.print("END");
        }

        public boolean isFull(){
            return size == arr.length;
        }

        public boolean isEmpty(){
            return size==0;
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
        q.remove();
//        System.out.println(q.size);
//
//        System.out.println(q.peek());

//        q.display();
        q.add(100);
        q.add(200);
        q.display();
    }
}
