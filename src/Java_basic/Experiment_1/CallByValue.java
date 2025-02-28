package Java_basic.Experiment_1;

public class CallByValue {
    public static void change(int a){
        a=10;
    }

    public static void main(String[] args) {
        int a =5;
        change(a);
        System.out.println(a);
    }
}
