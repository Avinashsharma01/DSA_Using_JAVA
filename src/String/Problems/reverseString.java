package String.Problems;

public class reverseString {
    public static void main(String[] args) {
        String name = "Avinash";

        char[] chars = name.toCharArray();

        int left = 0;
        int right = chars.length-1;

        while (left<=right){
            char temp= chars[left];
            chars[left] =chars[right];
            chars[right]= temp;
            left++;
            right--;
        }

        String reversed = new String(chars);

        System.out.println(reversed);

        System.out.println("Little Concepts");

        char[] arr = {'a','v','i'};
        System.out.println(arr);
        String n = new String(arr);
        System.out.println(n);
    }
}
