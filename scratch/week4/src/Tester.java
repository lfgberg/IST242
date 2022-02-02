/*
 * Liam Geyer
 * IST242 - Hierarchical classes and inheritance
 * lfg5289@psu.edu
 */

import java.util.ArrayList;

public class Tester {
    public static void main(String[] args) {
        Animal a = new Cat("Snowball", 14, true, "Calico");
        Animal d = new Dog("Rufus", 4, true, Dog.DogSize.MEDIUM);

        ArrayList<Animal> animals = new ArrayList<>();
        animals.add(a);
        animals.add(d);
        animals.add(new Cat("Bob", 8, false, "Domestic Shorthair"));

        for (Animal animal : animals){
            System.out.println(animal.toString());
        }

        if (d instanceof Dog){
            System.out.println(((Dog) d).playFetch());
        }
    }
}
