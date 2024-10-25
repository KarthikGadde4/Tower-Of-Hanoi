// Virginia Tech Honor Code Pledge:
// Project 3 Fall 2024
// As a Hokie, I will conduct myself with honor and integrity at all times.
// I will not lie, cheat, or steal, nor will I accept the actions of those who
// do.
// -- Karthik Yella (karthikyella)

package towerofhanoi;

import java.util.Observable;

// -------------------------------------------------------------------------
/**
 * This class includes the methods necessary to solve the Tower of Hanoi
 * problem. It contains all the actions required to perform the game's solution
 * and extends the Observable class.
 * 
 * @author karth
 * @version Oct 22, 2024
 */
@SuppressWarnings("deprecation")
public class HanoiSolver
    extends Observable
{

    private Tower left;
    private Tower center;
    private Tower right;
    private int numDisks;

    // ----------------------------------------------------------
    /**
     * Create a new HanoiSolver object.
     * 
     * @param numDisks
     *            is the amount of disks in the game
     */
    public HanoiSolver(int numDisks)
    {

        left = new Tower(Position.LEFT);
        center = new Tower(Position.CENTER);
        right = new Tower(Position.RIGHT);
        this.numDisks = numDisks;

    }


    // ----------------------------------------------------------
    /**
     * Gives the amount of disks the game contains
     * 
     * @return numDisks which is the number of disks in the game
     */
    public int disks()
    {
        return numDisks;
    }


    // ----------------------------------------------------------
    /**
     * Gets the tower at the specified position
     * 
     * @param pos
     *            is the position of the tower
     * @return Position of tower
     */
    public Tower getTower(Position pos)
    {
        switch (pos)
        {
            case LEFT:
                return left;
            case RIGHT:
                return right;
            case CENTER:
                return center;

            default:
                return center;
        }

    }


    // ----------------------------------------------------------
    /**
     * Returns the string representation of the three towers
     * 
     * @return the left, middle, and right towers toString methods combined
     */
    public String toString()
    {
        return left.toString() + center.toString() + right.toString();
    }


    // ----------------------------------------------------------
    /**
     * Moves disk from one tower to another
     * 
     * @param source
     *            tower to be moved from
     * @param destination
     *            tower to be moved to
     */
    public void move(Tower source, Tower destination)
    {
        destination.push(source.pop());
        setChanged();
        notifyObservers(destination.position());
    }


    // ----------------------------------------------------------
    /**
     * Recursively solves the Tower of Hanoi problem by moving disks one at a
     * time to other towers
     * 
     * @param currentDisks
     *            current disk
     * @param startPole
     *            starting pole
     * @param tempPole
     *            temporary pole
     * @param endPole
     *            ending pole
     */
    public void solveTowers(
        int currentDisks,
        Tower startPole,
        Tower tempPole,
        Tower endPole)
    {
        if (currentDisks == 1)
        {
            move(startPole, endPole);
            return;
        }

        solveTowers(currentDisks - 1, startPole, endPole, tempPole);

        move(startPole, endPole);

        solveTowers(currentDisks - 1, tempPole, startPole, endPole);
    }


    // ----------------------------------------------------------
    /**
     * The first call to the recursive solveTowers method
     */
    public void solve()
    {
        solveTowers(numDisks, left, center, right);
    }

}
