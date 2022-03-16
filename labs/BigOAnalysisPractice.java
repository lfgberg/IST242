public class BigOAnalysisPractice {

    // WRITE YOUR NAME AND YOUR PARTNER'S NAME HERE:
    //  PARTNER 1: Liam Geyer
    //  PARTNER 2: Steve Emrick

    ////////////////////////////////////////////////////////
    ///// Runtime (Big-O) Analysis /////////////////////////
    ////////////////////////////////////////////////////////

    // 1.
    // Big-O is: O(1)
    public static void printFirstItem(int[] items) {
        System.out.println(items[0]);
    }

    // 2.
    // Big-O is: O(N)
    public static void mystery1(int n) {
        int[] arr = new int[n]; // 1
        int sum = 0; // 1
        for (int i = 1; i <= Math.pow(2, arr.length); i++) { // n
            sum = sum + i;
        }
    }

    // 3.
    // Big-O is: O(n)
    public static void mystery2(int n) {
        int[] arr = new int[n];

        for (int i = 0; i < arr.length; i++) { // n
            System.out.println(i);
        }
    }

    // 4.
    // Big-O is: O(log(n))
    public static void mystery3(int n) {
        int[] arr = new int[n];

        for (int i = 1; i < n; i = i * 2) { // n
            System.out.println(i);
        }
    }

    // 5.
    // Big-O is: O(1)
    public static void mystery4() {
        Integer n = 1000;
        System.out.println(n.toString());
    }

    // 6.
    // Big-O is: O(n^2)
    public static void mystery5(int[] items) {
        for (int firstItem : items) { // n
            for (int secondItem : items) { // n
                System.out.println(firstItem + ", " + secondItem);
            }
        }
    }

    // 7.
    // Big-O is: O(n)
    public static void mystery6(int[] items) {
        for (int item : items) { // n
            System.out.println(item);
        }

        for (int item : items) { // n
            System.out.println(item);
        }
    }

    // 8.
    // Big-O is: O(n) + O(n^2) = O(n^2)
    public static void print(int[] numbers) {

        System.out.println("these are the numbers:"); // 1
        for (int number : numbers) { // n
            System.out.println(number); // 1
        }

        System.out.println("and these are their sums:");
        for (int firstNumber : numbers) { // n
            for (int secondNumber : numbers) { // n
                System.out.println(firstNumber + secondNumber);
            }
        }
    }

    public static void main(String[] args) {

