/*
 * Liam Geyer
 * IST242 - Measurable Madness
 * lfg5289@psu.edu
 */

import java.util.ArrayList;
import java.util.List;
import java.util.function.Function;

public class Tester {
    /**
     * Filters the given {@code measurables} list given and returns a new list
     * consisting of only elements that satisfy the provided predicate
     * {@code pred}.
     *
     * @param measurables a list of measurable objects.
     * @param pred        the predicate that tests/checks each measurable.
     * @return a list of measurables containing only those that satisfy {@code pred}.
     */
    public static List<IMeasurable> filterMeasurables(List<IMeasurable> measurables,
                                                      IMeasurablePredicate pred){
        List<IMeasurable> result = new ArrayList<>();

        //  if x satisfies the predicate, add to the result array
        for (IMeasurable x : measurables){
            if (pred.test(x)){
                result.add(x);
            }
        }

        return result;
    }

    /**
     * Negates each entry in a least of IMeasurables
     * @param measurables list of IMeasurables
     * @return negated list
     */
    public static List<IMeasurable> negate(List<IMeasurable> measurables){
        List<IMeasurable> result = new ArrayList<>();

        //  negate the value of each entry, add to the result
        for (IMeasurable x : measurables){
            result.add(x.updateMeasure(x.getMeasure() * -1));
        }

        return result;
    }

    /**
     * Makes the value of each entry in a list of IMeasurables 50
     * @param measurables List of IMeasurables
     * @return new list of IMeasurables
     */
    public static List<IMeasurable> make50(List<IMeasurable> measurables){
        List<IMeasurable> result = new ArrayList<>();

        //  make the value of each measure 50
        for (IMeasurable x : measurables){
            result.add(x.updateMeasure(50));
        }

        return result;
    }

    /**
     * Generalized method to apply a rule to a list of IMeasurables
     * @param measurables List of IMeasurables to act on
     * @param fxn function taking in IMeasurables, and returning a changed IMeasurable
     * @return new acted upon list of IMeasurables
     */
    public static List<IMeasurable> mapMeasurables(List<IMeasurable> measurables,
                                                   Function<IMeasurable, IMeasurable> fxn){
        List<IMeasurable> result = new ArrayList<>();

        //  apply the passed function to each entry and add it to the results
        for (IMeasurable x : measurables){
            result.add(fxn.apply(x));
        }

        return result;
    }

    public static void main(String[] args) {
        List<IMeasurable> myMeasurables = List.of(
                new BankAccount("Bob", 3000),
                new BankAccount("Viggo Mortenson", 3000000),
                new Country("San Marino", 33685),
                new Country("US", 334125343),
                new BankAccount("Alice", 20000),
                new BankAccount("Moo", 4),
                new BankAccount("Chedder-the-mouse", 40),
                new Country("Pitcairn Islands", 40),
                new Country("Belarus", 9349645),
                new Country("Austria", 8976467),
                new BankAccount("Josh", 200),
                new BankAccount("Fred", 2500),
                new BankAccount("Jimmy 'Brick top' Pulford", 2000000),
                new BankAccount("Mark", 1000),
                new Country("Vatican City", 825)
        );

        //  1)
        IMeasurablePredicate p = (IMeasurable x) -> x.getMeasure() < 50000 && x instanceof Country;
        System.out.println(filterMeasurables(myMeasurables, p));

        //  2)
        System.out.println(negate(myMeasurables));

        //  3)
        System.out.println(make50(myMeasurables));

        //  4)
        Function<IMeasurable, IMeasurable> p2 = (IMeasurable x) -> x.updateMeasure(x.getMeasure() * -1);
        Function<IMeasurable, IMeasurable> p3 = (IMeasurable x) -> x.updateMeasure(50);
        System.out.println(mapMeasurables(myMeasurables, p2));
        System.out.println(mapMeasurables(myMeasurables, p3));
    }
}
