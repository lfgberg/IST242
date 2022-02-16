/*
 * Liam Geyer
 * IST242 - Measurable Madness
 * lfg5289@psu.edu
 */

@FunctionalInterface
public interface IMeasurablePredicate {
    /**
     * Returns {@code true} <b>if and only if</b> {@code x} satisfies this
     * predicate; {@code false} otherwise.
     *
     * @param x the measurable object being tested.
     * @return whether or not {@code x} satisfies this predicate.
     */
    boolean test(IMeasurable x);
}
