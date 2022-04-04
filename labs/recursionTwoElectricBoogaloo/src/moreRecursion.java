/**
 * Liam Geyer
 * IST242 - more recursion problems
 * lfg5289@psu.edu
 */

public class moreRecursion {
    /**
     * <b>Question:</b>
     * <p>
     * Write a recursive method, {@code bsum}, that returns {@code true}
     * <strong>if and only if</strong>, starting from the provided index
     * {@code start}, if there is some subset of integers in {@code nums} that
     * sums to the provided {@code targetAmt}.
     * <p>
     * The method should return {@code false} if this is not possible. No loops
     * are needed.
     * <p><b>Some examples:</b>
     * <ul>
     * <li>bsum(1, [2, 4, 8], 8) returns true</li>
     * <li>bsum(1, [2, 4, 8], 2) returns false</li>
     * <li>bsum(0, [2, 4, 8], 8) returns true</li>
     * <li>bsum(1, [9], 0) returns true</li>
     * <li>bsum(1, [], 0) returns true</li>
     * <li>bsum(1, [], 1) returns false</li>
     * </ul>
     */
    public static boolean bsum(int start, int[] nums, int targetAmt) { //  <-- kickoff
        //  niche case for an empty array
        if (nums.length == 0){
            return targetAmt == 0;
        }

        return bsum(start, nums, targetAmt, start, 0);
    }

    //  helper method tracks current index, and current sum
    private static boolean bsum(int start, int[] nums, int targetAmt, int index, int sum){
        if (sum + nums[index] == targetAmt){
            return true;
        } else if ()
    }

    public static boolean bsum6(int start, int[] nums, int targetAmt){
        return false;
    }

    public static void main(String[] args) {
        //  testing bsum

        //  testing bsum6
    }
}
