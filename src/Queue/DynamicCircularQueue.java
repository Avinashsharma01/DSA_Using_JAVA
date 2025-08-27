package Queue;

public class DynamicCircularQueue extends CustomQueueWithCercular{
    public DynamicCircularQueue() {
        super();
    }

    public DynamicCircularQueue(int size) {
        super(size);
    }

    @Override
    public boolean insert(int item) throws Exception {

        if (this.isEmpty()){
            int[] temp = new int[arr.length*2];
            for (int i=0; i<arr.length; i++){
                temp[i] = arr[(front+1) %arr.length];
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
