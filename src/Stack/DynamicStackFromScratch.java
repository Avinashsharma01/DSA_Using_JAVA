package Stack;

public class DynamicStackFromScratch {
    protected int[] arr;
    private static final int DEFAULT_SIZE=10;
    int ptr =-1;

    public DynamicStackFromScratch() {
        this(DEFAULT_SIZE);
    }

    public DynamicStackFromScratch(int size) {
        this.arr= new int[size];
    }

    public boolean push(int item){
        if(isFull()){
            int[] temp = new int[arr.length*2];
            for (int i=0; i<arr.length; i++){
                temp[i]=arr[i];
            }

            arr=temp;
        }
        ptr++;
        arr[ptr]=item;
        return true;
    }

    public int pop() throws StackException{
        if (isEmpty()){
            System.out.println("Can not pop from empty stack");
            throw new StackException("Can not pop from empty stack");
        }

        return arr[ptr--];
    }

    public int peek() throws StackException{
        if (isEmpty()){
            System.out.println("Can not peak from empty stack");
            throw new StackException("Can not peak from empty stack");
        }
        return arr[ptr];
    }

    public void printStack(){
        if(isEmpty()){
            System.out.println("Stack is empty");
            return;
        }
        for(int i=ptr; i>=0; i--){
            System.out.println(arr[i]);
        }
    }

    public boolean isEmpty(){
        return ptr==-1;
    }

    public boolean isFull(){
        return ptr==arr.length-1;
    }

    public static void main(String[] args) {
        DynamicStackFromScratch stack = new DynamicStackFromScratch();

        for (int i=1; i<=10; i++){
            stack.push(i*10);
        }

        stack.printStack();
    }
}
