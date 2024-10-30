package Arrays;

public class SubArray {
    public static void main(String[] args) {
        int total=0;
        int f=0, s=0, t=0, fo=0, fi=0;
        int[] number={1,2,3,4,5};
        for (int i=0; i<number.length; i++){
            int start=i;
            for(int j=i; j<number.length; j++){
                int end = j;
                for (int k=start; k<=end; k++){  // this is used for print the sub array
                    System.out.print(number[k]+" ");
                    if (start==0){
                        f=f+number[k];
                    }
                    if (start==1){
                        s+=number[k];
                    }
                    if (start==2){
                        t+=number[k];
                    }
                    if (start==3){
                        fo+=number[k];
                    }
                    if (start==4){
                        fi+=number[k];
                    }
                }
                System.out.println();
                total++;
            }
            System.out.println();
        }
        System.out.println("total sub array:- " + total);
        System.out.println("first sum:- "+  f);
        System.out.println("first sum:- "+  s);
        System.out.println("first sum:- "+  t);
        System.out.println("first sum:- "+  fo);
        System.out.println("first sum:- "+  fi);
    }
}
