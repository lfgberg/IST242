/*
* Liam Geyer
* IST242 - Modeling a Cat with classes
* lfg5289@psu.edu
 */

package edu.psu.ist;

public class Cat {
    private String name;
    private int yearBorn;
    private String breed;
    private boolean isPureBreed;

    public Cat(){
        this.name = "";
        this.yearBorn = 0;
        this.breed = "";
        this.isPureBreed = false;
    }

    public Cat(String name, int yearBorn, String breed, boolean isPureBreed){
        this.name = name;
        this.yearBorn = yearBorn;
        this.breed = breed;
        this.isPureBreed = isPureBreed;
    }

    /*
    Returns the name of the cat
    @return the name of the cat
     */
    public String getName(){
        return name;
    }

    /*
    Returns the cat's year of birth
    @return the cat's year of birth
     */
    public int getYearBorn(){
        return yearBorn;
    }

    /*
    Returns the breed of the cat
    @return the breed of the cat
     */
    public String getBreed(){
        return breed;
    }

    /*
    Returns true if the cat is pure breed
    @return true if the cat is pure breed
     */
    public boolean isPureBreed(){
        return isPureBreed;
    }

    /*
    Sets the cat's name
    @param n the cat's name
     */
    public void setName(String n){
        this.name = n;
    }

    /*
    Sets the cat's year of birth
    @param n the cat's birth year
     */
    public void setYearBorn(int x){
        this.yearBorn = x;
    }

    /*
    Sets the cat's breed
    @param n the cat's breed
     */
    public void setBreed(String n){
        this.breed = n;
    }

    /*
    Sets the cat's pure breed status
    @param isPureBreed whether the cat is pure breed
     */
    public void setPureBreed(boolean isPureBreed){
        this.isPureBreed = isPureBreed;
    }

    /*
    Returns a string representation of the cat
    @return <name> <yearBorn>, <breed> pure = <isPureBreed>
     */
    public String toString(){
        return (name + ", " + yearBorn + ", " + breed + ", pure = " + isPureBreed);
    }

    /*
    Determines whether a breed is valid
    @param breed the breed to validate
    @return true if the breed is valid
     */
    public static boolean isValidBreed(String breed){
        if (breed.equals("Tabby")){
            return true;
        }

        return false;
    }
}
