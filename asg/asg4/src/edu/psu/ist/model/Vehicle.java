/*
 * Liam Geyer
 * IST242 - Modeling Cars with inheritance
 * lfg5289@psu.edu
 */

package edu.psu.ist.model;

import java.time.Year;

public abstract class Vehicle implements Comparable<Vehicle> {
    private Manufacturer manufacturer;
    private AutoModel model;
    private double mpg;

    public Vehicle(Manufacturer manufacturer, AutoModel model, double mpg){
        this.manufacturer = manufacturer;
        this.model = model;
        this.mpg = mpg;
    }

    /**
     * @return Vehicles number of wheels
     */
    public abstract int numberOfWheels();

    /**
     * @return the vehicle's manufacturer
     */
    public Manufacturer getManufacturer(){
        return manufacturer;
    }

    /**
     * @return the vehicle's mpg
     */
    public double getMPG(){
        return mpg;
    }

    /**
     * @return the vehicle's model
     */
    public AutoModel getModel(){
        return model;
    }

    /**
     * @return the vehicle's release year
     */
    public Year getReleaseYear(){
        return model.getProductionYears().get(0);
    }

    /**
     * @return how many miles the car can drive with a given
     * amount of gas
     */
    public double howFarWith(double gallons){
        return mpg * gallons;
    }

    /**
     * @return (manufacturer) (model), mpg: (mpg)
     */
    @Override
    public String toString(){
        return String.format("(%s) %s, mpg: %.2f", manufacturer.toString(), model.toString(), mpg);
    }

    /**
     * Compares this object with the specified object for order.  Returns a
     * negative integer, zero, or a positive integer as this object is less
     * than, equal to, or greater than the specified object.
     *
     * <p>The implementor must ensure {@link Integer#signum
     * signum}{@code (x.compareTo(y)) == -signum(y.compareTo(x))} for
     * all {@code x} and {@code y}.  (This implies that {@code
     * x.compareTo(y)} must throw an exception if and only if {@code
     * y.compareTo(x)} throws an exception.)
     *
     * <p>The implementor must also ensure that the relation is transitive:
     * {@code (x.compareTo(y) > 0 && y.compareTo(z) > 0)} implies
     * {@code x.compareTo(z) > 0}.
     *
     * <p>Finally, the implementor must ensure that {@code
     * x.compareTo(y)==0} implies that {@code signum(x.compareTo(z))
     * == signum(y.compareTo(z))}, for all {@code z}.
     *
     * @param o the object to be compared.
     * @return a negative integer, zero, or a positive integer as this object
     * is less than, equal to, or greater than the specified object.
     * @throws NullPointerException if the specified object is null
     * @throws ClassCastException   if the specified object's type prevents it
     *                              from being compared to this object.
     * @apiNote It is strongly recommended, but <i>not</i> strictly required that
     * {@code (x.compareTo(y)==0) == (x.equals(y))}.  Generally speaking, any
     * class that implements the {@code Comparable} interface and violates
     * this condition should clearly indicate this fact.  The recommended
     * language is "Note: this class has a natural ordering that is
     * inconsistent with equals."
     */
    @Override
    public int compareTo(Vehicle o) {
        Year releaseYear = model.getProductionYears().get(0);
        Year otherReleaseYear = o.getModel().getProductionYears().get(0);

        if (releaseYear.equals(otherReleaseYear)){
            return 0;
        } else if (releaseYear.isAfter(otherReleaseYear)){
            return 1;
        } else {
            return -1;
        }
    }
}
