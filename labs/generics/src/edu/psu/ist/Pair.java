/**
 * Liam Geyer
 * IST242 - Writing Generic Classes and Methods
 * lfg5289@psu.edu
 */

package edu.psu.ist;

public final class Pair<T> {
    private T first; //  <-- pieces of data stored in the pair
    private T second;

    public Pair(T fst, T scd){
        this.first = fst;
        this.second = scd;
    }

    public T getFirst() {
        return first;
    }

    public T getSecond() {
        return second;
    }

    /**
     * Returns a string representation of the object
     */
    @Override
    public String toString(){
        return String.format("(%s, %s)", first, second);
    }

    /**
     * Swaps the first and second entries
     */
    public void swap(){
        T temp = this.first;
        this.first = this.second;
        this.second = temp;
    }
}
