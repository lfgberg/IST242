/*
* Liam Geyer
* IST242 - edu.psu.ist.Pet Tricks
* lfg5289@psu.edu
 */

package edu.psu.ist;

import java.util.Locale;

public abstract class Pet {
    enum Command {SIT, FETCH, JUMP_THROUGH_FIRE_HOOLAHOOP}
    enum Response {
        SITS,
        FETCHES,
        DOES_NOTHING,
        JUMPS_THROUGH_FIREY_HOOP
    }

    private String name;
    private int age;

    public Pet(String name, int age) throws IllegalArgumentException{
        if (age <= 0){
            throw new IllegalArgumentException("age must be positive (and nonzero)");
        }

        this.name = name;
        this.age = age;
    }

    /**
     * Returns the name of the pet
     */
    public String getName(){
        return name;
    }

    /**
     * Returns the age of the pet
     */
    public int getAge(){
        return age;
    }

    /**
     * Sets the age of the pet
     * @param age
     */
    public void setAge(int age){
        this.age = age;
    }

    /**
     * Sets the name of the pet
     * @param name
     */
    public void setName(String name){
        this.name = name;
    }

    @Override
    /**
     * Returns a string representation of the Pet
     */
    public String toString(){
        // pet <classname>: <name>, age: <age>
        return String.format("pet %s: %s, age: %d", getClass().getSimpleName().toLowerCase(), name, age);
    }

    public abstract Response doTrick(Command command);
}
