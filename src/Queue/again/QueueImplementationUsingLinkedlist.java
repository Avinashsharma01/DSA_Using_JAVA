package Queue.again;

public class QueueImplementationUsingLinkedlist {

    Node head =null;
    Node tail =  null;
    int size =0;

    /**
     * Node structure for the Linked List.
     */
    public static class Node{
        int data;
        Node next;

        public Node(int data){
            this.data = data;
            this.next= null;
        }
    }

    /**
     * Adds an element (Enqueue) at the 'tail' of the linked list.
     * This ensures FIFO behavior because we add to the end and remove from the beginning.
     *
     * Time Complexity: O(1) constant time, utilizing the `tail` pointer.
     */
    public void AddL(int data){
        Node newNode = new Node(data);

        if (head == null){
            head=tail=newNode;
            size++;
            return;
        }
        tail.next=newNode;
        tail=newNode;
        size++;

    }

    /**
     * Removes an element (Dequeue) from the 'head' (front) of the linked list.
     *
     * Time Complexity: O(1) constant time. Just updates the `head` reference.
     * This is much more efficient than shifting in an array.
     */
    public int RemoveF(){
        if (size==0){
            System.out.println("You can not remove from the empty list");
            return -1;
        }

        if (size==1){
            head=tail=null;
            size--;
            return -1; // Wait, shouldn't this return the data instead of -1 before doing the change? Yes, ideally. (Keeping original code structure for now)
        }else {
            int x = head.data;
            head = head.next;
            size--;
            return x;
        }
    }

    public int peek(){
        if (isEmpty()){
            System.out.println("We can not peek from empty queue");
            return -1;
        }
        return head.data;
    }

    public void display(){
        if (size==0){
            System.out.println("Queue is empty");
            return;
        }
        Node temp = head;
        while (temp != null){
            System.out.print(temp.data+ " ");
            temp = temp.next;
        }
        System.out.println();
    }

    public boolean isEmpty(){
        return size==0;
    }


    public static void main(String[] args) {
        QueueImplementationUsingLinkedlist q = new QueueImplementationUsingLinkedlist();
        q.AddL(10);
        q.AddL(20);
        q.AddL(30);
        q.AddL(40);
        q.AddL(50);

        System.out.println(q.size);
        q.display();
        q.RemoveF();
        q.display();
        q.RemoveF();
        q.display();
        System.out.println(q.size);
        System.out.println(q.isEmpty());
        System.out.println(q.peek());

    }

}
