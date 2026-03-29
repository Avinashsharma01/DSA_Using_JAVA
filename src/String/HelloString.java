package String;

public class HelloString {
    public static void main(String[] args) {
        String name1 = "Avinash";
        String name2 = new String("Avinash");
        String name3 = "Avinash";

        System.out.println(name1.equals(name2));

        System.out.println(name1.length());
        System.out.println(name1.charAt(0));
        System.out.println(name1.charAt(1));
        System.out.println(name1.charAt(2));
        System.out.println(name1.charAt(3));

        System.out.println("Looping on String");

        for (int i=0; i<name1.length(); i++){
            System.out.println(name1.charAt(i));
        }

        System.out.println(name1.substring(0,3));

        System.out.println("===========================");

        String words = "the sky is blue";
        System.out.println(words);

        String[] word = words.trim().split("\\s+");
        System.out.println(word.length);
        for (String w : word){
            System.out.println(w);
        }


        System.out.println("okokokkkoko");
        String Myname = "Avinash";
        char[] ch = Myname.toCharArray();

        for (char c : ch){
            System.out.println(c+" ");
        }

    }
}
