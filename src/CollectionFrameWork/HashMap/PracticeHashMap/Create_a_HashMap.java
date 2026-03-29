package CollectionFrameWork.HashMap.PracticeHashMap;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class Create_a_HashMap {
    public static void main(String[] args) {

        int[] arr ={1,2,3,4,5,6};
        System.out.println(containsDuplicate(arr));

        //Q1. Create a HashMap and add 3 key-value pairs (name, age of students).
        HashMap<String, Integer> map = new HashMap<>();
        map.put("Avinash", 22); // here "Avinash" is KEY and 22 is Value
        map.put("Soumya", 22);
        map.put("Brijesh", 20);
        map.put("Ankrita", 18);
        System.out.println(map);


        //Q2. How do you get a value from a HashMap using a key?
        int value = map.get("Avinash");
        System.out.println(value);


        //Q3. Check if a key exists in a HashMap.
        System.out.println(map.containsKey("Avinash"));
        System.out.println(map.containsKey("KAKA"));


        //Q4. Check if a value exists in a HashMap.
        System.out.println(map.containsValue(22));
        System.out.println(map.containsValue(44));


        //Q5. Remove a key-value pair from a HashMap.
        map.remove("Soumya");
        System.out.println(map);


        //Q6. Find the size of a HashMap.
        System.out.println(map.size());


        //Q7. Iterate over a HashMap using a for-each loop.
        for (HashMap.Entry<String, Integer> entry : map.entrySet()){
            System.out.println(entry.getKey() + " -> " + entry.getValue());
        }

        
    }


    public static boolean containsDuplicate(int[] arr){
        Set<Integer> seen = new HashSet<>();

        for (int num : arr){
            if (seen.contains(num)){
                return true;
            }
            seen.add(num);
        }
        return false;
    }
}
