import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

/**
 * Liam Geyer
 * IST242 - searching and sorting model
 * lfg5289@psu.edu
 */

public final class SearchAndSortAlgoModel<T extends Comparable<T>> {

    /**
     * The methods of this class should not <em>mutate</em> this list, but
     * rather, make defensive copies when modification is needed.
     */
    private List<T> data;

    public SearchAndSortAlgoModel(List<T> data) {
        this.setData(data);
    }

    @SafeVarargs
    public SearchAndSortAlgoModel(T... data) {
        this(Arrays.asList(data));
    }

    /**
     * Sets a list of integers (in an arbitrary order and length) as the
     * dataset for this class.
     * <p>
     * <b>NB:</b> this method will technically run in O(n) as we defensively
     * transform the provided {@link List} to an {@link ArrayList} specifically
     * to guarantee fast random access with algorithms supported by this class.
     *
     * @param data An arbitrarily long (potentially) unordered list of integers.
     */
    public void setData(List<T> data) { this.data = new ArrayList<>(data); }

    public List<T> getData() { return data; }

    // here's an example of how you would add the insertion sort algorithm to this class
    public List<T> selectionSortRecursive() {
        // copy this.data (to preserve the original this.data list)
        List<T> copyList = new ArrayList<>(data);

        insertionSort(copyList); // sort the copy list
        return copyList;         // return the (now sorted) copy list
    }

    private void insertionSort(List<T> input) {
        int i = 1;
        while (i < input.size()) {
            int j = i;
            while (j > 0 && input.get(j - 1).compareTo(input.get(j)) > 0) {
                Collections.swap(input, j, j - 1);
                j--;
            }
            i++;
        }
    }

    /**
     * @return a sorted copy of the model utilizing the recursive merge sort
     */
    public List<T> mergeSortRecursive(){
        //  create a copy of the data so we don't mutate it
        List<T> l = new ArrayList<>(data);
        mergeSort(l); //  <-- kickoff!

        return l;
    }

    private void mergeSort(List<T> l){
        //  stopping case; list of 1 is arbitrarily sorted
        if (l.size() <= 1){
            return;
        }

        //  split the og list into 2
        List<T> first = l.subList(0, l.size() / 2);
        List<T> second = l.subList(l.size() / 2, l.size());

        //  sort each half
        mergeSort(first);
        mergeSort(second);

        //  merge em
        mergeSort(l, first, second);
    }

    /**
     * Actually performs the merge between two lists
     * @param l the original copy list to mutate
     * @param first first half of the list
     * @param second second half of the list
     */
    private void mergeSort(List<T> l, List<T> first, List<T> second){
        int iFirst = 0;
        int iSecond = 0;
        int j = 0;

        //  merge the lists
        while (iFirst < first.size() && iSecond < second.size()){
            if (first.get(iFirst).compareTo(second.get(iSecond)) < 0){
                l.set(j, first.get(iFirst));
                iFirst++;
            } else {
                l.set(j, second.get(iSecond));
                iSecond++;
            }
            j++;
        }

        //  add remaining entries
        while (iFirst < first.size()){
            l.set(j, first.get(iFirst));
            iFirst++; j++;
        }

        while (iSecond < second.size()){
            l.set(j, second.get(iSecond));
            iSecond++; j++;
        }
    }

    /**
     * @return a sorted copy of the model utilizing the iterative bubble sort
     */
    public List<T> bubbleSortIterative(){
        //  create a copy so we don't mutate the model
        List<T> l = new ArrayList<>(data);

        boolean swap = false;

        //  loop until sorted
        while (swap){
            swap = false;

            //  iterate through data
            for (int i = 0; i < l.size() - 1; i++){
                //  if the element before this one is bigger, swap em
                if (l.get(i - 1).compareTo(l.get(i)) > 0){
                    Collections.swap(l, i - 1, i);
                    swap = true; //  <--  gotta keep goin
                }
            }
        }

        return l;
    }

    /**
     * Recursively iterates through the list to find an object {@param x}
     * @param x object to find
     * @return index of {@param x} or -1
     */
    public int linearSearchRecursive(T x){
        return linearSearchRecursive(x, 0); //  <-- kickoff
    }

    private int linearSearchRecursive(T x, int index){
        //stopping case
        if (index == data.size()){
            return -1;
        }

        //  recurse!
        return x.equals(data.get(index)) ? index : linearSearchRecursive(x, index + 1);
    }

    /**
     * Linearly iterates through the list to find an object {@param x}
     * @param x object to find
     * @return index of {@param x} or -1
     */
    private int linearSearchIterative(T x){
        //  iterate through the list to find x
        for (T y : data){
            if (x.equals(y)){
                return data.indexOf(x);
            }
        }
        //  couldn't find x
        return -1;
    }

    /**
     * Uses a recursive binary search algorithm to find an object, {@param x}
     * @param x object to find
     * @return the index of the object, or -1
     */
    public int binarySearchRecursive(T x){
        return binarySearchRecursive(x, 0, data.size() - 1);
    }

    // I know this is funky I copied it from my other project and CBA to change it to just work with the field

    /**
     * Removes half of the list to search through each time O(log(n))
     * @param x item to find
     * @return index of x or -1
     */
    private int binarySearchRecursive(T x, int lBound, int uBound){
        //  stopping case
        if (uBound < lBound){
            return -1;
        }

        //  divide the list
        int mid = (lBound + uBound) / 2;

        if (x.equals(data.get(mid))){
            return mid; //  <-- found it
        } else if (x.compareTo(data.get(mid)) > 0){ // if key > arr
            //  if the key comes after whatever's at the mid then remove the first half
            return binarySearchRecursive(x, mid + 1, uBound);
        } else {
            //  key comes before mid, throw out the second half
            return binarySearchRecursive(x, lBound, mid - 1);
        }
    }
}
