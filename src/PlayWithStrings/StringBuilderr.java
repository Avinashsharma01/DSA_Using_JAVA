package PlayWithStrings;

public class StringBuilderr {
    public static void main(String[] args) {
        StringBuilder sb = new StringBuilder("Avinash+  ");
        System.out.println(sb);

        for (char ch = 'a'; ch <= 'z'; ch++){
//            System.out.print(ch+ " ");
            sb.append(ch);
        }
        System.out.println(sb);

    }
}
