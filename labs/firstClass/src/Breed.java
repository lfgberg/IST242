/*
 * Liam Geyer
 * IST242 - Writing a first class
 * lfg5289@psu.edu
 */

public class Breed {
    private String name;
    private boolean isPureBreed;

    public Breed(String name, boolean isPureBreed){
        this.name = name;
        this.isPureBreed = isPureBreed;
    }

    /*
    Return a string representation of the breed
    @return <name>, pure = <isPureBreed>
     */
    public String toString(){
        return String.format("%s, pure = %b", name, isPureBreed);
    }
}
