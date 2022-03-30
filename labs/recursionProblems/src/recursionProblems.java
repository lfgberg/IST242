/*
* Liam Geyer
* IST242 - recursion problems
* lfg5289@psu.edu
 */

import java.util.ArrayList;
import java.util.List;
import java.util.function.Function;

public class recursionProblems {
    /**
     * <b>Question 1:</b>
     * <p>
     * Write a recursive method, fstStr, that finds and returns the index of the
     * first occurrence of a given {@code key} string within a given {@code arr}
     * of strings. If {@code key} doesn't occur in {@code a}, the method
     * should return -1.
     * <p><b>Some examples:</b>
     * <ul>
     *     <li>fstStr(new String[]{"cat", "fish", "dog", "apple"}, "fish") returns 1</li>
     *     <li>fstStr(new String[]{"moo"}, "moo") returns 0</li>
     *     <li>fstStr(new String[]{}, "mooooo") returns -1</li>
     * </ul>
     * <b>Hint:</b> for this problem, you may find it helpful to define a
     * helper method that takes additional parameters.
     *
     * @param arr the array of strings being searched.
     * @param key the string being searched for.
     * @return index of the first occurrence of {@code key} in array
     * {@code arr}; -1 otherwise.
     */
    public static int fstStr(String[] arr, String key){ //  <- kickoff
        return fstStr(arr, key, 0);
    }

    private static int fstStr(String[] arr, String key, int index){
        //  check str, recurse if doesn't match :)
        if (index <= arr.length - 1){
            if (arr[index].equals(key)){
                return index;
            } else {
                return fstStr(arr, key, index + 1);
            }
        }
        return -1;
    }

    /**
     * <b>Question 2:</b>
     * <p>
     * Write a method, findFirstChar, that recursively finds and returns the
     * index of the <em>first</em> occurrence of the {@code toFind} char in the
     * string {@code toSearch}.
     * <p><b>Some examples:</b>
     * <ul>
     *     <li>findFirstChar("catatonic", 'a') returns 1</li>
     *     <li>findFirstChar("ooooo", 'o') returns 0</li>
     *     <li>findFirstChar("ooook", 'k') returns 4</li>
     *     <li>findFirstChar("oommok", 'm') returns 2</li>
     *     <li>findFirstChar("vroom", 'z') returns -1</li>
     * </ul>
     *
     * @param toSearch The string being searched.
     * @param toFind   The character we want to find in the string.
     * @return the index of the first occurrence of {@code toFind} in string.
     * {@code toSearch}; -1 if it's not found.
     */
    public static int findFirstChar(String toSearch, char toFind){ //  <- kickoff
        return findFirstChar(toSearch, toFind, 0);
    }

    private static int findFirstChar(String toSearch, char toFind, int index){
        //  check char, recurse if not :)
        if (index <= toSearch.length() - 1){
            if (toSearch.charAt(index) == toFind){
                return index;
            } else {
                return findFirstChar(toSearch, toFind, index + 1);
            }
        }
        return -1;
    }

    /**
     * <b>Question 3:</b>
     * <p>
     * Write a method, countNumOf, that recursive finds and returns the number
     * of times the specified {@code target} string appears in the string
     * {@code str}.
     * <p>
     * Again, consider defining a recursive helper method to track additional
     * info.
     * <p><b>Some examples:</b>
     * <ul>
     *     <li>countNumOf("xxmooxx", "moo") returns 1</li>
     *     <li>countNumOf("xmooxmoox", "x") returns 3</li>
     *     <li>countNumOf("mooo", "moo") returns 1</li>
     *     <li>countNumOf("mooo", "moooooo") returns 0 (target is longer than str)</li>
     *     <li>countNumOf("mississipi", "is") returns 2</li>
     *     <li>countNumOf("dodo", "dodo") returns 1</li>
     *     <li>countNumOf("dodo", "do") returns 2</li>
     *     <li>countNumOf("mmmm", "m") returns 4</li>
     *     <li>countNumOf("mmmm", "mmm") returns 1</li>
     * </ul>
     */
    public static int countNumOf(String str, String target){ //  <- kickoff
        //  edge case, target is longer than str
        if (target.length() > str.length()){
            return 0;
        }

        return countNumOf(str, target, 0, 0);
    }

    private static int countNumOf(String str, String target, int index, int numSeen){
        /*
        iterate through each set of target.length() chars
        steps through by one
         */
        if (index + target.length() <= str.length()){
            String s = str.substring(index, index + target.length());
            if (s.equals(target)){
                numSeen++;
            }

            return countNumOf(str, target, index + 1, numSeen);
        }
        return numSeen;
    }

