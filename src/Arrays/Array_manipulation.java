package Arrays;

public class Array_manipulation {
    public static void updateArray(int[] mark){
        for (int i=0; i<mark.length; i++){
            System.out.println(mark[i]+=1);
        }
    }

    public static void main(String[] args) {
        int[] marks = new int[50];
        int[] mark = {11,22,33,44,55,66,77};
        updateArray(mark);
    }
}
