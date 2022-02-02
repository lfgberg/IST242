/*
* Liam Geyer
* IST242 - Writing a first class
* lfg5289@psu.edu
 */

public class Dog {
    private String name;
    private Breed breed;
    private String dob;
    private String dod;

    //  Dead dog
    public Dog(String name, Breed breed, String dob, String dod){
        this.name = name;
        this.breed = breed;
        this.dob = dob;
        this.dod = dod;
    }

    //  Alive dog
    public Dog(String name, Breed breed, String dob){
        this.name = name;
        this.breed = breed;
        this.dob = dob;
        this.dod = "";
    }

    /*
    Returns true if the dog is alive
    @return if the dog is alive
     */
    public boolean isAlive(){
        //  alive if no date of death is entered;
        if (dod.isEmpty()){
            return true;
        } else {
            return false;
        }
    }

    /*
    Returns a string representation of the dog
    @return <name>, <breed> pure = <isPureBreed>, <dob>
     */
    public String toString(){
        return String.format("%s, %s, %s", name, breed.toString(), dob.toString());
    }
}
