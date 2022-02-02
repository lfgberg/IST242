/*
 * Liam Geyer
 * IST242 - Hierarchical classes and inheritance
 * lfg5289@psu.edu
 */

public class Dog extends Animal {
    enum DogSize{
        SMALL, MEDIUM, LARGE
    }
    private DogSize size;

    public Dog(String name, int age, boolean isAlive, DogSize size){
        super(name, age, isAlive);
        this.size = size;
    }

    public String playFetch(){
        return "*runs at ball*";
    }

    @Override
    public String makeSound(){
        return "Bark";
    }

    @Override
    public String toString(){
        return super.toString() + ", size = " + size;
    }
}
