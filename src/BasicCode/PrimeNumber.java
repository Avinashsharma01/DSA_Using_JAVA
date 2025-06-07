package BasicCode;

public class PrimeNumber {
    public static boolean CheckPrime(int n){
        if(n<=1){
            return false;
        }
        //for (int i = 2; i <= Math.sqrt(n); i++)

        for (int i=2; i*i<=n; i++){  // 2 4, 9 ,16, 25
            if (n%i==0){
                return false;
            }
        }

        // method 1
//        for (int i=2; i<=n-1; i++){
//            if (n%i==0){
//                return false;
//            }
//        }

        // method-2
//        for (int i=2; i<=n; i++){
//            if (n % i==0){
//                if (i==n){
//                    return true;
//                }
//                return false;
//            }
//        }

        //  method -3
//        for (int i=2; i<=n; i++){
//            if (i==n){
//                return true;
//            }
//            if (n % i==0){
//
//                return false;
//            }
//        }
        return true;
    }


    public static void PrimeINrange(int n){
        for (int i=2; i<=n; i++){
            if (CheckPrime(i)){
                System.out.println(i+ " is prime number");
            }
        }
    }

    public static void PrimeNumberBetween(int start, int end){
       for (int num = start; num<=end; num++){
           if (CheckPrime(num)){
               System.out.println(num + " is prime number");
           }
       }
    }
    public static void main(String[] args) {
        int n=47;
        if (CheckPrime(n)){
            System.out.println(n +" = This is prime number");
        }else {
            System.out.println(n +" = This is not prime number");
        }

        System.out.println(Math.sqrt(5.0)); // testing of sqrt

        PrimeINrange(10);
        PrimeNumberBetween(10,50);
    }
}
