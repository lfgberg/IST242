/*
 * Liam Geyer
 * IST242 - asg2
 * lfg5289@psu.edu
 */

import java.time.Year;

public class Vehicle {
    private Model model;
    private Manufacturer manufacturer;
    private VehicleType vehicleType;
    private double mileage;
    private double mpg;

    public Vehicle(Model model, Manufacturer manufacturer, VehicleType vehicleType, double mileage, double mpg) throws IllegalArgumentException{
        if (mileage < 0){
            throw new IllegalArgumentException("Mileage must be postitive.");
        }

        if (mpg < 0){
            throw new IllegalArgumentException("Mpg must be postitive.");
        }

        this.model = model;
        this.manufacturer = manufacturer;
        this.vehicleType = vehicleType;
        this.mileage = mileage;
        this.mpg = mpg;
    }

    /*
    Returns the Vehicle's model
    @return model
     */
    public Model getModel(){
        return model;
    }

    /*
    Returns the Vehicle's manufacturer
    @return manufacturer
     */
    public Manufacturer getManufacturer(){
        return manufacturer;
    }

    /*
    Returns the Vehicle's type
    @return vehicleType
     */
    public VehicleType getType(){
        return vehicleType;
    }

    /*
    Returns the Vehicle's odometer mileage
    @return mileage
     */
    public double getMileage(){
        return mileage;
    }

    /*
    Returns the Vehicle's MPG
    @return MPG
     */
    public double getMPG(){
        return mpg;
    }

    /*
    Returns a string representation of the object
    @return string representation of the car
     */
    public String toString(){
        String car = model.toString() + " (" + manufacturer.toString() + ")\n";
        car = car + ("\t" + vehicleType.toString() + "\n");
        car = car + ("\t" + "odometer: " + mileage + " - mpg: " + mpg);

        return car;
    }
}
