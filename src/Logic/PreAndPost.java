package Logic;

public class PreAndPost {
    public static void main(String[] args) {
//        PreIncrement(5);
//        PostIncrement(5);

        // Iterative method
//        PreIncrementI(5);
//        PreDecrementI(5);
//        PostIncrementI(5);
        PostDecrementI(5);
    }

    // PreIncrement in recursion
    public static void PreIncrement(int n){
        if(n==0){
            return;
        }
        System.out.println(n);
        PreIncrement(--n);
    }

    // PostIncrement recursion
    public static void PostIncrement(int n){
        if(n==0){
            return;
        }
        System.out.println(n);
        PostIncrement(n--);
    }


    // PreIncrement In iterative
    public static void PreIncrementI(int n){
        for(int i=1; i<=n; ++i){
            System.out.println(i);
        }
    }

    // PreDecrementI In iterative
    public static void PreDecrementI(int n){
        for(int i=n; i>=1; --i){
            System.out.println(i);
        }
    }

    // PostIncrement In iterative
    public static void PostIncrementI(int n){
        for(int i=1; i<=n; i++){
            System.out.println(i);
        }
    }

    // PostDecrementI In iterative
    public static void PostDecrementI(int n){
        for(int i=n; i>=1; i--){
            System.out.println(i);
        }
    }


}
