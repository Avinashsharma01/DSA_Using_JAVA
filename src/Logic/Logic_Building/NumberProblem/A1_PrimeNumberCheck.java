package Logic.Logic_Building.NumberProblem;

public class A1_PrimeNumberCheck {
    public static void main(String[] args) {
        System.out.println(isPrime1(100000));
        System.out.println(isPrime2(100000));

    }

    public static boolean isPrime1(int n){
        if (n==0 || n==1){
            return false;
        }

        for (int i=2; i*i <=n; i++){
            if(n%i==0){
                return false;
            }
        }
        return true;
    }


    public static boolean isPrime2(int n){
        if (n==0 || n==1){
            return false;
        }

        for (int i=2; i<Math.sqrt(n); i++){
            if(n%i==0){
                return false;
            }
        }
        return true;
    }


}
