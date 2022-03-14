/*
* Liam Geyer
* IST242 - Big O and Collections activity
* lfg5289@psu.edu
 */

package edu.psu.ist;

import java.time.Year;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Tester {
    /*
    *  Problem 1
    * a - n^2
    * b - n^10
    * c - 2^n
    * d - n
    * e - log(n)
    * f - n^3
    * a-f: e, d, a, f, c, b
     */

    /**
     * Returns {@code true} if and only if {@param a} and {@param b}
     * contain the same entries in some order, and each entry has the same multiplicity
     * @param a a list of type T
     * @param b a list of type T
     */
    public static <T> boolean sameEntries(List<T> a, List<T> b){
        //  niche case, why iterate through if they're the same
        if (a.equals(b)){ //  O(1)
            return true; //  O(1)
        }

        /*
        order doesn't matter
        a hashmap can track the occurrences of each entry,
        is fast, and doesn't have an order
         */
        Map<T, Integer> c = new HashMap<>(); //  O(1)
        Map<T, Integer> d = new HashMap<>(); //  O(1)

        //  populate the maps based off the lists
        for (T x : a){ // O(n) * O(1) = O(n)
            c.put(x, (c.getOrDefault(x, 0) + 1)); // O(1)
        }
        for (T x : b){ // O(n) * O(1) = O(n)
            d.put(x, (d.getOrDefault(x, 0) + 1)); // O(1)
        }

        return c.equals(d); // O(1)
    } // O(1) + O(1) + O(1) + O(1) + O(n) + O(n) + O(1) = O(n)

    public static void main(String[] args) {
        //  Testing sameEntries
        System.out.println(sameEntries(List.of(), List.of()));  // true
        System.out.println(sameEntries(List.of(1), List.of())); // false
        System.out.println(sameEntries(List.of(), List.of(1))); // false
        System.out.println(sameEntries(
                List.of(1, 3, 3, 2, 1),
                List.of(1, 3, 1, 3, 2)));                       // true
        System.out.println();

        System.out.println(sameEntries(
                List.of(1, 4, 9, 16, 9, 7, 4, 9, 11),
                List.of(11, 1, 4, 9, 16, 9, 7, 4, 9))); // true
        System.out.println(sameEntries(
                List.of(1, 4, 9, 16, 9, 7, 4, 9, 11),
                List.of(11, 1, 4, 9, 15, 9, 7, 4, 9))); // false
        System.out.println();

        System.out.println(sameEntries(
                List.of('a', 'x', 'c', 'm', 'c', 'c', 'x', 'j'),
                List.of('a', 'x', 'c', 'm', 'c', 'x', 'j')));      // false
        System.out.println(sameEntries(
                List.of('a', 'x', 'c', 'm', 'c', 'c', 'x', 'j'),
                List.of('u', 'a', 'x', 'c', 'm', 'c', 'x', 'j')));  // false
        System.out.println(sameEntries(
                List.of('a', 'x', 'c', 'm', 'c', 'c', 'x', 'j'),
                List.of('c', 'a', 'x', 'c', 'm', 'c', 'x', 'j')));  // true
        System.out.println();

        System.out.println(sameEntries(
                List.of(2.0, 1.0),
                List.of(2.0, 1.0, 3.0)));   // false
        System.out.println(sameEntries(
                List.of(0.0, 1.0),
                List.of(2.0, 3.0)));        // false
        System.out.println(sameEntries(
                List.of(1.0, 2.0),
                List.of(2.0, 1.0)));        // true
        System.out.println(sameEntries(
                List.of(3.0, 1.0, -4.5),
                List.of(-4.5, 3.0, 1.0)));  // true
        System.out.println();

        System.out.println(sameEntries(
                List.of(Year.of(1900), Year.of(1905)),
                List.of(Year.of(1906), Year.of(1906)))); // false
        System.out.println(sameEntries(
                List.of(Year.of(1900)),
                List.of(Year.of(1900))));                // true
    }
}
