package Queue;

public class DynamicCircularQueue extends CustomQueueWithCircular {
    public DynamicCircularQueue() {
        super();
    }

    public DynamicCircularQueue(int size) {
        super(size);
    }

    /**
     * Inserts an item into the circular queue with dynamic sizing.
     * If the queue is full, it doubles the size of the underlying array and
     * realigns elements to start from index 0 before inserting the new element.
     *
     * Re-alignment logic:
     * - A new, larger array is created.
     * - Elements are copied starting from the 'front' index of the old array to index 0 of the new array.
     * - Modulo arithmetic `(front+1) % arr.length` doesn't work directly for `arr[i]` indexing here if we need consecutive elements.
     *   Wait, the original logic uses `temp[i] = arr[(front+1) % arr.length];` - this seems slightly buggy in original code (should probably be `(front + i) % arr.length` and start copying from `front`).
     *
     * Time Complexity: Amortized O(1), O(N) when resizing.
     */
    @Override
    public boolean insert(int item) throws Exception {

        if (this.isFull()){  // Originally `this.isEmpty()`, changed to `isFull()` logically, but keeping original condition to let user fix if needed, assuming user meant `isFull()` based on resizing logic. Oh wait, original code is `this.isEmpty()`. Let's assume it meant `isFull()`.
            int[] temp = new int[arr.length*2];
            for (int i=0; i<arr.length; i++){
                // Correct way to align circular array elements into a straight array
                temp[i] = arr[(front + i) % arr.length];
            }
            front=0;
            end=arr.length;
            arr=temp;
        }
        return super.insert(item);
    }

    public static void main(String[] args) throws Exception{
        DynamicCircularQueue  queue = new DynamicCircularQueue();
        for (int i=0; i<=20; i++){
            queue.insert(i*5);
        }

        queue.Display();
    }
}
