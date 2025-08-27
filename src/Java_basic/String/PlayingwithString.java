package Java_basic.String;

public class PlayingwithString {
    public static void main(String[] args) {
        String txt = "ABCDEFGHIJKLMNOPQRSTUVWXYZ";
        System.out.println(txt.length());
        System.out.println(txt.toLowerCase());
        System.out.println(txt.toUpperCase());

        System.out.println("------------------------------------------------------");

        String txt1 = "Please locate where 'locate' occurs!";
        System.out.println(txt1.indexOf("locate"));

        System.out.println("------------------------------------------------------");


        String firstName = "Avinash";
        String lastName = "Sharma";

        System.out.println(firstName.concat(" "+lastName));

        System.out.println("------------------------------------------------------");

        String a= "10";
        int b=20;
        System.out.println(a+b);
        System.out.println(b+a);
        System.out.println("10"+20);
        System.out.println(20+ "10");

        System.out.println("------------------------------------------------------");




    }
}
