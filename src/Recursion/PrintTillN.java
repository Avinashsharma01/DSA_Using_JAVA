package Recursion;

public class PrintTillN {
    public static void main(String[] args) {
//        PrintNincrement(10);
//        PrintNdecriment(5);
//        PrintName(10);
//        int sum =SumOfN(5);
//        System.out.println(sum);
//        int fact = Fact(5);
//        System.out.println(fact);
        // Calculate sum of digits of 12345
//        int sum= SumOfDigit(12345);
//        System.out.println(sum);
        int product = ProductOfDigit(22222);
        System.out.println(product);
    }

    /**
     * Prints numbers from 1 to n in ascending order using recursion
     * @param n The maximum number to print
     */
    public static void PrintNincrement(int n){
        if (n==0){
            // Base case: stop recursion when n reaches 0
            return;
        }

        // First make recursive call, then print (for ascending order)
        PrintNincrement(n-1);
        System.out.println(n);
    }

    /**
     * Prints numbers from n to 1 in descending order using recursion
     * @param n The starting number
     */
    public static void PrintNdecriment(int n){
        if (n==0){
            // Base case: stop recursion when n reaches 0
            return;
        }

        // First print, then make recursive call (for descending order)
        System.out.println(n);
        PrintNdecriment(n-1);
    }

    /**
     * Prints the name "Avinash Sharma" n times with number prefix
     * @param n Number of times to print the name
     */
    public static void PrintName(int n){
        if (n==0){
            // Base case: stop recursion when n reaches 0
            return;
        }

        // Recursive call first, then print name with number
        PrintName(n-1);
        System.out.print(n+ " ");
        System.out.println("Avinash Sharma");
    }

    /**
     * Calculates sum of first n natural numbers using recursion
     * @param n The number up to which sum is calculated
     * @return The sum of numbers from 1 to n
     */
    public static int SumOfN(int n){
        if(n==0){
            // Base case: sum of 0 numbers is 0
            return 0;
        }

        // Add current number to sum of previous numbers
        return n+SumOfN(n-1);
    }

    /**
     * Calculates factorial of n using recursion
     * @param n The number whose factorial is calculated
     * @return The factorial of n
     */
    public static int Fact(int n){
        if (n == 0 || n == 1) {
            // Base case: factorial of 0 or 1 is 1
            return 1;
        }else {
            // Multiply current number with factorial of (n-1)
            return n*Fact(n-1);
        }
    }

    /**
     * Calculates sum of individual digits in a number using recursion
     * @param n The number whose digits are to be summed
     * @return The sum of all digits in the number
     */
    public static int SumOfDigit(int n){
        if(n==0){
            // Base case: no more digits to sum
            return 0;
        }
        // Add last digit (n%10) to sum of remaining digits
        return (n%10) + SumOfDigit(n/10);
    }


    /**
     * Calculates product of individual digits in a number using recursion
     * @param n The number whose digits are to be produced
     * @return The product of all digits in the number
     */
    public static int ProductOfDigit(int n){
        if(n==0){
            // Base case: no more digits to Product
            return 1;
        }
        // Add last digit (n%10) to Product of remaining digits
        return (n%10) * ProductOfDigit(n/10);
    }


    //Pre-Increment and Post-Increment Concept
    public static void PreIncrement(int n){
        if(n==0){
            return;
        }
        System.out.println(n);
        PreIncrement(--n);
    }

//    Reverse a number

    public static void ReverseN(int n){
        if(n==0){
            return;
        }
        int reverse=0;
        System.out.println(n);

        reverse = reverse*10 + (n%10) + (n/10);
    }










}