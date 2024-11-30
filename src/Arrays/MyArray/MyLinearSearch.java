package Arrays.MyArray;

public class MyLinearSearch {
    public static String updateData(String[] data, String key){
        for (int i=0; i < data.length; i++){
            if (data[i]==key){
                return data[i];
            }
        }
        return "Data not found";
    }

    public static void main(String[] args) {
        String[] name ={"Avinash", "Soumya", "Ajya", "Abhishek"};
        String key ="avinash";
        String data= updateData(name, key);
        if(data == key){
            System.out.println(data);
        }else {
            System.out.println(data);
        }
    }
}
