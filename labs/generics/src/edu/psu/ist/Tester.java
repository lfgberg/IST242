/**
 * Liam Geyer
 * IST242 - Writing Generic Classes and Methods
 * lfg5289@psu.edu
 */

package edu.psu.ist;

import java.time.Year;
import java.util.List;

public class Tester {
    public static void main(String[] args) {
        //  testing checkorder
        System.out.println(checkOrder("a", "d", "b", "g")); // should print 0
        System.out.println(checkOrder(2.3, 3.4, 4.5, 5.6)); // should print -1
        System.out.println(checkOrder(5, 3, 2, 1)); // should print 1
        System.out.println(checkOrder('c', 'd', 'h', 'i')); // should print -1
        System.out.println(checkOrder('c', 'd', 'h', 'a')); // should print 0
        System.out.println(checkOrder(
                Year.of(2002), Year.of(2001), Year.of(2000), Year.of(1990))); // should print 1
        System.out.println();

        //  testing pair
        Pair<Integer> intPair = new Pair<>(1, 6);
        System.out.println(intPair); // (1, 6)
        intPair.swap();
        System.out.println(intPair); // (6, 1)
        intPair.swap();
        System.out.println(intPair); // (1, 6)

        Pair<String> stringPair = new Pair<>("moo", "oom");
        System.out.println(stringPair); // (moo, oom)
        stringPair.swap();
        System.out.println(stringPair); // (oom, moo)
        stringPair.swap();
        System.out.println(stringPair); // (moo, oom)
        System.out.println();

        //  testing minmax
        try {
            System.out.println(minMax(List.of(1, 0, 5, 8))); // (0, 8)
            //System.out.println(minMax(List.<Integer>of()));  // uncommenting should trigger an IllegalArgument exception
            System.out.println(minMax(List.of(5))); // (5, 5);
            System.out.println(minMax(List.of('a', 'b', 'c', 'd', 'a'))); // (a, d)
            System.out.println(minMax(List.of("b", "e", "b", "g", "a"))); // (a, g)
            System.out.println(minMax(List.of(Year.of(1939), Year.of(1941),
                    Year.of(1914), Year.of(1945), Year.of(2001)))); // (1914, 2001)
        } catch (Exception e){
            System.out.println(e.getMessage());
        }
    }

    /**
     * Determines the order of generic parameters
     * @return {@code -1} if ascending, {@code 1} if descending, {@code 0} if unordered
     */
    public static <T extends Comparable<T>> int checkOrder(T t1, T t2, T t3, T t4){
        //  check for ascending/descending
        if (t1.compareTo(t2) <= 0 && t2.compareTo(t3) <= 0 && t3.compareTo(t4)<= 0){
            return -1; // <-- ascending
        } else if (t1.compareTo(t2) >= 0 && t2.compareTo(t3) >= 0 && t3.compareTo(t4) >= 0){
            return 1; //  <-- descending
        }

        //  parameters are unordered
        return 0;
    }

    public static <T extends Comparable<T>> Pair<T> minMax(List<T> input) throws Exception {
        if (input.isEmpty()){
            throw new IllegalArgumentException("Inputted list must be populated.");
        }

        T max = input.get(0);
        T min = input.get(0);

        //  iterate over the list to determine the min/max
        for (T x : input){
            if (x.compareTo(max) > 0){
                max = x;
            }

            if (x.compareTo(min) < 0){
                min = x;
            }
        }

        return new Pair<T>(min, max);
    }
}
