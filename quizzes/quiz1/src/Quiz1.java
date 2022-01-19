/*
* Liam Geyer
* IST242 - Quiz1
* lfg5289@psu.edu
 */

import java.util.Arrays;

public class Quiz1 {
    /*
    Zeros out all but the first and last entries in an array
     */
    public static int[] zeroMid(int[] a){
        int[] result = new int[a.length];

        //  if there are no middle elements; no need to modify the array
        if (a.length == 1 || a.length == 2){
            return a;
        } else {
            for (int i = 0; i < a.length; i++){
                //  leave the first and last elements the same
                if (i == 0 || i == a.length - 1){
                    result[i] = a[i];
                } else {
                    //  zero out the rest
                    result[i] = 0;
                }
            }
        }

        return result;
    }

    /*
    Returns the number of times keydigit appears in n
     */
    public static int countInNum(int n, int keyDigit){
        int count = 0;

        while (n > 0){
            //  take the rightmost digit
            int right = n % 10;

            //  count each digit that matches
            if (right == keyDigit){
                count++;
            }

            //  remove the rightmost digit
            n = n / 10;
        }

        return count;
    }

    /*
    Returns true if any two entries in a sum to target
     */
    public static boolean hasSol(int[] a, int target){
        //  outlier case, must be at least 2 numbers
        if (a.length < 2){
            return false;
        }

        //  sum each combination of numbers, see if they result in the target
        for (int i = 0; i < a.length; i++){
            for (int j = 1; j < a.length; j++){
                if (a[i] + a[j] == target){
                    return true;
                }
            }
        }

        return false;
    }

    public static void main(String[] args) {
        // should print [4, 0, 0, 3]
        System.out.println(Arrays.toString(zeroMid(new int[]{4, 5, 6, 3})));
        // should return array: [4]
        System.out.println(Arrays.toString(zeroMid(new int[]{4})));
        // should return array: [4, 5]
        System.out.println(Arrays.toString(zeroMid(new int[]{4, 5})));

        System.out.println(countInNum(30454, 4)); // should return 2 (since 4 appears twice)
        System.out.println(countInNum(30454, 1)); // should return 0
        System.out.println(countInNum(202002, 2)); // should return 3

        System.out.println(hasSol(new int[]{3, 2, 4}, 7)); // true, 3 + 4 == target  (7 is the target)
        System.out.println(hasSol(new int[]{3, 2, 4}, 6)); // true, since 2 + 4 == target
        System.out.println(hasSol(new int[]{3, 2, 4}, 2)); // false, no two numbers present sum to target
        System.out.println(hasSol(new int[]{3, 2, 4, 0}, 2)); // true, 2 + 0 == target
    }
}
