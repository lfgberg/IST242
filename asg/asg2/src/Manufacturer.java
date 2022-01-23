/*
* Liam Geyer
* IST242 - asg2
* lfg5289@psu.edu
 */

public class Manufacturer {
    private String name;
    private String country;

    public Manufacturer(){
        this.name = "";
        this.country = "";
    }

    public Manufacturer(String name, String country){
        this.name = name;
        this.country = country;
    }

    /*
    Sets the Manufacturer's name
    @param name the name of the Manufacturer
     */
    public void setName(String name){
        this.name = name;
    }

    /*
    Sets the Manufacturer's country
    @param country the country of the Manufacturer
     */
    public void setCountry(String country){
        this.country = country;
    }

    /*
    Returns the Manufacturer's name
    @return the name of the Manufacturer
     */
    public String getName(){
        return name;
    }

    /*
    Returns the Manufacturer's country
    @return the country of the Manufacturer
     */
    public String getCountry(){
        return country;
    }

    /*
    Returns a string representation of the object
    @return <name>, <country>
     */
    public String toString(){
        return (name + ", " + country);
    }
}
