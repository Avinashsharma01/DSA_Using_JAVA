package PlayWithStrings;

public class PrintLargestString {

    public static void main(String[] args) {
        String[] fruits = {"apple", "mango", "banana"};

        String largestStr = fruits[0];
        for (int i=1; i<fruits.length; i++){
            if (fruits[i].length() > largestStr.length()){
                largestStr = fruits[i];
            }
        }
        System.out.println("( "+ largestStr + " )" + " is the largest String");

    }
}
