package Stack.QuestionPractice;

import java.util.Scanner;
import java.util.Stack;

public class Balancedbrackets {

    public boolean isValid(String s) {
        Stack<Character> st = new Stack<>();

        for(int i=0; i<s.length(); i++){
            char ch = s.charAt(i);

            if(ch == '(' || ch == '[' || ch == '{'){
                st.push(ch);
            }else if(ch == ')' || ch == ']' || ch == '}'){
                if(st.isEmpty()){
                    return false;
                }

                char top = st.peek();

                if(ch == ')' && top == '('){
                    st.pop();
                }else if(ch == ']' && top == '['){
                    st.pop();
                }else if(ch == '}' && top == '{'){
                    st.pop();
                }else{
                    return false;
                }
            }
        }

        return st.isEmpty();
    }


    public static boolean isBalanced(String str){
        Stack<Character>  st = new Stack<>();

        for (int i=0; i<str.length(); i++){
            char ch = str.charAt(i);

            if (ch == '('){
                st.push(ch);
            } else if (ch == ')') {
                if (st.isEmpty()) return  false;
                if (st.peek() == '('){
                    st.pop();
                }
            }
        }

        return st.isEmpty();
    }

    public static void main(String[] args) {

        while (true){
            Scanner sc = new Scanner(System.in);
            String str = sc.nextLine();
            System.out.println(isBalanced(str));
        }
    }
}
