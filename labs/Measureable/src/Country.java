/*
 * Liam Geyer
 * IST242 - Measurable Madness
 * lfg5289@psu.edu
 */

public class Country implements IMeasurable {
    private String name;
    private int pop;

    public Country(String name, int pop){
        this.name = name;
        this.pop = pop;
    }

    public Country(){
        this("n/a", -1);
    }

    public String getName() {
        return name;
    }

    public int getPop() {
        return pop;
    }

    /**
     * @return the measure of an object
     */
    @Override
    public int getMeasure() {
        return pop;
    }

    /**
     * Updates a measurable object's measure
     *
     * @param updatedMeasure the object's new measure
     * @return the updated object
     */
    @Override
    public IMeasurable updateMeasure(int updatedMeasure) {
        return new Country(name, updatedMeasure);
    }

    /**
     * Returns a string representation of the object.
     * @return country: (name), (population)
     */
    @Override
    public String toString() {
        return String.format("country: %s, %d", name, pop);
    }
}
