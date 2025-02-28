package BasicCode;

public class OverLoading {
    public static void add(int a){
        System.out.println(a);
    }
    public static void add(int a, int b){
        System.out.println(a+b);
    }
    public static void add(float a, float b){
        System.out.println(a+b);
    }

    public static void main(String[] args) {
        add(5);
        add(3,4);
        add(3.3f, 4.5f);
    }
}
