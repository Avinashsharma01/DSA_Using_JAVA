package BasicCode;

public class Factorial {
    public static void factUsingWhile(int n){
        int fact =1;
        int i=1;
        while (i<=n){
            fact=fact*i;
            i++;
        }
        System.out.println(fact);
    }

    public static void factUsingFor(int n){
        int fact=1;
        for (int i=1; i<=n; i++){
            fact*=i;
        }
        System.out.println(fact);
    }

    public static void factUsingDoWhile(int n){
        int fact =1;
        int i =1;
        do {
            fact=fact*i;
            i++;
        }while (i<=n);

        System.out.println(fact);
    }

    public static void main(String[] args) {
        factUsingWhile(5);
        factUsingFor(10);
        factUsingDoWhile(5);
    }
}
