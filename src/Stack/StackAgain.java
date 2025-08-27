package Stack;

public class StackAgain {
    protected int[] arr;
    private static final int DEFAULT_SIZE= 10;
    int ptr =-1;

    public StackAgain(){
        this(DEFAULT_SIZE);
    }

    public StackAgain(int size){
        this.arr = new int[size];
    }

    public boolean push(int item) throws StackException{
        if(isFull()){
            System.out.println("Stack is full");
            throw  new StackException("Stack is full");
//            return false;
        }
        ptr++;
        arr[ptr]=item;
        return true;

    }

    public int pop(){
        if(isEmpty()){
            System.out.println("Can not pop from empty stack");
        }

        return arr[--ptr];
    }

    public int peak(){
        if (isEmpty()){
            System.out.println("Can not peak from empty stack");
        }
        return arr[ptr];
    }

    public void printStack(){
        if (isEmpty()){
            System.out.println("Stack is empty");
        }
        for (int i=ptr; i>=0; i--){
            System.out.println(arr[i]);
        }
    }
    public boolean isFull() {
        return ptr == arr.length-1;
    }

    public boolean isEmpty(){
        return ptr == -1;
    }

    public static void main(String[] args) throws StackException {
        StackAgain stack = new StackAgain(13);

        stack.push(10);
        stack.push(20);
        stack.push(30);
        stack.push(40);
        stack.push(50);
        stack.push(60);
        stack.push(70);
        stack.push(80);
        stack.push(90);
        stack.push(100);
        stack.push(110);
        stack.push(120);
        stack.push(130);


        stack.printStack();
//        System.out.println(stack.peak());
    }
}
