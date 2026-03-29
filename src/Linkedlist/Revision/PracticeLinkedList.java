package Linkedlist.Revision;

/***
 * 🧠 Pattern you should remember forever
 * Every linked list operation is based on ONE rule:
 * Find the correct node → change links → update head/tail/size if needed
 * If you internalize these comments, you won’t need to memorize code.
 *
 */
public class PracticeLinkedList {
    Node head=null;
    Node tail= null;
    int size=0;

    public static class Node{
        int data;
        Node next;

        public Node(int data){
            this.data=data;
            next=null;
        }
    }


    // Always connect the new node to the existing list BEFORE moving head.
    public void AddF(int data){
        Node newNode = new Node(data);
        if (head == null){
            head=tail=newNode;
            size++;
            return;
        }

        newNode.next=head;
        head=newNode;
        size++;
    }

    public void RemoveF(){
        if (size==0){
            System.out.println("List is Empty");
            return;
        }

        if (size==1){
            head=tail=null;
        }else {
            head=head.next;
        }
        size--;
    }

    //Hold the chain, then attach yourself
    public void AddAt(int index, int data){

        if (index< 0 && index > size){
            System.out.println("Invalid index");
            return;
        }

        if (index==0){
            AddL(data);
            return;
        }
        if (index==size){
            AddL(data);
            return;
        }

        Node newNode = new Node(data);
        Node temp = head;// at this moment temp is index 0
        // Stop at the node just BEFORE the index
        for (int i=0; i<index-1; i++){
            // [0 | 5]->[1 | 4]->[2 | 3]->[3 | 2]->[4 | 1]->
            temp=temp.next;  // at this moment temp will become index 1
        }

        newNode.next=temp.next; // Hold the chain
        temp.next=newNode; //then attach yourself


    }


    public void RemoveAt(int index){
        if (index < 0 || index >= size) {
            System.out.println("Invalid Index");
            return;
        }

        // Remove first node
        if (index == 0) {
            RemoveF();
            return;
        }

        // Remove last node
        if (index == size - 1) {
            RemoveL();
            return;
        }


        Node temp =head;

        for (int i=0; i<index-1; i++){
            temp=temp.next;
        }

        temp.next=temp.next.next;
        size--;


    }

    public void AddL(int data){
        Node newNode = new Node(data);

        if (head==null){
            head=tail=newNode;
            size++;
            return;
        }

        tail.next=newNode;
        tail=newNode;
        size++;
    }

    public void RemoveL(){
        if (size==0){
            System.out.println("List is Empty");
            return;
        }

        if (size==1){
            head=tail=null;
            size--;
            return;
        }

        Node temp = head;
        while (temp.next != tail){
            temp=temp.next;
        }
        temp.next=null;
        tail=temp;
        size--;

    }

    public void ReverseLL() {
        Node previous = null;
        Node current = head;

        // After reversal, the original head will become the last node,
        // so we store it as the new tail before changing any links
        tail = head;

        while (current != null) {
            Node next = current.next;   // save next node before breaking the link
            current.next = previous;    // reverse the link
            previous = current;         // move previous forward
            current = next;             // move current forward
        }

        // 'previous' now points to the original tail,
        // which becomes the new head of the reversed list
        head = previous;
    }

    public int getNthFromEnd(int nth){

        Node slow = head;
        Node fast = head;

        for (int i=0; i<nth; i++){
            fast=fast.next;
        }

        while (fast != null){
            slow = slow.next;
            fast= fast.next;
        }


        return slow.data;

    }

    public void PrintL(){
        Node temp = head;
        while (temp!= null){
            System.out.println(temp.data+" ");
            temp=temp.next;
        }
    }

    public int Length(){
        return size;
    }

    public static void main(String[] args) {
        PracticeLinkedList list = new PracticeLinkedList();
        for (int i=1; i<=5; i++){
            list.AddF(i);
        }
        list.PrintL();

//        System.out.println("Size of LinkedList:- "+list.Length());
//
//        list.AddAt(2, 100);
//
//        System.out.println("---------------");
////        list.RemoveF();
////        list.RemoveL();
//        list.PrintL();
//        list.RemoveAt(2);
//        System.out.println("------------------");
//        list.PrintL();
//
//
//        System.out.println("-----------------------");
//        list.ReverseLL();
//        list.PrintL();

        //------------------------------//

        System.out.println("-----------------------");

        int data = list.getNthFromEnd(2);
        System.out.println(data);



    }
}
