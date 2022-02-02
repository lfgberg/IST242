/*
 * Liam Geyer
 * IST242 - Hierarchical classes and inheritance
 * lfg5289@psu.edu
 */

public class Cat extends Animal {
    private String breed;

    public Cat(String name, int age, boolean isAlive, String breed){
        super(name, age, isAlive);
        this.breed = breed;
    }

    /**
     * Returns the cat's breed
     */
    public String getBreed(){
        return breed;
    }

    @Override
    public String makeSound(){
        return "meow";
    }

    @Override
    public String toString(){
        // <name>, <breed> <age> years old, alive = <t/f>
        return String.format("%s, %s %d years old, alive = %b", super.getName(), getBreed(), super.getAge(), super.isAlive());
    }
}
