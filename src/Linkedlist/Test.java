package Linkedlist;

public class Test {

    public static void main(String[] args) {
        LL list = new LL();

//        for (int i = 1; i <= 10; i++) {
//            list.insertFirst(i * 10);
//        }
//
//        list.display();


        for (int i=1; i<=10; i++){
            list.insertlast(i*10);
        }
        list.display();
    }
}
