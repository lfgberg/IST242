import java.util.*;

/**
 * Liam Geyer
 * IST242 - Searching and Sorting alg notes
 * lfg5289@psu.edu
 */

public class Sort {
    /**
     * Sorts a list of objects in ascending order; is destructive
     * O(n^2)
     * @param l list of type T
     */
    public static <T extends Comparable<T>> void insertionSort(List<T> l){
        int i = 1;
        while (i < l.size()){
            int j = i;
            while (j > 0 && l.get(j - 1).compareTo(l.get(j)) > 0){
                Collections.swap(l, j, j -1 );
                j--;
            }
            i++;
        }
    }

    /**
     * Sort a list of objects in ascending order recursively and quickly
     * O(n * log (n))
     * @param l list of type T
     */
    public static <T extends Comparable<T>> void mergeSort(List<T> l){ //  <-- kickoff

    }

    public static <T extends Comparable<T>> void mergeSort(List<T> l, List<T> m){

    }

    public static void main(String[] args) {
        //  testing insertionSort
        List<Integer> test = Arrays.asList(6, 5, 3, 1, 8, 7, 2, 4);
        insertionSort(test);
        System.out.println(test);
    }
}
