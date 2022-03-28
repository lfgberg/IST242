import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Liam Geyer
 * ist242 - recursion examples
 * lfg5289@psu.edu
 */

public class RecursionExamples {
    public static void main(String[] args) {
        //  testing the sort
        List<Integer> nums = new ArrayList<>();
        nums.add(6);
        nums.add(4);
        nums.add(9);
        nums.add(0);
        nums.add(5);

        sort(nums);
        System.out.println();

        //  testing g
        g(3);
        System.out.println();

        //  factorial testing
        System.out.println(factorial(5));
        System.out.println();

        //  fib sequence testing
        System.out.println(fib(5));
        System.out.println(fib(10));
        System.out.println(fib(30));
        System.out.println();

        System.out.println(basedFib(5));
        System.out.println(basedFib(10));
        System.out.println(basedFib(30));
        System.out.println(basedFib(45));
        System.out.println();

        //  numNines testing
        System.out.println(countNines(909193));
        System.out.println();

        //  printNumPattern
        printNumPattern(12, 3);
        System.out.println();
        printNumPattern(8, 2);
        System.out.println();
        printNumPattern(6, 4);
        System.out.println();
        printNumPattern(17, 5);
    }

    public static void printNumPattern(int top, int step){
        if (top <= 0){
            System.out.println(top);
        } else {
            //  before recursion
            System.out.println(top);
            printNumPattern(top - step, step);

            //  after recursion
            System.out.println(top);
        }
    }

    /**
     * kickoff method hiding numNines
     */
    public static int countNines(int n){
        return countNines(n, 0);
    }

    /**
     * recursively counts the number of nines in an int
     */
    private static int countNines(int n, int numNines){
        if (n <= 0){
            return numNines;
        } else {
            int right = n % 10;
            if (right == 9){
                numNines++;
            }

            return countNines(n/10, numNines);
        }
    }

    /**
     * Kickoff method, public facing version, hides the map
     */
    public static int basedFib(int n){
        return basedFib(n, new HashMap<>());
    }

    /**
     * Uses a map to cache previously computed cache values
     * called memoization
     * keeping track of values we've seen and answers they give
     */
    private static int basedFib(int n, Map<Integer, Integer> memo){
        //  checks to see if the value is cached first
        if (memo.containsKey(n)){
            return memo.get(n);
        } else {
            //  base case
            if (n <= 1){
                return n;
            } else {
                //  does the same stuff, but stores values as we go
                int x = basedFib(n - 1, memo) + basedFib(n - 2, memo);
                memo.put(n, x);
                return x;
            }
        }
    }

    /**
     * Naive recursive fib sequence
     * redoes a lot of work, scales shittily
     * pseudo exponential
     */
    public static int fib(int n){
        if (n <= 1){
            return n;
        } else {
            return fib(n - 1) + fib(n - 2);
        }
    }

    /**
     * Recursively determines the factorial of an integer
     * @param n integer to take the factorial of
     * @return the factorial of n
     */
    public static int factorial(int n){
        if (n < 0){
            throw new IllegalArgumentException("n must be positive");
        } else if (n == 0){
            return 1;
        } else {
            return n * factorial(n - 1);
        }
    }

    /**
     * calls itself n times, then the stopping case calls the following print statement n times
     * @param n
     */
    public static void g(int n){
        if (n == 0){
            return;
        }

        //  before the recursive call
        System.out.println(n);
        g(n - 1);

        //  after the recursive call
        System.out.println(n);
    }

    /**
     * Destructively sorts a list of integers, from smallest to largest
     * utilizes recursion
     * @param l List to sort
     */
    public static void sort(List<Integer> l){
        //  prevents index out of bounds
        if (l.isEmpty()){
            return;
        } else {
            //  gets and displays the min
            Integer min = getMin(l);
            System.out.printf("Min: %d\n", min);

            //  remove the min and recurse
            l.remove(min);
            sort(l);
        }
    }

    /**
     * Helper method to find the smallest element in a list
     * @param l List of integers
     * @return smallest element in the list
     */
    private static Integer getMin(List<Integer> l){
        int min = l.get(0);
        for (int x : l){
            if (x < min){
                min = x;
            }
        }
        return min;
    }
}
