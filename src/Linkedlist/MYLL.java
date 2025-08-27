package Linkedlist;

public class MYLL {

    private Node head;
    private Node tail;
    private int size;

    public MYLL(){
        this.size=0;
    }

    // This is The Node
    public static class Node{
        int data;
        Node next;

        public Node(int value){
            this.data=value;
            this.next=null;
        }
    }


    // Add First element
    public void addFirst(int value){
        Node newNode= new Node(value);
        newNode.next=head;
        head=newNode;

        if (tail == null){
            tail=head;
        }

        size++;
    }

    public void addFirst2(int value){
        Node newNode = new Node(value);
        if (head == null){
            head=tail=newNode;
            return;
        }

        newNode.next=head;
        head=newNode;
        size++;
    }

    public void addLast(int value){

        if (tail==null){
            addFirst(value);
            return;
        }
        Node newNode = new Node(value);
        tail.next=newNode;
        tail=newNode;
        size++;
    }

    public void addLast2(int value){
        Node newNode = new Node(value);
        if (head==null){
            head =tail=newNode;
            return;
        }
        tail.next=newNode;
        tail=newNode;
        size++;
    }

    public void Display(){
        Node temp =head;
        while (temp != null){
            System.out.print(temp.data+ " -> ");
            temp= temp.next;
        }
        System.out.println("END");
        System.out.println("List Size is:- "+  size);
    }


    public static void main(String[] args) {
        MYLL myll = new MYLL();
        System.out.println(myll.head);
        System.out.println(myll.tail);

        myll.addFirst(1);
        myll.addFirst(2);
        myll.addFirst2(3);
        myll.addFirst(200);
        myll.addLast(0);
        myll.addLast2(100);

        myll.Display();
    }

}
