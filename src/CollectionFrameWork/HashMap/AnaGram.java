package CollectionFrameWork.HashMap;

import java.util.HashMap;

public class AnaGram {

    /**
     * Helper method to create a frequency map of characters in a string.
     *
     * How it works:
     * 1. Creates an empty HashMap where Character is the key and its frequency (Integer) is the value.
     * 2. Iterates through each character of the string `s`.
     * 3. If the character is not in the map, add it with a frequency of 1.
     * 4. If the character is already in the map, increment its frequency by 1.
     * 5. Returns the populated frequency map.
     */
    static HashMap<Character, Integer> makeFreqMap(String s){
        HashMap<Character, Integer> freq = new HashMap<>();

        for (int i=0; i<s.length(); i++){
            Character ch = s.charAt(i);
            if (!freq.containsKey(ch)){
                freq.put(ch,1);
            }else {
                freq.put(ch, freq.get(ch)+1);
            }
        }
        return freq;
    }

    /**
     * Main logic to check if string `t` is an anagram of string `s`.
     * An anagram is a word formed by rearranging the letters of a different word,
     * typically using all the original letters exactly once.
     *
     * Algorithm Steps:
     * 1. Length Check: If lengths of `s` and `t` are different, they cannot be anagrams. Return false.
     * 2. Map Creation: Generate a frequency map for the first string `s` using `makeFreqMap`.
     * 3. validation: Iterate through each character in the second string `t`.
     *    - If a character from `t` is not present in the map of `s`, it means `t` contains an extra/different character. Return false.
     *    - If the character exists, decrement its frequency in the map by 1. This "consumes" one occurrence of the character.
     * 4. Final verification: Check all the values in the frequency map.
     *    - If any value is not 0 (either positive meaning `s` had more, or negative meaning `t` had more of a character), return false.
     * 5. If all values are 0, the strings are valid anagrams. Return true.
     */
    public static Boolean isAnagram(String s, String t){
        if (s.length() != t.length()){
            return false;
        }

        HashMap<Character, Integer> map1 = makeFreqMap(s);
//        HashMap<Character, Integer> map2 = makeFreqMap(t);

        for (int i=0; i<t.length(); i++){
            Character ch = t.charAt(i);

            if (!map1.containsKey(ch)){
                return false;
            }else {
                map1.put(ch, map1.get(ch)-1);
            }
        }

        for (int i : map1.values()){
            if (i!=0){
                return false;
            }
        }

        return true;
    }
    public static void main(String[] args) {
        String s1 = "Avi";
        String s2 = "viA";

        boolean isAnagramHai = isAnagram(s1,s2);
        System.out.println(isAnagramHai);
    }
}