    /**
     * <b>Question 4:</b>
     * <p>
     * Write a recursive method, sepPairWithStar, that takes a source string
     * {@code str} and returns another string that is the same as the source
     * string, but with all consecutive chars separated by an asterisk: *.
     * <p>
     * If the input {@code str} is of length less than 2, then just return it;
     * for simplicity, you may also assume the input {@code str} doesn't contain
     * any *'s.
     * <p><b>Some examples:</b>
     * <ul>
     *     <li>sepPairWithStar("hello") returns "hel*lo"</li>
     *     <li>sepPairWithStar("xxyy") returns "x*xy*y"</li>
     *     <li>sepPairWithStar("aaaa") returns "a*a*a*a"</li>
     *     <li>sepPairWithStar("a") returns "a"</li>
     *     <li>sepPairWithStar("") returns ""</li>
     *     <li>sepPairWithStar("a*a*ab") returns "a*a*ab"</li>
     *     <li>sepPairWithStar("someone") returns "someone"</li>
     * </ul>
     * <p>
     * <b>Hint:</b> As usual, you may find it helpful to define a helper method
     * for this one that takes an extra parameter
     * (think about useful extra parameter(s)).
     *
     * @param str the source string.
     * @return the source string, but with all consecutive matching chars
     * separated by an asterisk.
     */
    public static String sepPairWithStar(String str){ //  <- kickoff
        //  niche case, if string is less than 2 there's nothing to iterate through
        if (str.length() < 2){
            return str;
        }

        return sepPairWithStar(str, "", 0);
    }

    private static String sepPairWithStar(String str, String result, int index){
        //  check each set of 2 chars, add to result with a seperator if needed, recurse
        if (index <= str.length() - 2){
            char c = str.charAt(index);
            result = result + str.charAt(index);

            if (c == str.charAt(index + 1)){
                result = result + "*" + str.charAt(index + 1);
                index++;
            }

            return sepPairWithStar(str, result, index + 1);
        } else if (index == str.length() - 1){
            result = result + str.charAt(index);
        }
        return result;
    }

    /**
     * <b>Question 5:</b>
     * <p>
     * Write a recursive method parameterized by a generic type T named filter.
     * The method should take a function, pred, that accepts an element of type
     * T and produces a value of type boolean. The method should also accept a
     * target {@link List<T>} called {@code toFilter} that is the list being
     * filtered.
     * <p><b>Some examples:</b>
     * <ul>
     *     <li>filter(x -> x > 5, List.of(5, 4, 5)) returns [] </li>
     *     <li>filter(x -> x < 5, List.of(5, 4, 5)) returns [4]</li>
     *     <li>filter(x -> true, List.of()) returns []</li>
     *     <li>filter(x -> x.length() > 4,
     *            List.of("cat", "fish", "buzzzz", "b", "doggo")) returns ["buzzzz", "doggo"]</li>
     *     <li>filter(x -> !x.startsWith("b"),
     *            List.of("bat", "fish", "buzzzz", "b", "boom")) returns ["fish"]</li>
     * </ul>
     *
     * @param pred  The higher order function/predicate we'll use to filter.
     * @param toFilter The list to be filtered (<em>should not be modified</em>).
     * @param <T> The type of element for the list.
     * @return the filtered list.
     */
    public static <T> List<T> filter(Function<T, Boolean> pred, List<T> toFilter){ //  <- kickoff
        return filter(pred, toFilter, new ArrayList<>(), 0);
    }

    public static <T> List<T> filter(Function<T, Boolean> pred, List<T> toFilter, List<T> result, int index){
        if (index < toFilter.size()){
            if (pred.apply(toFilter.get(index))){
                result.add(toFilter.get(index));
            }
            return filter(pred, toFilter, result, index + 1);
        }

        return result;
    }

    public static void main(String[] args) {
        //  testing fstStr
        System.out.println(fstStr(new String[]{"cat", "fish", "dog", "apple"}, "fish"));
        System.out.println(fstStr(new String[]{"moo"}, "moo"));
        System.out.println(fstStr(new String[]{}, "mooooo") + "\n");

        //  testing findFirstChar
        System.out.println(findFirstChar("catatonic", 'a'));
        System.out.println(findFirstChar("ooooo", 'o'));
        System.out.println(findFirstChar("ooook", 'k'));
        System.out.println(findFirstChar("oommok", 'm'));
        System.out.println(findFirstChar("vroom", 'z') + "\n");

        //  testing countNumOf
        System.out.println(countNumOf("xxmooxx", "moo"));
        System.out.println(countNumOf("xmooxmoox", "x"));
        System.out.println(countNumOf("mooo", "moo"));
        System.out.println(countNumOf("mooo", "moooooo"));
        System.out.println(countNumOf("mississipi", "is"));
        System.out.println(countNumOf("dodo", "dodo"));
        System.out.println(countNumOf("dodo", "do"));
        System.out.println(countNumOf("mmmm", "m"));
        System.out.println("I overlap :( " + countNumOf("mmmm", "mmm") + "\n");

        //  testing sepPairWithStar
        System.out.println(sepPairWithStar("hello"));
        System.out.println(sepPairWithStar("xxyy"));
        System.out.println(sepPairWithStar("aaaa"));
        System.out.println(sepPairWithStar("a"));
        System.out.println(sepPairWithStar(""));
        System.out.println(sepPairWithStar("a*a*ab"));
        System.out.println(sepPairWithStar("someone") + "\n");

        //  testing filter
        System.out.println(filter(x -> x > 5, List.of(5, 4, 5)));
        System.out.println(filter(x -> x < 5, List.of(5, 4, 5)));
        System.out.println(filter(x -> true, List.of()));
        System.out.println(filter(x -> x.length() > 4, List.of("cat", "fish", "buzzzz", "b", "doggo")));
        System.out.println(filter(x -> !x.startsWith("b"), List.of("bat", "fish", "buzzzz", "b", "boom")));
    }
}
