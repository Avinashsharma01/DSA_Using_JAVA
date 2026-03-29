package CollectionFrameWork.HashMap;

import java.util.HashMap;
import java.util.Map;

public class HelloMap {
    public static void main(String[] args) {
        Map<String, Integer> ages =  new HashMap<>();
        // Add entries
        ages.put("Alice", 25);
        ages.put("Bob", 30);
        ages.put("Charlie", 35);
        ages.put("Avinash", 22);


        System.out.println(ages);
        System.out.println(ages.get("Avinash"));
        System.out.println(ages.get("Bob"));
        System.out.println(ages.getOrDefault("Soumya", 20));

        ages.put("Avinash", 50);
        System.out.println(ages);


        if (ages.containsKey("Avinash")){
            System.out.println("Yes Avinash Exist");
        }else {
            System.out.println("No Avinash is not exist");
        }


        ages.remove("Alice");
        System.out.println(ages);

        System.out.println(ages.size());

        ages.clear();

        System.out.println(ages);
    }
}





