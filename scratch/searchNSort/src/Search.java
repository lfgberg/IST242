import java.util.List;

/**
 * Liam Geyer
 * IST242 - Searching and Sorting alg notes
 * lfg5289@psu.edu
 */

public class Search {
    /**
     * Searches linearly through a list, O(n)
     * @param l list to search through
     * @param x item to find
     * @return index of x or -1
     */
    public static <T> int linearSearch(List<T> l, T x){
        for (T y : l){
            if (x == y){
                return l.indexOf(x);
            }
        }

        return -1;
    }

    /**
     * Removes half of the list to search through each time O(log(n))
     * @param l list to search through, must be in sorted order O(n) if you check this tho so don't?
     * @param x item to find
     * @return index of x or -1
     */
    public static <T extends Comparable<T>> int binarySearchRecursive(List<T> l, T x){  //  <-- kickoff
        return binarySearchRecursive(l, x, 0, l.size() - 1); //  <--  initially searches the entire array
    }

    private static <T extends Comparable<T>> int binarySearchRecursive(List<T> l, T x, int lBound, int uBound){
        //  stopping case
        if (uBound < lBound){
            return -1;
        }

        //  divide the list
        int mid = (lBound + uBound) / 2;

        if (x.equals(l.get(mid))){
            return mid; //  <-- found it
        } else if (x.compareTo(l.get(mid)) > 0){ // if key > arr
            //  if the key comes after whatever's at the mid then remove the first half
            return binarySearchRecursive(l, x, mid + 1, uBound);
        } else {
            //  key comes before mid, throw out the second half
            return binarySearchRecursive(l, x, lBound, mid - 1);
        }
    }

    public static void main(String[] args) {
        List<Integer> test = List.of(7, 22, 29, 32, 42, 52 , 59, 66, 69, 76);

        //  testing binary sort (recursive)
        System.out.println(binarySearchRecursive(test, 32)); // 3
        System.out.println(binarySearchRecursive(test, 7)); // 0
        System.out.println(binarySearchRecursive(test, 29)); // 2
        System.out.println(binarySearchRecursive(test, 76)); // 7
        System.out.println(binarySearchRecursive(test, 66)); //  9
    }
}
