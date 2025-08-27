package Stack;

public class DynamicStackUsingExtends extends StackAgain{
    public DynamicStackUsingExtends() {
        super();
    }

    public DynamicStackUsingExtends(int size) {
        super(size);
    }

    @Override
    public boolean push(int item) throws StackException {
        if (this.isFull()){
            int[] temp = new int[arr.length*2];

//            System.arraycopy(arr, 0, temp, 0, arr.length);
            for (int i=0; i<arr.length; i++){
                temp[i]=arr[i];
            }
            arr=temp;
        }
        return super.push(item);
    }

    public static void main(String[] args) throws StackException {
        DynamicStackUsingExtends stack = new DynamicStackUsingExtends();
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
        stack.push(140);
        stack.push(150);
        stack.push(160);
        stack.push(170);
        stack.push(180);
        stack.push(190);
        stack.push(200);
        stack.printStack();
    }
}
