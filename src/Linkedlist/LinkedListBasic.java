package Linkedlist;

public class LinkedListBasic {

    public static int size =0;

    public static void printL(Node head){
        while (head != null){
            System.out.print(head.data+"-->");
            size++;
            head=head.next;
        }
        System.out.println("NULL");
    }

    public static void printLR(Node head){
        if(head==null) {
            System.out.print("NULL -->");
            return;
        };
        System.out.print(head.data+"-->");
        printLR(head.next);
//        System.out.print("<--" + head.data);
    }

    public static class Node{
        int data;
        Node next;

        public Node(int data){
            this.data=data;
            next=null;
        }
    }

    Node head =null;
    Node tail = null;


    public static void main(String[] args) {

        Node n1 =  new Node(1);
        Node n2 =  new Node(2);
        Node n3 =  new Node(3);
        Node n4 =  new Node(4);
        Node n5 =  new Node(5);

        n1.next=n2;
        n2.next=n3;
        n3.next=n4;
        n4.next=n5;
        printL(n1);
        System.out.println("---------------------------");
        //temp → [1 | next] → [2 | next] → [3 | next] → [4 | next] → [5 | null]
        System.out.print(n1.data+"-->");
        System.out.print(n1.next.data+"-->");
        System.out.print(n1.next.next.data+"-->");
        System.out.print(n1.next.next.next.data+"-->");
        System.out.print(n1.next.next.next.next.data+"-->");
        System.out.println("NULL");

        System.out.println("-------------------------");

        Node temp = n1;
        while (temp != null){
            System.out.print(temp.data+"-->");
            temp=temp.next;
        }
        System.out.println("NULL");

        System.out.println("-----------------------R");
        printLR(n1);

        System.out.println("----------");
        System.out.println("Size of LinkedList it:- "+ size);
    }
}
