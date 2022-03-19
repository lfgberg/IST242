/*
 * Liam Geyer
 * IST242 - Splittable List
 * lfg5289@psu.edu
 */

package edu.psu.ist.model;

import java.util.ArrayList;
import java.util.List;
import java.util.NoSuchElementException;

public class UtilListImpl<T> implements ISplittableList<T> {
    private final List<T> left = new ArrayList<>();
    private final List<T> right = new ArrayList<>();


    @Override
    public void addToRightAtFront(T e) { // O(1)
        right.add(0, e);
    }

    @Override
    public T removeFromRightAtFront() throws NoSuchElementException { // O(1)
        // defensive check
        if (right.isEmpty()){
            throw new NoSuchElementException("Right side must be non-empty");
        }

        //  remove and return first element
        T x = right.get(0);
        right.remove(0);

        return x;
    }

    @Override
    public void moveToVeryBeginning() { // O(1)
        //  create a temp list with all the entries from left, and then right
        List<T> x = new ArrayList<>();
        x.addAll(left);
        x.addAll(right);

        //  clear, and then copy x to right
        left.clear();
        right.clear();
        right.addAll(x);
    }

    @Override
    public void moveForward() throws IllegalStateException { // O(1)
        //  defensive check
        if (right.isEmpty()){
            throw new IllegalStateException("Cannot move forward; right is empty");
        }

        //  remove the first element of the right list + add to left
        left.add(this.removeFromRightAtFront());
    }

    @Override
    public int leftLength() { // O(1)
        return left.size();
    }

    @Override
    public int rightLength() { // O(1)
        return right.size();
    }

    @Override
    public void clear() { // O(1)
        left.clear();
        right.clear();
    }

    @Override
    public String toString() { // O(n)
        // I know I could loop through, but this seemed like less work
        // the internet said str.replace(x, x) was O(n) so I'm trusting that
        return String.format("<%s><%s>",
                left.toString().replace("[", "").replace("]", ""),
                right.toString().replace("[", "").replace("]", ""));
    }
}
