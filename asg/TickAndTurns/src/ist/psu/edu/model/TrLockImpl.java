package ist.psu.edu.model;

import java.util.ArrayList;
import java.util.List;

import static ist.psu.edu.model.Turn.Direction.L;
import static ist.psu.edu.model.Turn.Direction.R;

/**
 * Tracks the number of turns left or right
 * this is compared to the lock combination to determine if it will open
 */
public class TrLockImpl implements IDialLock{

    private int maxTicks, s1, s2, s3, currentTick;
    private List<Turn> moves;

    //  Defensive check to ensure the combination is valid
    public TrLockImpl(int s1, int s2, int s3, int mTicks){
        if (s1 < 0 || s2 < 0 || s3 < 0 || mTicks < 0){
            throw new IllegalArgumentException("Secret digits cannot be negative");
        }

        this.s1 = s1;
        this.s2 = s2;
        this.s3 = s3;
        //  Our lock index starts at 0, makes this easier
        this.maxTicks = mTicks + 1;
        this.moves = new ArrayList<>();
        this.currentTick = 0;
    }

    @Override
    public void reset() {
        this.currentTick = 0;
        moves.clear();
    }

    @Override
    public void left(int t) {
        // someone turned left past 0 -- need to account for the negative
        if (currentTick - t < 0){
            currentTick = maxTicks + (currentTick - t);
        } else {
            currentTick = currentTick - t;
        }

        moves.add(new Turn(L, currentTick));
    }

    @Override
    public void right(int t) {
        currentTick = (currentTick + t) % maxTicks;
        moves.add(new Turn(R, currentTick));
    }

    @Override
    public int currentTick() {
        return currentTick;
    }

    @Override
    public boolean pull() {
        //  sort the moves list into 3 parts
        ArrayList<Turn> firstSequence = new ArrayList<>();
        ArrayList<Turn> secondSequence = new ArrayList<>();
        ArrayList<Turn> thirdSequence = new ArrayList<>();
        
        return false;
    }

    @Override
    public String toString(){
        return String.format("Secret Digits: (%d, %d, %d)",
                s1, s2, s3);
    }
}
