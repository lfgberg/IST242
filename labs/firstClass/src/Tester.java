/*
 * Liam Geyer
 * IST242 - Writing a first class
 * lfg5289@psu.edu
 */

public class Tester {
    public static void main(String[] args) {
        //  make a Dog
        Breed gsd = new Breed("German Shepherd", true);
        Dog myPup = new Dog("Alec Berg", gsd, "2010-02-02");

        //  make a departed dog
        Breed corgi = new Breed("Corgi", true);
        Dog departedCorgi = new Dog("Joe", corgi, "1995-03-22", "2005-04-30");

        //  tests
        System.out.println(myPup.isAlive());
        System.out.println(departedCorgi.isAlive());
        System.out.println();
        System.out.println(myPup.toString());
        System.out.println(departedCorgi.toString());
    }
}
