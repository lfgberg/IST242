/*
 * Liam Geyer
 * IST242 - Modeling Cars with inheritance
 * lfg5289@psu.edu
 */

import java.util.ArrayList;
import java.util.Collections;

public class Garage {
    private ArrayList<Vehicle> vehicles;

    public Garage(ArrayList<Vehicle> vehicles){
        this.vehicles = vehicles;
    }

    public Garage(){
        this.vehicles = new ArrayList<>();
    }

    /**
     * Adds a vehicle to the garage
     * @param vehicle vehicle to add to the garage
     */
    public void addVehicle(Vehicle vehicle){
        vehicles.add(vehicle);
    }

    /**
     * Removes all vehciles from the garage
     */
    public void emptyGarage(){
        vehicles.clear();
    }

    /**
     * Sorts all vehicles in the garage according to release year
     */
    public void sortByReleaseYear(){
        Collections.sort(vehicles);
    }

    /**
     * @return (vehicle) \n
     */
    @Override
    public String toString(){
        StringBuilder temp = new StringBuilder();

        for (Vehicle x : vehicles){
            temp.append(x.toString()).append("\n");
        }

        return temp.toString();
    }
}
