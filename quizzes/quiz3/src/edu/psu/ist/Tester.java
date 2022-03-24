/*
 * Liam Geyer
 * IST242 - Quiz 3
 * lfg5289@psu.edu
 */

package edu.psu.ist;

public class Tester {
    public static void main(String[] args) {
        System.out.println("------------- Tests 1:");

        // initialize a quadruple w/ some random elements
        GenericQuadruple<Integer> myQuad = new GenericQuadruple<>(4, 3, 0, 5);

        System.out.println(myQuad); // should print: (4, 3, 0, 5)

        myQuad.update(x -> x + 5);
        System.out.println("transformed 1: " + myQuad); // should print: (9, 8, 5, 10)

        myQuad.update(x -> {
            if (x < 9){
                x = 0;
            }
            return x;
        });
        System.out.println("transformed 2: " + myQuad); // should print: (9, 0, 0, 10)


        System.out.println("histogram 1: " + myQuad.produceHistogram());
        // should print (in some order): {9=1, 0=2, 10=1}

        System.out.println(myQuad.collectAllThatSatisfy(x -> {
            if (x > 0){
                return true;
            } else {
                return false;
            }
        }));  // should print [9, 10]

        System.out.println("with components reversed: " + myQuad.withComponentsReversed()); // should print: (10, 0, 0, 9)

        System.out.println("\n------------- Tests 2:");

        GenericQuadruple<String> strQuad =
                new GenericQuadruple<>("seabird", "eddie", "racecar", "dog");

        strQuad.update(s -> String.format("!%s!", s));
        System.out.println("updated: " + strQuad); // should print (!seabird!, !eddie!, !racecar!, !dog!)
        
        strQuad.update(s -> {
            StringBuilder x = new StringBuilder(s);
            return String.valueOf(x.reverse());
        });
        System.out.println("updated: " + strQuad); // should print (!dribaes!, !eidde!, !racecar!, !god!)
    }
}
