/*
 * Liam Geyer
 * ist242 - quiz2
 * lfg5289@psu.edu
 */

public class House extends Property {
    private double mortgage;

    public House(String address, String city, String state, PropertySize size,
                 double value, double mortgage){
        super(address, city, state, size, value);
        this.mortgage = mortgage;
    }

    public House(){
        this("", "", "", PropertySize.SMALL, 0, 0);
    }

    /**
     * @return the proprties mortgage
     */
    public double getMortgage(){
        return mortgage;
    }

    /**
     * @param mortgage the properties mortgage
     */
    public void setMortgage(double mortgage){
        this.mortgage = mortgage;
    }

    @Override
    public void playBall() {
        System.out.println("You are fine, you have a yard");
    }

    /**
     * @return house w/ (mortgage) of size: (size)
     */
    @Override
    public String toString(){
        return String.format("house w/ %.2f of size: %s", mortgage, super.getSize());
    }
}
