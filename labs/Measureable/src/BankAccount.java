/*
 * Liam Geyer
 * IST242 - Measurable Madness
 * lfg5289@psu.edu
 */

public class BankAccount implements IMeasurable {
    private String accountHolder;
    private int bal;

    public BankAccount(String accountHolder, int bal){
        this.accountHolder = accountHolder;
        this.bal = bal;
    }

    public BankAccount(){
        this("n/a", -1);
    }

    /**
     * @return the measure of an object
     */
    @Override
    public int getMeasure() {
        return bal;
    }

    /**
     * Updates a measurable object's measure
     *
     * @param updatedMeasure the object's new measure
     * @return the updated object
     */
    @Override
    public IMeasurable updateMeasure(int updatedMeasure) {
        return new BankAccount(accountHolder, updatedMeasure);
    }

    /**
     * Returns a String representation of the object
     * @return bank account for: (name) $(balance)
     */
    @Override
    public String toString() {
        return String.format("bank account for: %s %d", accountHolder, bal);
    }
}
