package ist.psu.edu.model;

public interface IDialLock {
    /**
     * Resets the lock dial back to 0
     */
    public abstract void reset();

    /**
     * Turns the lock left by the specified number of ticks t
     * @param t number of ticks to turn the lock by
     */
    public abstract void left(int t);

    /**
     * Turns the lock right by the specified number of ticks t
     * @param t number of ticks to turn the lock by
     */
    public abstract void right(int t);

    /**
     * @return the tick number the dial is pointing to
     */
    public abstract int currentTick();

    /**
     * attempts to pull open the lock
     * @return {@code true} if successfull
     */
    public abstract boolean pull();
}
