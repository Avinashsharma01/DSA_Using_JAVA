// Problem: Recursion Experiments - Understanding Call Behavior
// Description: Demonstrates different recursive calling patterns and their effects
// Educational: Shows pre/post increment effects and infinite recursion pitfalls
// Time Complexity: Varies based on implementation (O(n) for correct versions)
// Space Complexity: O(n) - recursion stack depth
// Warning: Contains examples of infinite recursion for educational purposes

package Recursion.RecursionPractice;

public class Experiment {
    public static void main(String[] args) {
        System.out.println("PrintN demonstration (prints numbers twice):");
        PrintN(5);

        System.out.println("\nFun demonstration (correct version):");
        fun(5);
    }

    // Demonstrates pre-order and post-order processing in same function
    // Pattern: Print before recursion AND after recursion returns
    // Result: Each number prints twice - once going down, once coming back up
    public static void PrintN(int n){
        if (n==0){
            return;  // Base case: stop recursion
        }

        System.out.println(n);  // Pre-order: print before recursive call
        PrintN(n-1);            // Recursive call with decremented value
        System.out.println(n);  // Post-order: print after recursive call returns
    }

    // Output for PrintN(3):
    // 3 (going down)
    // 2 (going down)
    // 1 (going down)
    // 1 (coming back up)
    // 2 (coming back up)
    // 3 (coming back up)

    // Demonstrates correct vs incorrect recursive calling patterns
    // Educational example showing the importance of proper parameter passing
    public static void fun(int n){
        if (n==0){
            return;  // Base case: stop recursion
        }

        System.out.println(n);

        // DANGEROUS: fun(n--);
        // Post-decrement passes current value (5), then decrements n
        // Results in infinite recursion: fun(5) → fun(5) → fun(5) → ...
        // The argument is always 5, so base case never reached!

        fun(n-1);  // CORRECT: Creates new value (n-1) and passes it

        // ALTERNATIVE: fun(--n);
        // Pre-decrement decrements first, then passes decremented value
        // This would work but modifies the original variable
    }

    // Explanation of different decrement operators in recursion:
    //
    // 1. fun(n-1):   ✅ BEST - Creates new value, doesn't modify original
    //                   Passes: 5→4→3→2→1→0 (terminates correctly)
    //
    // 2. fun(n--):   ❌ INFINITE LOOP - Post-decrement passes old value
    //                   Passes: 5→5→5→5→... (never decreases argument)
    //
    // 3. fun(--n):   ⚠️ WORKS but RISKY - Pre-decrement modifies original
    //                   Passes: 4→3→2→1→0 (terminates, but changes n)
}
