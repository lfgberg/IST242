/*
 * Liam Geyer
 * ist242 - quiz2
 * lfg5289@psu.edu
 */

public class Condo extends Property {
    private double mortgage;

    public Condo(String address, String city, String state, PropertySize size,
                 double value, double mortgage){
        super(address, city, state, size, value);
        this.mortgage = mortgage;
    }

    public Condo(){
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
        System.out.println("You broke something.");
    }

    /**
     * @return condo w/ (mortgage) of size: (size) and no backyard :(
     */
    @Override
    public String toString(){
        return String.format("condo w/ %.2f of size: %s and no backyard :-(", mortgage, super.getSize());
    }
}
