/*
* Liam Geyer
* IST242 - Quiz 3
* lfg5289@psu.edu
 */

package edu.psu.ist;

import java.util.*;
import java.util.function.Function;

public class GenericQuadruple<T> {
        private T t1, t2, t3, t4;

        public GenericQuadruple(T t1, T t2, T t3, T t4){
            this.t1 = t1;
            this.t2 = t2;
            this.t3 = t3;
            this.t4 = t4;
        }

    @Override
    public String toString() {
        return String.format("(<%s>, <%s>, <%s>, <%s>)",
                t1.toString(), t2.toString(), t3.toString(), t4.toString());
    }

    /**
     * Helper method so I can use a foreach loop
     */
    private List<T> listFormat(){
            return List.of(t1, t2, t3, t4);
    }

    /**
     * Returns a map containing the number of times each entry appears in the quadruple
     */
    public Map<T, Integer> produceHistogram(){
        Map<T, Integer> result = new HashMap<>();

        //  iterate through the quad; creating a map
        for (T x : listFormat()){
            result.put(x, result.getOrDefault(x, 0) + 1);
        }

        return result;
    }

    /**
     * Returns a new GenericQuadruple instance with all components reversed
     */
    public GenericQuadruple<T> withComponentsReversed(){
        return new GenericQuadruple<T>(t4, t3, t2, t1);
    }

    /**
     * Creates a list of all components in the quadruple that satisfy a function
     * @param pred function to test
     * @return list of results
     */
    public List<T> collectAllThatSatisfy(Function<T, Boolean> pred){
        List<T> result = new ArrayList<>();

        //  apply pred to each element in the quadruple, add to results if true
        for (T x : listFormat()){
            if (pred.apply(x)){
                result.add(x);
            }
        }

        return result;
    }

    /**
     * Applies a function to each element in the quad
     * @param updateFn function to apply
     */
    public void update(Function<T, T> updateFn){
        this.t1 = updateFn.apply(t1);
        this.t2 = updateFn.apply(t2);
        this.t3 = updateFn.apply(t3);
        this.t4 = updateFn.apply(t4);

    }
}
