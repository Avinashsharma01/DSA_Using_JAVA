package Linkedlist;

public class LL {

    private Node head;
    private Node tail;
    private int size;

    public LL() {
        this.size = 0;
    }


    public void insertFirst(int value){
        Node Newnode = new Node(value);
        Newnode.next=head;
        head=Newnode;

        if (tail==null){
            tail=head;
        }
        size++;
    }

    public void insertlast(int value){

        if (tail == null){
            insertFirst(value);
            return;
        }
        Node node = new Node(value);
        tail.next=node;
        tail=node;
        size++;
    }


    public void display(){
        Node temp = head;
        while (temp != null){
            System.out.print(temp.value+ " -> ");
            temp= temp.next;
        }
        System.out.println("END");
    }


    private class Node{
        private int value;
        private Node next;

        public Node(int value) {
            this.value = value;
        }
    }
}
