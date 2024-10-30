package Arrays;

public class LinearSearch {
    public static int update(int[] number, int key){
        for (int i=1; i<number.length; i++){
            if (number[i]==key){
                return i;
            }
        }
        return -1;
    }


    public static void main(String[] args) {
        int[] number={1,2,3,5,10,1,5,7,3,8,9,55};
        int key=1;
        int data= update(number, key);
        if (data==-1){
            System.out.println("no data found");
        }else {
            System.out.println("key is at index :- "+ data);
        }
    }
}
