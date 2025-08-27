package Logic.Logic_Building;

import java.util.*;


public class LogicBuildingProblems {

    // ==================== BASIC NUMBER PROBLEMS ====================

    // 1. Prime Number Check
    public static boolean isPrime(int n) {
        if (n <= 1) return false;
        if (n == 2) return true;
        if (n % 2 == 0) return false;

        // Check odd divisors up to sqrt(n)
        for (int i = 3; i <= Math.sqrt(n); i += 2) {
            if (n % i == 0) return false;
        }
        return true;
    }

    // 2. Factorial - Iterative
    public static long factorialIterative(int n) {
        if (n < 0) return -1; // Invalid input
        long result = 1;
        for (int i = 2; i <= n; i++) {
            result *= i;
        }
        return result;
    }

    // 2. Factorial - Recursive
    public static long factorialRecursive(int n) {
        if (n < 0) return -1; // Invalid input
        if (n == 0 || n == 1) return 1;
        return n * factorialRecursive(n - 1);
    }

    // 3. Fibonacci Series
    public static void fibonacciSeries(int n) {
        if (n <= 0) return;

        int first = 0, second = 1;
        System.out.print(first + " ");
        if (n > 1) System.out.print(second + " ");

        for (int i = 2; i < n; i++) {
            int next = first + second;
            System.out.print(next + " ");
            first = second;
            second = next;
        }
        System.out.println();
    }

    // 4. Armstrong Number Check
    public static boolean isArmstrong(int n) {
        int original = n;
        int digits = String.valueOf(n).length();
        int sum = 0;

        while (n > 0) {
            int digit = n % 10;
            sum += (int) Math.pow(digit, digits);
            n /= 10;
        }

        return sum == original;
    }

    // 5. Perfect Number Check
    public static boolean isPerfect(int n) {
        if (n <= 1) return false;

        int sum = 1; // 1 is always a proper divisor
        for (int i = 2; i <= Math.sqrt(n); i++) {
            if (n % i == 0) {
                sum += i;
                if (i != n / i) { // Avoid adding same divisor twice for perfect squares
                    sum += n / i;
                }
            }
        }

        return sum == n;
    }

    // 6. Reverse a Number
    public static int reverseNumber(int n) {
        int reversed = 0;
        boolean isNegative = n < 0;
        n = Math.abs(n);

        while (n > 0) {
            reversed = reversed * 10 + n % 10;
            n /= 10;
        }

        return isNegative ? -reversed : reversed;
    }

    // 7. Sum of Digits
    public static int sumOfDigits(int n) {
        n = Math.abs(n); // Handle negative numbers
        int sum = 0;

        while (n > 0) {
            sum += n % 10;
            n /= 10;
        }

        return sum;
    }

    // ==================== STRING PROBLEMS ====================

    // 8. Palindrome String Check
    public static boolean isPalindromeString(String str) {
        str = str.toLowerCase().replaceAll("[^a-zA-Z0-9]", ""); // Clean string
        int left = 0, right = str.length() - 1;

        while (left < right) {
            if (str.charAt(left) != str.charAt(right)) {
                return false;
            }
            left++;
            right--;
        }
        return true;
    }

    // 9. Reverse a String
    public static String reverseString(String str) {
        char[] chars = str.toCharArray();
        int left = 0, right = chars.length - 1;

        while (left < right) {
            char temp = chars[left];
            chars[left] = chars[right];
            chars[right] = temp;
            left++;
            right--;
        }

        return new String(chars);
    }

    // 10. Count Vowels and Consonants
    public static void countVowelsConsonants(String str) {
        str = str.toLowerCase();
        int vowels = 0, consonants = 0;

        for (char c : str.toCharArray()) {
            if (Character.isLetter(c)) {
                if (c == 'a' || c == 'e' || c == 'i' || c == 'o' || c == 'u') {
                    vowels++;
                } else {
                    consonants++;
                }
            }
        }

        System.out.println("Vowels: " + vowels + ", Consonants: " + consonants);
    }

    // 11. Remove Duplicates
    public static String removeDuplicates(String str) {
        StringBuilder result = new StringBuilder();
        boolean[] seen = new boolean[256]; // ASCII characters

        for (char c : str.toCharArray()) {
            if (!seen[c]) {
                seen[c] = true;
                result.append(c);
            }
        }

        return result.toString();
    }

