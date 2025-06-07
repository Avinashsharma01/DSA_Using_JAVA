package PlayWithStrings;

public class LexicographicallyLargestString {
    public static void main(String[] args) {
        String[] fruits = {"apple", "mango", "banana"};

        String largestSTR = fruits[0];
        for(int i=1; i< fruits.length; i++){
            if (fruits[i].compareTo(largestSTR)> 0){
                largestSTR=fruits[i];
            }
        }
        System.out.println("( "+ largestSTR + " )" + " is the largest String");
    }
}
