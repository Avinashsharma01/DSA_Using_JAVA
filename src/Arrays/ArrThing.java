package Arrays;

public class ArrThing {
    public static void main(String[] args) {
//        int[] arr =new int[5]; // 0,0,0,0,0
//        for(int i=0; i<arr.length; i++){  // 1,2,3,4
//            arr[i]=i+1; // 1,2,3,4,5
//        }
//        for(int j: arr){
//            System.out.println(j);
//        }

//        char[] names = new char[26];
//        char c = 'A';
//        for(int i=0; i<names.length; i++){
//            names[i]=c++ ;
//        }
//        for(char j: names){
//            System.out.print(j + " ");
//        }


//        for(char i='A'; i<='Z'; i++){
//            System.out.println(i);
//        }

        // 65-90
        char c='A';
        for(int i=0; i<100; i++){
            if(i==26){
                break;
            }
            System.out.println(c++);

        }
    }
}
