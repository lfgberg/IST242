/*
 * Liam Geyer
 * IST242 - Modeling Cars with inheritance
 * lfg5289@psu.edu
 */

public class Truck extends Vehicle {
    private boolean isDually;

    public Truck(Manufacturer manufacturer, AutoModel model, double mpg, boolean isDually){
        super(manufacturer, model, mpg);
        this.isDually = isDually;
    }

    public Truck(Manufacturer manufacturer, AutoModel model, double mpg){
        this(manufacturer, model, mpg, false);
    }

    /**
     * Returns {@code true} if the truck is dually
     */
    public boolean isDually(){
        return isDually;
    }

    /**
     * @return Vehicles number of wheels
     */
    @Override
    public int numberOfWheels() {
        if (isDually){
            return 6;
        }
        return 4;
    }

    /**
     * @return (manufacturer) (model), mpg: (mpg), is-dually = (whether truck is dually)
     */
    @Override
    public String toString() {
        return super.toString() + String.format(", is-dually = %b", isDually);
    }
}
