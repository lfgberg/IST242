/**
 * Liam Geyer
 * IST242 - GarageGUI
 * lfg5289@psu.edu
 */

package edu.psu.ist.model;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Garage {
    private List<Vehicle> vehicles;

    public Garage(List<Vehicle> vehicles){
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
     * Removes all vehicles from the garage
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