    // 12. Anagram Check
    public static boolean areAnagrams(String str1, String str2) {
        if (str1.length() != str2.length()) return false;

        int[] count = new int[256]; // ASCII characters

        // Count characters in first string
        for (char c : str1.toLowerCase().toCharArray()) {
            count[c]++;
        }

        // Subtract counts for second string
        for (char c : str2.toLowerCase().toCharArray()) {
            count[c]--;
        }

        // Check if all counts are zero
        for (int i : count) {
            if (i != 0) return false;
        }

        return true;
    }

    // ==================== PATTERN PROBLEMS ====================

    // 13. Star Patterns
    public static void printRightTriangle(int n) {
        System.out.println("Right Triangle Pattern:");
        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= i; j++) {
                System.out.print("* ");
            }
            System.out.println();
        }
    }

    public static void printPyramid(int n) {
        System.out.println("Pyramid Pattern:");
        for (int i = 1; i <= n; i++) {
            // Print spaces
            for (int j = 1; j <= n - i; j++) {
                System.out.print(" ");
            }
            // Print stars
            for (int j = 1; j <= 2 * i - 1; j++) {
                System.out.print("*");
            }
            System.out.println();
        }
    }

    // 14. Number Patterns
    public static void printNumberPyramid(int n) {
        System.out.println("Number Pyramid Pattern:");
        for (int i = 1; i <= n; i++) {
            // Print spaces
            for (int j = 1; j <= n - i; j++) {
                System.out.print(" ");
            }
            // Print ascending numbers
            for (int j = 1; j <= i; j++) {
                System.out.print(j);
            }
            // Print descending numbers
            for (int j = i - 1; j >= 1; j--) {
                System.out.print(j);
            }
            System.out.println();
        }
    }

    // 15. Hollow Rectangle
    public static void printHollowRectangle(int rows, int cols) {
        System.out.println("Hollow Rectangle Pattern:");
        for (int i = 1; i <= rows; i++) {
            for (int j = 1; j <= cols; j++) {
                if (i == 1 || i == rows || j == 1 || j == cols) {
                    System.out.print("* ");
                } else {
                    System.out.print("  ");
                }
            }
            System.out.println();
        }
    }

    // ==================== ARRAY PROBLEMS ====================

    // 16. Find Maximum and Minimum
    public static void findMaxMin(int[] arr) {
        if (arr.length == 0) return;

        int max = arr[0], min = arr[0];

        for (int num : arr) {
            if (num > max) max = num;
            if (num < min) min = num;
        }

        System.out.println("Max: " + max + ", Min: " + min);
    }

    // 17. Linear Search
    public static int linearSearch(int[] arr, int target) {
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] == target) {
                return i;
            }
        }
        return -1; // Not found
    }

    // 18. Count Occurrences
    public static int countOccurrences(int[] arr, int element) {
        int count = 0;
        for (int num : arr) {
            if (num == element) {
                count++;
            }
        }
        return count;
    }

    // 19. Second Largest Element
    public static int findSecondLargest(int[] arr) {
        if (arr.length < 2) return -1;

        int largest = Integer.MIN_VALUE;
        int secondLargest = Integer.MIN_VALUE;

        for (int num : arr) {
            if (num > largest) {
                secondLargest = largest;
                largest = num;
            } else if (num > secondLargest && num != largest) {
                secondLargest = num;
            }
        }

        return secondLargest == Integer.MIN_VALUE ? -1 : secondLargest;
    }

    // ==================== ADDITIONAL PROBLEMS ====================

    // 20. GCD and LCM
    public static int findGCD(int a, int b) {
        while (b != 0) {
            int temp = b;
            b = a % b;
            a = temp;
        }
        return a;
    }

    public static int findLCM(int a, int b) {
        return (a * b) / findGCD(a, b);
    }

    // 21. Power Calculation - Iterative
    public static long powerIterative(int base, int exp) {
        if (exp < 0) return -1; // Invalid for this implementation

        long result = 1;
        for (int i = 0; i < exp; i++) {
            result *= base;
        }
        return result;
    }

    // 21. Power Calculation - Recursive
    public static long powerRecursive(int base, int exp) {
        if (exp < 0) return -1; // Invalid for this implementation
        if (exp == 0) return 1;
        if (exp == 1) return base;

        long half = powerRecursive(base, exp / 2);
        if (exp % 2 == 0) {
            return half * half;
        } else {
            return base * half * half;
        }
    }

    // 22. Leap Year Check
    public static boolean isLeapYear(int year) {
        return (year % 4 == 0 && year % 100 != 0) || (year % 400 == 0);
    }

    // ==================== MAIN METHOD FOR TESTING ====================

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        // Test all functions
        System.out.println("=== TESTING ALL FUNCTIONS ===\n");

        // 1. Prime Number
        System.out.println("1. Prime Check:");
        System.out.println("17 is prime: " + isPrime(17));
        System.out.println("18 is prime: " + isPrime(18));

        // 2. Factorial
        System.out.println("\n2. Factorial:");
        System.out.println("5! (iterative): " + factorialIterative(5));
        System.out.println("5! (recursive): " + factorialRecursive(5));

        // 3. Fibonacci
        System.out.println("\n3. Fibonacci Series (7 numbers):");
        fibonacciSeries(7);

        // 4. Armstrong
        System.out.println("\n4. Armstrong Check:");
        System.out.println("153 is Armstrong: " + isArmstrong(153));
        System.out.println("154 is Armstrong: " + isArmstrong(154));

        // 5. Perfect Number
        System.out.println("\n5. Perfect Number Check:");
        System.out.println("28 is perfect: " + isPerfect(28));
        System.out.println("30 is perfect: " + isPerfect(30));

        // 6. Reverse Number
        System.out.println("\n6. Reverse Number:");
        System.out.println("12345 reversed: " + reverseNumber(12345));

        // 7. Sum of Digits
        System.out.println("\n7. Sum of Digits:");
        System.out.println("Sum of digits of 12345: " + sumOfDigits(12345));

        // 8. Palindrome String
        System.out.println("\n8. Palindrome String:");
        System.out.println("'madam' is palindrome: " + isPalindromeString("madam"));
        System.out.println("'hello' is palindrome: " + isPalindromeString("hello"));

        // 9. Reverse String
        System.out.println("\n9. Reverse String:");
        System.out.println("'hello' reversed: " + reverseString("hello"));

        // 10. Count Vowels and Consonants
        System.out.println("\n10. Count Vowels and Consonants:");
        countVowelsConsonants("programming");

        // 11. Remove Duplicates
        System.out.println("\n11. Remove Duplicates:");
        System.out.println("'programming' without duplicates: " + removeDuplicates("programming"));

        // 12. Anagram Check
        System.out.println("\n12. Anagram Check:");
        System.out.println("'listen' and 'silent' are anagrams: " + areAnagrams("listen", "silent"));

        // 13-15. Patterns
        System.out.println("\n13-15. Pattern Examples:");
        printRightTriangle(4);
        System.out.println();
        printPyramid(4);
        System.out.println();
        printNumberPyramid(4);
        System.out.println();
        printHollowRectangle(4, 6);

        // 16. Max Min
        System.out.println("\n16. Find Max and Min:");
        int[] arr1 = {3, 5, 1, 9, 2};
        findMaxMin(arr1);

        // 17. Linear Search
        System.out.println("\n17. Linear Search:");
        int[] arr2 = {2, 4, 6, 8, 10};
        int index = linearSearch(arr2, 6);
        System.out.println("Element 6 found at index: " + (index != -1 ? index : "Not found"));

        // 18. Count Occurrences
        System.out.println("\n18. Count Occurrences:");
        int[] arr3 = {1, 2, 3, 2, 2, 4};
        System.out.println("Element 2 appears " + countOccurrences(arr3, 2) + " times");

        // 19. Second Largest
        System.out.println("\n19. Second Largest:");
        int[] arr4 = {3, 1, 4, 1, 5, 9, 2};
        System.out.println("Second largest: " + findSecondLargest(arr4));

        // 20. GCD and LCM
        System.out.println("\n20. GCD and LCM:");
        int a = 12, b = 18;
        System.out.println("GCD of " + a + " and " + b + ": " + findGCD(a, b));
        System.out.println("LCM of " + a + " and " + b + ": " + findLCM(a, b));

        // 21. Power
        System.out.println("\n21. Power Calculation:");
        System.out.println("2^5 (iterative): " + powerIterative(2, 5));
        System.out.println("2^5 (recursive): " + powerRecursive(2, 5));

        // 22. Leap Year
        System.out.println("\n22. Leap Year:");
        System.out.println("2024 is leap year: " + isLeapYear(2024));
        System.out.println("2023 is leap year: " + isLeapYear(2023));

        sc.close();
    }
}