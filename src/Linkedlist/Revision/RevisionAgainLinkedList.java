package Linkedlist.Revision;

public class RevisionAgainLinkedList {

    Node head = null;
    Node tail = null;
    int size = 0;


    public static class Node{
        int data;
        Node next;

        public Node(int data){
            this.data= data;
            this.next = null;
        }
    }


    public void AddF(int data){
        Node newNode = new Node(data);

        if (head == null){
            head=tail=newNode;
            size++;
            return;
        }

        newNode.next = head;
        head = newNode;
        size++;
    }

    public void removeF(){
        if (size==0){
            System.out.println("List is empty");
            return;
        }

        if (size==1){
            head = tail = null;
        }else {
            head = head.next;
        }
        size--;
    }

    public void addL(int data){
        Node  newNode = new Node(data);
        if (head==null){
            head=tail=newNode;
            size++;
            return;
        }

        newNode.next=tail;
        tail=newNode;
        size++;
    }

    public void removeL(){
        if (size==0){
            System.out.println("List is empty");
            return;
        }

        if (size==1){
            head=tail=null;
            size--;
            return;
        }else {

        }

    }
}
