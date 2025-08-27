package Logic.Logic_Building.StringProblem;

public class A8_PalindromeStringCheck {
    public static void main(String[] args) {
        System.out.println(isPalindromeString("madam"));
        isPalindromeString1("madam");
    }

    public static void isPalindromeString1(String str){
        System.out.println(str);
//        String reverse="";
//        for(int i=str.length()-1; i>=0; i--){
//            reverse= reverse + str.charAt(i);
//        }

        //using string builder
        StringBuilder reverse = new StringBuilder("");
        for (int i=str.length()-1; i>=0; i--){
            reverse.append(str.charAt(i));
        }
        System.out.println(reverse);

        if (str.contentEquals(reverse)) {
            System.out.println(str + " is a palindrome");
        } else {
            System.out.println(str + " is not a palindrome");
        }

    }

    public static boolean isPalindromeString(String str){
        int left = 0, right = str.length()-1;

        while (left<right){
//            System.out.println(str.charAt(left) +" "+ str.charAt(right));
            if (str.charAt(left) != str.charAt(right)){

                return false;
            }
            left++;
            right--;
        }
        return true;
    }
}