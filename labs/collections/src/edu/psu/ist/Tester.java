/**
 * Liam Geyer
 * IST242 - Working w/ Collections
 * lfg5289@psu.edu
 */

package edu.psu.ist;

import java.util.*;

public class Tester {
    public static void main(String[] args) {
        //  testing rmDups
        System.out.println(rmDups(List.of(4, 4, 5, 5, 3, 5))); //  <-- returns [4, 5, 3]
        System.out.println(rmDups(List.of())); //  <-- returns []
        System.out.println(rmDups(List.of(4))); //  <-- returns [4]
        System.out.println(rmDups(List.of(4, 7, 11, 4, 9, 5, 11, 7, 3, 5))); //  <-- returns [4, 7, 11, 9, 5, 3]

        // testing histo
        System.out.println(histo(List.of("a", "b", "c", "a", "b", "b")));
        /*
         * Returns:
         *     "a" --> 2
         *     "b" --> 3
         *     "c" --> 1
         */
    }

    /**
     * Write a method, rmDups, that accepts an {@code input} list containing
     * integers, and returns a new list containing only the unique
     * (non-duplicated) elements from {@code input}.
     * <p>
     * <b>Note:</b> the returned list should preserve the relative ordering of
     * the entries contained the input list (while still removing duplicates).
     * For example:
     * <ul>
     *     <li>rmDups(List.of(4, 4, 5, 5, 3, 5)) returns [4, 5, 3];</li>
     *     <li>rmDups(List.of()) returns [];</li>
     *     <li>rmDups(List.of(4)) returns [4];</li>
     *     <li>rmDups(List.of(4, 7, 11, 4, 9, 5, 11, 7, 3, 5))
     *      returns [4, 7, 11, 9, 5, 3].</li>
     * </ul>
     * In the last example, if this method had returned {@code [4, 11, 7, 9, 5, 3]}
     * duplicates would indeed be removed, but the original order wouldn't be
     * preserved (as 7 and 11 have swapped positions).
     *
     * @param input the input list.
     * @return the output list that has no duplicates that preserves the input
     * lists original order.
     */
    public static List<Integer> rmDups(List<Integer> input) {
        List<Integer> result = new ArrayList<>();
        Set<Integer> seen = new HashSet<>();

        //  will add each entry to a set, and only add to the result list if it doesn't exist in the set already
        for (int x : input){
            if (!seen.contains(x)){
                result.add(x);
            }
            seen.add(x);
        }

        return result;
    }

    /**
     * Write a method, histo, that takes a list of strings as input and returns
     * a map that contains a key for each string in the {@code input} list and
     * maps it to the number of times that string appears.
     * <p>
     * In other words, the returned map is histogram that holds the number of
     * occurrences of each string in the {@code input} list. Some examples:
     * <p>
     * For example:
     * <pre>
     *     histo(List.of("a", "b", "c", "a", "b", "b"));
     * </pre>
     * would return a map that has the following key value pairs:
     * <pre>
     *     "a" --> 2
     *     "b" --> 3
     *     "c" --> 1
     * </pre>
     * Make sure your solution is working in the main by calling {@link Map#get(Object)}
     * on various keys to ensure the count is correct.
     *
     * @param input the input list containing string occurrences to be counted
     * @return a histogram that counts occurrences of the strings in the
     * {@code input} list.
     */
    public static Map<String, Integer> histo(List<String> input) {
        Map<String, Integer> result = new HashMap<>();

        for (String x : input){
            result.put(x, (result.getOrDefault(x, 0) + 1));
        }

        return result;
    }
}
