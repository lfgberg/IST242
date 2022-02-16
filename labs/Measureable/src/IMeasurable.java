/*
* Liam Geyer
* IST242 - Measurable Madness
* lfg5289@psu.edu
 */

public interface IMeasurable {
    /**
     * @return the measure of an object
     */
    public int getMeasure();

    /**
     * Updates a measurable object's measure
     * @param updatedMeasure the object's new measure
     * @return the updated object
     */
    public IMeasurable updateMeasure(int updatedMeasure);
}
