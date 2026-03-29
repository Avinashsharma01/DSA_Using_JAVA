package String.Problems;

public class Valid_Palindrome {
    public static void main(String[] args) {
        System.out.println(isPalindrome("ABA"));
        System.out.println(isPalindrome("ABCBA"));
        System.out.println(isPalindrome("Avinash"));
    }

    public static boolean isPalindrome(String str){
        int left =0;
        int right = str.length()-1;

        char[] chars = str.toCharArray();

        while (left<right){
            if (str.charAt(left) != str.charAt(right)){
                return false;
            }
            left++;
            right--;
        }

        return true;
    }
}
