package BasicCode;

public class DecimalToBin {
    public static void DecToBin(int n){
        int myDec= n;
        int  pow=0;
        int bin=0;

        while (n>0){
            int remainder = n % 2;
            bin= bin+(remainder *  (int)Math.pow(10,pow));
            pow++;
            n=n/2;
        }
        System.out.println("Binary of " + myDec + " = "+ bin );
    }

    public static void main(String[] args) {
        DecToBin(7);
    }
}
