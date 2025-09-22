// Problem: Linear Search for String Elements
// Description: Searches for a target string in an array of strings using linear search
// Algorithm: Sequential search through array comparing each string with target
// Time Complexity: O(n) - worst case requires checking all elements
// Space Complexity: O(1) - constant extra space
// Note: Uses == for string comparison (should use .equals() for content comparison)

package Arrays.MyArray;

public class MyLinearSearch {

    // Method to search for a string in an array of strings
    // Parameters: data[] - array of strings, key - string to search for
    // Returns: the found string if exists, "Data not found" message otherwise
    // Warning: Uses == which compares references, not content
    public static String updateData(String[] data, String key){
        for (int i=0; i < data.length; i++){
            if (data[i]==key){  // Reference comparison (should use .equals() for content)
                return data[i];  // Return the found string
            }
        }
        return "Data not found";  // String not found in array
    }

    public static void main(String[] args) {
        String[] name ={"Avinash", "Soumya", "Ajya", "Abhishek"};  // Array of names
        String key ="Avinash";  // String to search for

        String data= updateData(name, key);  // Perform linear search
        // Note: The if-else condition is redundant as both branches do the same thing
        if(data == key){  // Check if found (reference comparison)
            System.out.println(data);
        }else {
            System.out.println(data);  // Print result regardless
        }
    }
}
