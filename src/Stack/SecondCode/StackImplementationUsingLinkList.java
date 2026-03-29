package Stack.SecondCode;

public class StackImplementationUsingLinkList {

    public static class Node{
        int data;
        Node next;

        Node(int data){
            this.data=data;
        }
    }

    public static class MyStack{
        Node head = null;
        int size=0;

        public void push(int data){
            Node newNode = new Node(data);
            newNode.next=head;
            head=newNode;
            size++;
        }

        public int pop(){
            if (head==null){
                System.out.println("Stack is empty");
                return -1;
            }

            int remove = head.data;
            head = head.next;
            return remove;
        }

        public int peak(){
            if (head==null){
                System.out.println("Stack is empty");
                return -1;
            }

            return head.data;
        }

        public boolean isEmpty(){
            return size == 0;
        }


        public void HelperRec(Node h){
            if (h == null) return;
            HelperRec(h.next);
            System.out.print(h.data+ " ");
        }

        public void display(){
            HelperRec(head);
        }


        public void displayRev(){
            Node temp = head;
            while (temp != null){
                System.out.print(temp.data+ " ");
                temp = temp.next;
            }
        }

        public int size(){
            return size;
        }
    }
    public static void main(String[] args) {
        MyStack stack = new MyStack();
        for (int i=1; i<=10; i++){
            stack.push(i);
        }

        stack.displayRev();
        System.out.println();
        stack.display();

        System.out.println();
        for (int i=1; i<=5; i++){
            System.out.println(stack.pop());
        }
        stack.display();


        System.out.println("-------------");
        System.out.println(stack.pop());
        System.out.println();

        stack.display();

    }
}
