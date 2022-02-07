/*
* Liam Geyer
* IST242 - Modeling Cars with inheritance
* lfg5289@psu.edu
 */

public class Manufacturer {
    private String name;
    private String country;

    public Manufacturer(String name, String country){
        this.name = name;
        this.country = country;
    }

    /**
     * Sets the Manufacturer's name
     * @param name name
     */
    public void setName(String name){
        this.name = name;
    }

    /**
     * Sets the Manufacturer's country
     * @param country country
     */
    public void setCountry(String country){
        this.country = country;
    }

    /**
     * @return the Manufacturer's country
     */
    public String getCountry(){
        return country;
    }

    /**
     * @return the Manufacturer's name
     */
    public String getName(){
        return name;
    }

    /**
     * @return (name), (country)
     */
    @Override
    public String toString(){
        return String.format("%s, %s", name, country);
    }
}
