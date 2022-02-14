import java.util.ArrayList;
import java.util.List;
import java.util.function.BiFunction;
import java.util.function.Function;

public class Tester {
    public static void main(String[] args) {
        //  read only list
        final List<Integer> lst = List.of(6, 5, 4);

        //  Function
        Function<Integer, Integer> f = (Integer y) -> y + 5;
        int c = 4;
        int d = f.apply(c);
        System.out.printf("%d -> %d\n", c, d);

        //  bifunction
        BiFunction<Integer, Integer, Integer> f2 = (Integer y, Integer x) -> y + x;

        //  anonymous class
        INumberPredicate anonVersion = new INumberPredicate() {
            @Override
            public boolean test(int num) {
                return false;
            }
        };

        //  implementation with a lambda statement
        INumberPredicate lambdaVersion = (int i) -> i == 5;

        System.out.println(allNumsSatisfy(lst, lambdaVersion));
        System.out.println(allNumsSatisfy(List.of(5, 5, 5), lambdaVersion));

        //  using our higher order function; both add 5
        System.out.println(map(List.of(5, 4, 3), (Integer m) -> m + 5));
        System.out.println(addFive(List.of(5, 4, 3)));
    }

    /**
     * Returns {@code true} if all nums satisfy the predicate
     */
    public static boolean allNumsSatisfy(List<Integer> nums, INumberPredicate pred){
        for (Integer i : nums){
            if (!pred.test(i)){
                return false;
            }
        }

        //  only reaches this point if all numbers pass
        return true;
    }

    /**
     * Reverses the sign of whatever is passed
     * @param nums List of nums
     * @return negated list of all nums
     */
    public static List<Integer> invert(List<Integer> nums){
        List<Integer> invertedNums = new ArrayList<>();
        for (Integer i : nums){
            invertedNums.add(-i);
        }
        return invertedNums;
    }

    /**
     * Returns a list where all entries have been increased by 5
     * @param nums original list of integers
     * @return new list of integers
     */
    public static List<Integer> addFive(List<Integer> nums){
        List<Integer> result = new ArrayList<>();
        for (Integer i : nums){
            result.add(i + 5);
        }
        return result;
    }

    /**
     * Mutates a list of integers
     * @param nums list of integers
     * @param f a function to mutate the list
     * @return mutated list
     */
    public static List<Integer> map(List<Integer> nums, Function<Integer, Integer> f){
        List<Integer> result = new ArrayList<>();
        for (Integer i : nums){
            result.add(f.apply(i));
        }
        return result;
    }
}
