/**
 * Liam Geyer
 * IST242 - Quiz 4, Recursion, Searching and Sorting, Big-O
 */

public class Quiz {
    /**
     * Your supervisor at a local 'Amarzoom' warehouse has recently developed a
     * (strange) affinity for a nice pile of neatly stacked crates.
     * <p>
     * To impress your supervisor, you've taken it upon yourself to write a
     * method, stackRecur, that recursively computes the total number of crates
     * stacked for all rows (no mult. and/or loops allowed).
     * <p>Some examples:
     * <ul>
     *      <li>stackRecur(0) returns 0</li>
     *      <li>stackRecur(1) returns 1</li>
     *      <li>stackRecur(2) returns 3</li>
     * </ul>
     * @param rows the number of rows; the very top row has 1 crate the next row
     *             has 2, so on so forth.
     * @return the total number of crates.
     */
    public static int stackRecur(int rows) { //  <-- kickoff
        return stackRecur(rows, 0);
    }

    private static int stackRecur(int rows, int total){ //  <-- this one keeps a running tally
        //  stopping case
        if (rows == 0){
            return total;
        }

        //  add to tally, recurse
        return stackRecur(rows - 1, total + rows);
    }

    /**
     * An edit region is defined as a sequence of chars enclosed by two square
     * brackets '[' and ']'. While edit regions cannot nest or overlap, multiple
     * (disjoint) edit regions may exist in a given string.
     * <p>
     * Write a recursive algorithm (so no loops, multiplication, etc.) that
     * that finds the longest edit region in a given string {@code s} and
     * returns its length.
     * <p>Some examples:
     * <ul>
     *     <li>editRgnDist("meow. [mark make coffee].. [jerry] bring [wa]ter.") returns 18</li>
     *     <li>editRgnDist("[]i[max][m]") returns 5</li>
     *     <li>editRgnDist("[supersort]") returns 11</li>
     *     <li>editRgnDist("...") returns 0</li>
     *     <li>editRgnDist("[]") returns 2</li>
     * </ul>
     * <b>Note:</b> you may assume {@code s} and the edit regions contained are
     * well-formed (i.e.: no overlaps or nesting, and every '[' and has a
     * corresponding ']', etc.)
     *
     * @param s the string containing edit regions
     * @return the length of the maximum/longest edit region.
     */
    public static int editRgnDist(String s) { //  <-- kickoff
        return editRgnDist(s, 0);
    }

    private static int editRgnDist(String s, int result){
        /*
          determine if there's an edit region within the current string
          we assume all edit regions are well-formed
         */
        if (!s.contains("[")) { //  <-- stopping case, no edit region, return biggest one seen or -1
            return result;
        }

        //  find the length of the edit region
        int x = s.substring(s.indexOf("["), s.indexOf("]") + 1).length();

        /*
          recurse, this time searching the string AFTER the first edit region
          if the length of this edit region is bigger than the current result, make it the new result
         */
        return editRgnDist(s.substring(s.indexOf("]") + 1), x > result ? x : result);
    }

    public static void main(String[] args) {
        //  testing stackRecur
        System.out.println(stackRecur(0)); //  0
        System.out.println(stackRecur(1)); //  1
        System.out.println(stackRecur(2)); //  3
        System.out.println(stackRecur(3) + "\n"); //  6

        //  testing editRgnDist
        System.out.println(editRgnDist("...")); //  0
        System.out.println(editRgnDist("[]")); //  2
        System.out.println(editRgnDist("[supersort]")); //  11
        System.out.println(editRgnDist("[]i[max][m]")); //  5
        System.out.println(editRgnDist("meow. [mark make coffee].. [jerry] bring [wa]ter.")); //  18
    }
}
