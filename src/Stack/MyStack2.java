package Stack;

import java.util.Stack;

public class MyStack2 {
    public static void main(String[] args) {
        Stack<Integer> st1 = new Stack<>();
        Stack<Integer> st2 = new Stack<>();
        Stack<Integer> st3 = new Stack<>();

        st1.push(1);
        st1.push(2);
        st1.push(3);
        st1.push(4);
        st1.push(5);
        st1.push(6);

        System.out.println(st1);
        System.out.println(st1.size());


//        while (!st1.isEmpty()){
//            st2.push(st1.pop());
//        }
//        System.out.println("st-1 "+ st1);
//        System.out.println("st-2 "+ st2);


//        while (st2.size()>0){
//            int data = st2.pop();
//            System.out.println("I am Printing St-1:- "+ data);
//            st1.push(data);
//        }


        // with array
        int n= st1.size();
        int[] arr = new int[n];

        for (int i=0; i<n; i++){
            arr[i]=st1.pop();
        }
        System.out.println("---------------");

        for (int num: arr){
            System.out.println(num);
        }
        System.out.println(st1);

        System.out.println("--------------");

        for (int i=0; i<arr.length; i++){
            st1.push(arr[i]);
        }

        System.out.println(st1);


//        while (st2.size()> 0){
//            st3.push(st2.pop());
//        }
//
//        System.out.println("st-2 "+ st2);
//        System.out.println("st-3 "+ st3);
//
//
//        while (st3.size()> 0){
//            st1.push(st3.pop());
//        }
//
//        System.out.println("st-1 "+ st1);
//        System.out.println("st-3 "+ st3);

    }
}
