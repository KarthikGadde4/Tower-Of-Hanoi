// Virginia Tech Honor Code Pledge:
// Project 3 Fall 2024
// As a Hokie, I will conduct myself with honor and integrity at all times.
// I will not lie, cheat, or steal, nor will I accept the actions of those who
// do.
// -- Karthik Yella (karthikyella)

package towerofhanoi;

// -------------------------------------------------------------------------
/**
 * This class extends the LinkedStack with Disk as the generic type. It also
 * overrides the push method and includes a getter method to get the tower's
 * position.
 * 
 * @author karth
 * @version Oct 22, 2024
 */
public class Tower
    extends LinkedStack<Disk>
{
    private Position position;

    // ----------------------------------------------------------
    /**
     * Create a new Tower object.
     * 
     * @param pos
     *            of tower
     */
    public Tower(Position pos)
    {
        super();
        this.position = pos;
    }


    // ----------------------------------------------------------
    /**
     * returns position of tower
     * 
     * @return position of tower
     */
    public Position position()
    {
        return position;
    }


    @Override
    public void push(Disk disk)
    {
        if (disk == null)
        {
            throw new IllegalArgumentException("Disk is null");
        }
        if (this.isEmpty() || this.peek().compareTo(disk) == 1)
        {
            super.push(disk);
        }
        else
        {
            throw new IllegalStateException(
                "Disk can not be placed on this tower");
        }
    }

}
