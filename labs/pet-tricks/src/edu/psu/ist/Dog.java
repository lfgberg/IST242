package edu.psu.ist;

/*
 * Liam Geyer
 * IST242 - Pet Tricks
 * lfg5289@psu.edu
 */

public class Dog extends Pet{
    private boolean likesFetch;

    public Dog(String name, int age, boolean likesFetch){
        super(name, age);
        this.likesFetch = likesFetch;
    }

    // doesn't like fetch :(
    public Dog(String name, int age){
        super(name, age);
    }

    /**
     * returns {@code true} if the dog likes to play fetch
     */
    public boolean likesFetch(){
        return likesFetch;
    }

    /**
     * FETCH - If the dog likes to fetch, it will fetch
     * SIT - the dog will sit
     * @param command FETCH/SIT
     */
    @Override
    public Pet.Response doTrick(Pet.Command command){
        if (command.equals(Command.FETCH)){
            if (likesFetch){
                return Response.FETCHES;
            }
        } else if (command.equals(Command.SIT)){
            return Response.SITS;
        }
        return Response.DOES_NOTHING;
    }
}
