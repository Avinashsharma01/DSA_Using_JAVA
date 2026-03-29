package Stack.SecondCode;

public class StackImplementationUsingArr {
    public static class MyStack{
        protected int[] arr;
        private static final int DEFAULT_SIZE=10;
        int idx =-1;

        public MyStack(){
            this.arr= new int[DEFAULT_SIZE];
        }

        public MyStack(int size){
            this.arr= new int[size];
        }

        public boolean push(int data){
            if (isFull()){
                System.out.println("You Can't Push | Stack is Full");
                throw new IllegalStateException("You Can't Push | Stack is Full");
            }
            idx++;
            arr[idx]=data;
            return true;
        }

        public int pop(){
            if (isEmpty()){
                System.out.println("Stack is empty");
                throw new IllegalStateException("Stack is empty");
            }
            int remove = arr[idx];
            idx--;
            return remove;
//            return arr[ptr--];
        }

        public int peak(){
            if (isEmpty()){
                System.out.println("Stack is empty");
                throw new IllegalStateException("Stack is empty");
            }

            return arr[idx];
        }

        public void Display(){
            for (int i=0; i<= idx; i++){
                System.out.println(arr[i]);
            }
        }
        public boolean isFull(){
            return idx== arr.length-1;
        }

        public boolean isEmpty(){
            return idx==-1;
        }

        public int size(){
            return idx+1;
        }


    }


    public static class AviStack{
        protected int[] arr;
        private static final int DEFAULT_SIZE=10;
        int idx = -1;

        public AviStack(){
            this.arr = new int[DEFAULT_SIZE];
        }

        public AviStack(int size){
            this.arr = new int[size];
        }


        public boolean push(int data){
            if (isFull()){
                System.out.println("You can not Insert into Full Stack");
            }

            idx++;
            arr[idx] =data;
            return true;
        }

        public int pop(){
            if (isEmpty()){
                System.out.println("You can not pop from an empty stack");
            }

            int remove = arr[idx];
            idx--;
            return remove;
            // return arr[idx--];
        }

        public int peak(){
            if (isEmpty()){
                System.out.println("You can not peak from an empty stack");
            }
            return arr[idx];
        }

        public void Display(){
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

    }
    public static void main(String[] args) {
//        MyStack st = new MyStack();
//        st.push(1);
//        st.push(2);
//        st.push(3);
//        st.push(4);
//        st.push(5);
//
//        st.Display();
//
//        int removed= st.pop();
//        System.out.println("removed Data "+ removed);
//
//        st.Display();
//
//        System.out.println("Peaked Element "+st.peak());
//        System.out.println("I am the size of an Stack "+st.size());


        System.out.println("---------------------------------------");
        AviStack avi = new AviStack(15);
        avi.push(10);
        avi.push(20);
        avi.push(30);
        avi.push(40);
        avi.push(50);
        avi.push(60);
        avi.push(70);
        avi.push(80);
        avi.push(90);
        avi.push(100);
        avi.push(110);


        avi.Display();
    }
}
