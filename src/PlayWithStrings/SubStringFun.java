package PlayWithStrings;

public class SubStringFun {
    public static String GetSubString(String str, int si, int ei){
        // with StringBuilder
        StringBuilder subString = new StringBuilder();
        for (int i=si; i< ei; i++){
            subString.append(str.charAt(i));
        }
        return subString.toString();


        // Without StringBuilder
//        String subString ="";
//        for (int i=si; i< ei; i++){
//            subString += str.charAt(i);
//        }
//        return subString;
    }
    public static void main(String[] args) {
        String str ="Avinash";
        System.out.println(GetSubString(str, 0, 7));
    }
}
