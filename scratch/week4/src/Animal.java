/*
* Liam Geyer
* IST242 - Hierarchical classes and inheritance
* lfg5289@psu.edu
 */

/**
 * abstract base class for representing a general animal-like entity
 * <ul>
 *     <li>name</li>
 *     <li>age</li>
 *     <li>alive or dead</li>
 * </ul>
 */
public abstract class Animal {
    private String name;
    private int age;
    private boolean alive;

    public Animal(String name, int age, boolean isAlive){
        this.name = name;
        this.age = age;
        this.alive = isAlive;
    }

    public abstract String makeSound();

    /**
     * Returns {@code true} if this animal is alive
     */
    public boolean isAlive(){
        return alive;
    }

    /**
     * Returns the animal's name
     */
    public String getName(){
        return name;
    }

    /**
     * Returns the animal's age
     */
    public int getAge(){
        return age;
    }

    @Override
    public String toString() {
        // name, age years old, alive = t/f
        return String.format("%s, %d years old, alive = %b", name, age, alive);
    }
}
