package Linkedlist.Revision;

public class LinkedList {

    int size =0;

    // Node Schema
    static class Node{
        int data;
        Node next;

        Node(int data){
            this.data=data;
            this.next=null;
        }
    }

    // Head and Tail references
    private Node head = null;
    private Node tail = null;

    // O(n) insertion time
    public void Add(int value){
        Node newNode = new Node(value);
        // first node created | first node becomes head.
        if (head==null){
            head=newNode;
            size++;
            return;
        }

        Node current = head;
        while (current.next != null){
            current=current.next;
        }
        current.next=newNode;
        size++;
    }


    // O(1) insertion time
    public void AddOneL(int data){
        Node newNode = new Node(data);

        if (head==null){
            head=tail=newNode;
            size++;
            return;
        }

        //append at end
        tail.next = newNode;
        tail=newNode;
        size++;
    }

    public void AddOneB(int index, int data){
        if (index< 0 && index> size){
            System.out.println("Index is Invalid");
            return;
        }

        if(index ==0){
            AddOneF(data);
            size++;
            return;
        }

        if (index==size){
            AddOneL(data);
            size++;
            return;
        }

        Node newNode = new Node(data);
        Node temp = head;

        for (int i=0; i<index-1; i++){
            temp=temp.next;
        }

        newNode.next= temp.next;
        temp.next=newNode;
        size++;

    }

    public void AddOneF(int data){
        Node newNode = new Node(data);

        if (head==null){
            head=tail=newNode;
            return;
        }
        newNode.next= head;
        head=newNode;

    }



    public void printLL(){
        Node current = head;

        while (current != null){
            System.out.print(current.data + " -> ");
            current=current.next;// move forward
        }

        System.out.println("NULL");
    }


    public static void main(String[] args) {
        LinkedList list = new LinkedList();

        for (int i=1; i<=100; i++){
            list.AddOneL(i);
        }

        list.AddOneF(1000);
        list.AddOneF(100);

        list.AddOneB(40, 112345);
        list.printLL();



    }

}
