package String.Problems;
public class FrequencyCount {
    // Defines a class named FrequencyCount

    public static void main(String[] args) {
        // Program execution starts here

        countFreq("avinash");
        // Calls the countFreq method and passes the string "hello"
    }

    public static void countFreq(String str) {
        // Method to count frequency of lowercase letters in a string

        if (str == null || str.isEmpty()) {
            // If the string is null or empty, there is nothing to process
            return;
            // Exit the method early to avoid errors
        }

        int[] freq = new int[26];
        // Create an array of size 26 to store counts for letters 'a' to 'z'
        // Index 0 -> 'a', index 1 -> 'b', ..., index 25 -> 'z'

        for (char ch : str.toCharArray()) {
            // Convert the string into a character array and iterate over each character

            if (ch >= 'a' && ch <= 'z') {
                // Ensure the character is a lowercase letter

                freq[ch - 'a']++;
                // Convert character to array index:
                // 'a' - 'a' = 0, 'b' - 'a' = 1, ..., 'z' - 'a' = 25
                // Increment the frequency count for that letter
            }
        }

        for (int i = 0; i < freq.length; i++) {
            // Iterate through the frequency array

            if (freq[i] > 0) {
                // Only print letters that appear at least once

                System.out.println((char) (i + 'a') + " -> " + freq[i]);
                // Convert array index back to character:
                // 0 + 'a' = 'a', 1 + 'a' = 'b', etc.
                // Print the character and its frequency
            }
        }
    }
}
