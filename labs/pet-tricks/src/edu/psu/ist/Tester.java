package edu.psu.ist;

/*
 * Liam Geyer
 * IST242 - edu.psu.ist.Pet Tricks
 * lfg5289@psu.edu
 */

import java.util.ArrayList;
import java.util.Random;

public class Tester {
    public static void main(String[] args) {
        ArrayList<Pet> pets = new ArrayList<>();

        //  Make all the pets
        pets.add(new Dog("roofus", 5));
        pets.add(new Goldfish("gloopy", 1));
        pets.add(new Dog("echo", 12, true));
        pets.add(new Dog("chip", 5));
        pets.add(new Dog("simba", 6, true));

        //  create a new random generator
        Random rand = new Random();

        for (Pet pet : pets){
            //  generate a random command
            int randNum = rand.nextInt(3);
            Pet.Command cmd = Pet.Command.values()[randNum];

            //  give some output
            System.out.println(pet.toString() + " " + pet.doTrick(cmd));
        }
    }
}
