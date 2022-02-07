/*
 * Liam Geyer
 * IST242 - Modeling Cars with inheritance
 * lfg5289@psu.edu
 */

public class Sedan extends Vehicle{
    public Sedan(Manufacturer manufacturer, AutoModel model, double mpg){
        super(manufacturer, model, mpg);
    }

    /**
     * @return Vehicles number of wheels
     */
    @Override
    public int numberOfWheels(){
        return 4;
    }
}
