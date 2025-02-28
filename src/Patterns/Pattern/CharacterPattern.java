package Patterns.Pattern;

public class CharacterPattern {
    public static void main(String[] args) {
        char ch='A'; //ascii code
        for (int i=1; i<=4; i++){
            for (int j=1; j<=i; j++){
                System.out.print(ch+"="+ (int)ch); // type casting
                ch++;
            }
            System.out.println();
        }
    }
}
