/*
 * Liam Geyer
 * IST242 - asg2
 * lfg5289@psu.edu
 */

import java.time.Year;
import java.util.ArrayList;

public class Model {
    private String name;
    private ArrayList<Year> productionYears;
    private ArrayList<String> trimsAvail;
    private boolean inProduction;

    public Model(String name, boolean inProduction, ArrayList<Year> productionYears) throws IllegalArgumentException{
        if (productionYears.isEmpty()){
            throw new IllegalArgumentException("a car model must have at least one production year");
        }

        this.name = name;
        this.productionYears = productionYears;
        this.trimsAvail = new ArrayList<>();
        this.inProduction = inProduction;
    }

    /*
    Adds a trim to the model's list of available trims
    @param trim trim to add
     */
    public void addTrim(String trim){
        trimsAvail.add(trim);
    }

    /*
    Returns the Model's name
    @return the Model's name
     */
    public String getName(){
        return name;
    }

    /*
    Returns the Model's production years
    @return the Model's name
     */
    public ArrayList<Year> getProductionYears(){
        return productionYears;
    }

    /*
    Returns the Model's available trims
    @return the Model's available trims
     */
    public ArrayList<String> getTrim(){
        return trimsAvail;
    }

    /*
    Returns the Model's production status
    @return whether or not the model is currently produced
     */
    public boolean getProductionStatus(){
        return inProduction;
    }

    /*
    Returns a String representation of the object
    @return <model-name>, in production = <whether-in-production>, <first-year-in-production>
     */
    public String toString(){
        return (name + ", in production = " + inProduction + ", " + productionYears.get(0));
    }
}
