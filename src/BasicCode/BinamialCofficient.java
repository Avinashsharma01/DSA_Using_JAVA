package BasicCode;

public class BinamialCofficient {

    public static int Factorial(int n ){
        int fact =1;
        for (int i=1; i<=n; i++){
            fact*=i;
        }
        return fact;
    }

    public static int NCR(int n, int r){
        int a = Factorial(n);
        int b= Factorial(r);
        int c= Factorial(n-r);

        int total = a/(b*c);
        return total;
    }


    public static void main(String[] args) {
       int ncr=  NCR(3,2);
        System.out.println(ncr);
    }
}
