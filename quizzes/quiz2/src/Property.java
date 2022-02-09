/*
* Liam Geyer
* ist242 - quiz2
* lfg5289@psu.edu
 */

public abstract class Property {
    enum PropertySize {
            SMALL, MEDIUM, LARGE
    }

    private String address;
    private String city;
    private String state;
    private PropertySize size;
    private double value;

    public Property(String address, String city, String state,
                    PropertySize size, double value){
        this.address = address;
        this.city = city;
        this.state = state;
        this.size = size;
        this.value = value;
    }

    public Property(){
        this("", "", "", PropertySize.SMALL, 0);
    }

    /**
     * @return the property's address
     */
    public String getAddress(){
        return address;
    }

    /**
     * @return the property's city
     */
    public String getCity(){
        return city;
    }

    /**
     * @return the city's state
     */
    public String getState(){
        return state;
    }

    /**
     * @return the property's size
     */
    public PropertySize getSize(){
        return size;
    }

    /**
     * @return the property's value
     */
    public double getValue(){
        return value;
    }

    /**
     * @param address the property's address
     */
    public void setAddress(String address){
        this.address = address;
    }

    /**
     * @param city the property's city
     */
    public void setCity(String city){
        this.city = city;
    }

    /**
     * @param state the city's state
     */
    public void setState(String state){
        this.state = state;
    }

    /**
     * @param size the property's size
     */
    public void setSize(PropertySize size){
        this.size = size;
    }

    /**
     * @param value the property's value
     */
    public void setValue(double value){
        this.value = value;
    }

    public abstract void playBall();
}
