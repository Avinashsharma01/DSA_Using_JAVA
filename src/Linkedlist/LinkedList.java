package Linkedlist;

public class LinkedList {

    // Node class
    static class Node{
        int data;
        Node next;

        Node(int data){
            this.data=data;
            this.next=null;
        }
    }

    Node head = null;

    // add a node to the end
    public void add(int data){
        Node newNode = new Node(data);

        if (head==null){
            head=newNode;
            return;
        }
        Node current = head;
        while (current.next != null){
            current=current.next;
        }

        current.next=newNode;
    }

    //print the list
    public void printList(){
        Node current= head;
        while (current!=null){
            System.out.print(current.data + " -> ");
            current = current.next;
        }
        System.out.println("null");
    }

    public static void main(String[] args) {
        LinkedList list = new LinkedList();

        for(int i=1; i<=10; i++){
            list.add(i);
        }

        list.printList();

    }
}
