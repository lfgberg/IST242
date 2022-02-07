/*
 * Liam Geyer
 * IST242 - Modeling Cars with inheritance
 * lfg5289@psu.edu
 */

import java.time.Year;
import java.util.ArrayList;

public class AutoModel {
    private String name;
    private boolean inProduction;
    private ArrayList<Year> productionYears;

    public AutoModel(String name, boolean inProduction, ArrayList<Year> productionYears) throws IllegalArgumentException {
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
    public ArrayList<Year> getProductionYears(){
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
