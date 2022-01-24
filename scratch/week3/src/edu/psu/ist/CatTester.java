/*
 * Liam Geyer
 * IST242 - Modeling a Cat with classes
 * lfg5289@psu.edu
 */

package edu.psu.ist;

public class CatTester {
    public static void main(String[] args) {
        //  create a new cat named crispy
        Cat c = new Cat("crispy", 2016, "Tabby", true);
        System.out.println(c.toString());
    }
}
