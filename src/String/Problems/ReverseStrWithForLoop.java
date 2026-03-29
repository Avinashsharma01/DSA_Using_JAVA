package String.Problems;

public class ReverseStrWithForLoop {
    public static void main(String[] args) {
        String name = "Avinash Sharma";

        System.out.println(reverse(name));
    }

    public static String reverse(String str){
        //String → char[]
        char[] arr = str.toCharArray();

        for (int i=0, j=arr.length-1; i<=j; i++, j--){
            char temp = arr[i];
            arr[i] = arr[j];
            arr[j] = temp;
        }
        //char[] → String
        String reversed = new String(arr);
        return  reversed;
    }
}
