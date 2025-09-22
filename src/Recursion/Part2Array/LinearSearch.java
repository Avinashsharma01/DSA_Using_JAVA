// Problem: Linear Search using Recursion - Multiple Approaches
// Description: Demonstrates various recursive linear search techniques for different use cases
// Algorithms: Single occurrence, boolean check, all occurrences with different recursion patterns
// Time Complexity: O(n) - visits each element once in worst case
// Space Complexity: O(n) - recursion stack depth + storage for results
// Educational: Shows proper vs improper recursion patterns with ArrayList usage

package Recursion.Part2Array;

import java.util.ArrayList;

public class LinearSearch {
    public static void main(String[] args) {
        int[] arr = {1,2,3,4,5,5,5,6};  // Test array with duplicate 5s

        System.out.println("First occurrence of 5: " + linearSInt(arr, 5, 0));
        System.out.println("Is 5 present? " + linearSBoolean(arr, 5, 0));
        System.out.println("Index using ternary: " + findIndex(arr, 0, 5));

        // Method 1: Using global ArrayList (improper recursion pattern)
        findAllIndex(arr, 5, 0);
        System.out.println("All indices (global list): " + list);

        // Method 2: Passing ArrayList as parameter (proper recursion)
        ArrayList<Integer> resultList = new ArrayList<>();
        System.out.println("All indices (parameter): " + findAllIndex2(arr, 5, 0, resultList));

        // Method 3: Creating new ArrayList in each call (pure recursion)
        System.out.println("All indices (pure recursion): " + findAllIndex3(arr, 5, 0));
    }

    // Approach 1: Return index of first occurrence
    // Returns: index if found, -1 if not found
    public static int linearSInt(int[] arr, int target, int index){
        if (index == arr.length){
            return -1;  // Base case: reached end, element not found
        }

        if (target == arr[index]){
            return index;  // Base case: element found, return index
        }

        return linearSInt(arr, target, index+1);  // Recursive case: search next
    }

    // Approach 2: Return boolean indicating presence
    // Returns: true if found, false if not found
    public static boolean linearSBoolean(int[] arr, int target, int index){
        if (index == arr.length){
            return false;  // Base case: reached end, element not found
        }

        if (target == arr[index]){
            return true;  // Base case: element found
        }

        return linearSBoolean(arr, target, index+1);  // Recursive case: search next
    }

    // Approach 3: Concise version using ternary operator
    // Same functionality as linearSInt but more compact
    public static int findIndex(int[] arr, int index, int target){
        if (index == arr.length){
            return -1;  // Base case: element not found
        }

        // Ternary operator: if found return index, else recurse
        return target == arr[index] ? index : findIndex(arr, index+1, target);
    }

    // IMPROPER APPROACH: Using global ArrayList (violates recursion principles)
    // Problem: Relies on external state, not pure recursion
    static ArrayList<Integer> list = new ArrayList<>();
    public static void findAllIndex(int[] arr, int target, int index){
        if (index == arr.length){
            return;  // Base case: processed all elements
        }

        if (arr[index] == target){
            list.add(index);  // Add index to global list
        }

        findAllIndex(arr, target, index+1);  // Recursive case: continue search
    }

    // PROPER APPROACH: Passing ArrayList as parameter
    // Advantage: No global state, proper recursive pattern
    public static ArrayList<Integer> findAllIndex2(int[] arr, int target, int index, ArrayList<Integer> list){
        if (index == arr.length){
            return list;  // Base case: return accumulated results
        }

        if (target == arr[index]){
            list.add(index);  // Add current index to list
        }

        return findAllIndex2(arr, target, index+1, list);  // Recursive case with updated list
    }

    // PURE RECURSIVE APPROACH: Creating new ArrayList in each call
    // Advantage: Complete independence, no shared state between calls
    // Note: Less memory efficient but demonstrates pure recursion
    public static ArrayList<Integer> findAllIndex3(int[] arr, int target, int index){
        ArrayList<Integer> list = new ArrayList<>();  // New list for this call

        if (index == arr.length){
            return list;  // Base case: return empty list
        }

        if (arr[index] == target){
            list.add(index);  // Add current index if match found
        }

        // Get results from remaining array
        ArrayList<Integer> resultFromBelow = findAllIndex3(arr, target, index+1);

        // Merge current result with results from deeper calls
        list.addAll(resultFromBelow);
        return list;
    }

    // Example execution trace for findAllIndex3 with arr = {1,2,3,2,4,2}, target = 2:
    // index=5 (arr[5]=2): creates [5], returns [5]
    // index=4 (arr[4]=4): creates [], gets [5], returns [5]
    // index=3 (arr[3]=2): creates [3], gets [5], returns [3,5]
    // index=2 (arr[2]=3): creates [], gets [3,5], returns [3,5]
    // index=1 (arr[1]=2): creates [1], gets [3,5], returns [1,3,5]
    // index=0 (arr[0]=1): creates [], gets [1,3,5], returns [1,3,5]
    // Final result: [1,3,5] - all indices where 2 is found
}
