package Stack;

public class CustomStack {
    protected int[] arr;
    private static final int DEFAULT_SIZE=10;
    int ptr =-1;


    public CustomStack(){
        this(DEFAULT_SIZE);
    }

    public CustomStack(int size){
        this.arr=new int[size];
    }

    public boolean push(int item){
        if (isFull()){
            System.out.println("Stack is full");
            return false;
        }
        ptr++;
        arr[ptr]=item;
        return true;
    }

    public int pop() throws StackException {
        if (isEmpty()){
            throw new StackException("Can not pop from an empty array");
        }
//        int removed = arr[ptr];
//        ptr--;
//        return removed;

        return arr[ptr--];
    }

    public int peak() throws StackException{
        if (isEmpty()){
            throw new StackException("Can not peak from an empty array");
        }
        return arr[ptr];
    }

    public void printStack(){
        if(isEmpty()){
            System.out.println("Stack is empty");
            return;
        }
        for(int i= ptr; i >=0; i--){
            System.out.println(arr[i]);
        }
    }


    public boolean isFull(){
        return ptr == arr.length-1;
    }

    public boolean isEmpty(){
        return ptr == -1;
    }


    public static void main(String[] args) throws StackException {
        CustomStack stack = new CustomStack();
        stack.push(10);
        stack.push(20);
        stack.push(30);
        stack.push(40);
        stack.push(50);
        stack.push(60);
        stack.push(70);
        System.out.println("Popped"+stack.pop());
        System.out.println("Popped"+stack.pop());
        System.out.println("Popped"+stack.pop());


        stack.printStack();

    }
}
