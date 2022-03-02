/**
 * Liam Geyer
 * IST242 - GarageGUI
 * lfg5289@psu.edu
 */

package edu.psu.ist.model;

public class Sedan extends Vehicle {
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
