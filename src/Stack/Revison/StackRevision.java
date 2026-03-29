package Stack.Revison;

public class StackRevision {

    protected int[] arr;
    private static final int DEFAULT_SIZE =10;
    int idx = -1;

    public StackRevision(){
        this.arr = new int[DEFAULT_SIZE];
    }

    public StackRevision(int size){
        this.arr = new int[size];
    }


    public boolean push(int data){
        if (isFull()){
            resizeArr();
        }
        idx++;
        arr[idx] =data;
        return true;
    }

    private void resizeArr(){
        int[] newArr = new int[arr.length*2];
        for (int i=0; i<arr.length; i++){
            newArr[i] = arr[i];
        }

        arr = newArr;
    }


    public int pop(){
        if (isEmpty()){
            System.out.println("Stack is empty");
            throw new IllegalStateException("Stack is empty");
        }

        int remove = arr[idx];
        idx--;
        return remove;
    }

    public int peak(){
        if (isEmpty()){
            System.out.println("Stack is empty");
            throw new IllegalStateException("Stack is empty");
        }
        return arr[idx];
    }




    public void display(){
        for (int i=0; i<=idx; i++){
            System.out.println(arr[i]);
        }
    }
    public boolean isFull(){
        return idx == arr.length-1;
    }

    public boolean isEmpty(){
        return idx == -1;
    }

    public int size(){
        return idx+1;
    }




    public static void main(String[] args) {
        StackRevision stack = new StackRevision();
        for (int i=1; i<=10; i++){
            stack.push(i);
        }

        stack.display();

        System.out.println("Peaked:- "+stack.peak());
        System.out.println("Popped:- "+stack.pop());

        stack.display();

        System.out.println("Size:- "+stack.size());

        StackRevision stack1 = new StackRevision();

        System.out.println("----++Second Stack object start from here++----");
        for (int i=1; i<=200; i++){
            stack1.push(i);
        }

        stack1.display();
    }
}
