package BasicCode;

public class BinaryToDecimal {

    public static void BinToDecimal(int binary){
        int bin=binary;
        int power =0;
        int decimal =0;
        while (binary>0){
            int lastDigit = binary%10; //This gives me last digit of the number

            decimal=decimal +(lastDigit* (int)Math.pow(2,power));
            power++;
            binary=binary/10; // This eliminates the last digit form the number
        }
        System.out.println("Decimal of " + bin +" = "+  decimal);
    }

    public static void main(String[] args) {
        System.out.println(2346%10); // This gives me last digit of the number
        System.out.println(2346/10); // This eliminates the last digit form the number

        BinToDecimal(101);

    }

}
