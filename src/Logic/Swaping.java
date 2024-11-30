package Logic;

public class Swaping {
    //1.Using temp variable
    public static void usingTemp(){
        int a=10;
        int b=20;
        int temp;
        System.out.println("Before swamping: " + a +" " +" " +b);
        temp=a;
        a=b;
        b=temp;
        System.out.println("After swamping: " + a +" " +" " +b);
    }

    // 2. Using Arithmetic Operations
    public static void UsingArithematicOp(){
        int a=10;
        int b=20;
        System.out.println("Before swamping: " + a +" " +" " +b);
        a=a+b;  // 10+20= a= 30
        b=a-b;  // 30-20= b= 10
        a=a-b;  // 30-10= a= 20
        System.out.println("After swamping: " + a +" " +" " +b);
    }

    // 3. Using Bitwise XOR
    public static void UsingBitwiseXOR(){
        int a=10;
        int b=20;
        System.out.println("Befor   e swamping: " + a +" " +" " +b);
        a=a^b;  // 10^20= a= 30
        b=a^b;  // 30^20= b= 10
        a=a^b;  // 30^10= a= 20
        System.out.println("After swamping: " + a +" " +" " +b);
    }

    // 4. Using Single Statement
    public static void UsingSingleStatement(){
        int a=10;
        int b=20;
        System.out.println("Before swamping: " + a +" " +" " +b);
        a=a+b-(b=a);
        System.out.println("After swamping: " + a +" " +" " +b);
    }


// reseach on XOR
    public static void research(){
        int a=10;
        int b=20;

        System.out.println(a=a^b);
    }


    public static void main(String[] args) {
//        usingTemp();
//        UsingArithematicOp();
//        UsingBitwiseXOR();
//        UsingSingleStatement();
//        research();
    }
}
