package edu.psu.ist;

/*
 * Liam Geyer
 * IST242 - Pet Tricks
 * lfg5289@psu.edu
 */

public class Goldfish extends Pet {
    public Goldfish(String name, int age){
        super(name, age);
    }

    /**
     * Fish jumps through a firey hoop
     * @param command JUMP_THROUGH_FIRE_HOOLAHOOP
     */
    @Override
    public Pet.Response doTrick(Pet.Command command){
        if (command.equals(Command.JUMP_THROUGH_FIRE_HOOLAHOOP)){
            return Response.JUMPS_THROUGH_FIREY_HOOP;
        }
        return Response.DOES_NOTHING;
    }
}
