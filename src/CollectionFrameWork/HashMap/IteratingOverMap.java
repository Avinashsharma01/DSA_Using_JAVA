package CollectionFrameWork.HashMap;

import java.util.HashMap;
import java.util.Map;

public class IteratingOverMap {
    public static void main(String[] args) {

        Map<String, Integer> ages = new HashMap<>();

        ages.put("Avinash", 23);
        ages.put("Soumya", 21);
        ages.put("Brijesh", 20);
        ages.put("Anup", 26);
        ages.put("Rahul", 22);
        ages.put("Amresh", 16);


        System.out.println(ages);

        System.out.println(ages.keySet());
        System.out.println(ages.values());




        // Method 1: Iterate keys
        for(String  name : ages.keySet()){
            System.out.println(name + " → " + ages.get(name));
        }

        // Method 2: Iterate entries (RECOMMENDED ✅)
        System.out.println(ages.entrySet());

        for (Map.Entry<String, Integer> entry : ages.entrySet()){
            System.out.println(entry.getKey() + " -> "+ entry.getValue());
        }


        System.out.println("3-------------3-------------3");
        // Method 3: forEach (Java 8+)
        ages.forEach((name, age) -> {
            System.out.println(name + " → " + age);
        });
    }
}
