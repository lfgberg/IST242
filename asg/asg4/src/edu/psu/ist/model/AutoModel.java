/**
 * Liam Geyer
 * IST242 - GarageGUI
 * lfg5289@psu.edu
 */

package edu.psu.ist.model;

import java.time.Year;
import java.util.List;

public class AutoModel {
    private String name;
    private boolean inProduction;
    private List<Year> productionYears;

    public AutoModel(String name, boolean inProduction, List<Year> productionYears) throws IllegalArgumentException {
        if (productionYears.isEmpty()){
            throw new IllegalArgumentException("productionYears must not be empty");
        }

        this.name = name;
        this.inProduction = inProduction;
        this.productionYears = productionYears;
    }

    /**
     * @return the model's name
     */
    public String getName(){
        return name;
    }

    /**
     * Returns {@code true} if the model is currently produced
     */
    public boolean isInProduction(){
        return inProduction;
    }

    /**
     * @return ArrayList of production years
     */
    public List<Year> getProductionYears(){
        return productionYears;
    }

    /**
     * @return (name), in production = (true/false), (first year in production)
     */
    @Override
    public String toString(){
        return String.format("%s, in production = %b, %s", name, inProduction, String.valueOf(productionYears.get(0)));
    }
}
