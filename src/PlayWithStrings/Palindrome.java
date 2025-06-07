package PlayWithStrings;

public class Palindrome {

    public static boolean checkPalindrome(String str){
        int strLength = str.length();
        for (int i=0; i<str.length()/2; i++){
            if (str.charAt(i) != str.charAt(strLength-1-i)){
                return false;
            }
        }
        return true;
    }

    public static void checkPalindromeUsingReverse(String str){
        int strLength = str.length();
        // reverse
        String reversed="";
        for (int i= strLength-1; i>=0; i--){
            reversed += str.charAt(i);
        }
        System.out.println(reversed);

        // compare both
        if (str.equalsIgnoreCase(reversed)){
            System.out.println("This is palindrome");
        }else {
            System.out.println("This is not palindrome");
        }
    }



    public static void main(String[] args) {

        String str = "noon";
        System.out.println(checkPalindrome(str));
        checkPalindromeUsingReverse(str);

    }
}
