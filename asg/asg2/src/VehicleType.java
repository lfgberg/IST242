/*
 * Liam Geyer
 * IST242 - asg2
 * lfg5289@psu.edu
 */

public class VehicleType {
    public enum Kind {
        TRUCK, CAR, COUPE, STATION_WAGON, VAN, SEDAN
    };

    private int numWheels;
    private Kind type;

    public VehicleType(Kind type, int numWheels) throws IllegalArgumentException{
        if (numWheels > 6 || numWheels < 2){
            throw new IllegalArgumentException("invalid number of wheels!");
        }

        this.type = type;
        this.numWheels = numWheels;
    }

    /*
    Returns the Vehicle's number of wheels
    @return number of wheels
     */
    public int getNumWheels(){
        return numWheels;
    }

    /*
    Returns the Vehicle's type
    @return vehicle type
     */
    public Kind getType(){
        return type;
    }

    /*
    Returns a string representation of the object
    @return <kind>, wheels: <number-of-wheels>
     */
    public String toString(){
        return (type + ", wheels: " + numWheels);
    }
}
