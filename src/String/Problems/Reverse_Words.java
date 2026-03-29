package String.Problems;

public class Reverse_Words {
    public static void main(String[] args) {
        String words = "the sky is blue";
        System.out.println(reverse(words));
    }


    public static String  reverse(String str){

        String[] word = str.trim().split("\\s+");
        StringBuilder result = new StringBuilder();

        for (int i=word.length-1; i>=0; i--){
            result.append(word[i]);
            // it appends the Space  between the words
            if (i!=0){
                result.append(" ");
            }
        }

        return  result.toString();
    }
}
