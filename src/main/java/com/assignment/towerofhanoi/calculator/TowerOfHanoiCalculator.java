package com.assignment.towerofhanoi.calculator;

import org.springframework.stereotype.Component;

/**
 * @author Sophia Klocheva
 * on 14/12/2020
 * <p>
 * TowerOfHanoiCalculator calculates and returns the set of moves
 * needed to move all disks from peg A to C.
 */
@Component
public class TowerOfHanoiCalculator
{
    private final char FROM = 'A';
    private final char MID = 'B';
    private final char TO = 'C';
    private final String MOVE_TEXT = "Move disc %d from %s to %s.%n";

    private StringBuffer setOfMoves;

    /**
     * Depending on the number of disks, the method
     * calculates the moves needed for the disks
     * to be moved from peg A to C.
     *
     * @param numberOfDisks
     * @return the set of moves
     */
    public String calculateTower(int numberOfDisks)
    {
        setOfMoves = new StringBuffer((int) (Math.pow(2, numberOfDisks) - 1));
        calculateRecursive(numberOfDisks, FROM, MID, TO);

        return setOfMoves.toString();
    }

    /**
     * Recursive method for the calculation.
     *
     * @param numberOfDisks
     * @param from
     * @param mid
     * @param to
     */
    private void calculateRecursive(int numberOfDisks, char from, char mid, char to)
    {
        if (numberOfDisks == 1)
        {
            setOfMoves.append(String.format(MOVE_TEXT, 1, from, to));
            return;
        }
        else
        {
            calculateRecursive(numberOfDisks - 1, from, to, mid);
            setOfMoves.append(String.format(MOVE_TEXT, numberOfDisks, from, to));
            calculateRecursive(numberOfDisks - 1, mid, from, to);
        }
    }
}
