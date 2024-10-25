// Virginia Tech Honor Code Pledge:
// Project 3 Fall 2024
// As a Hokie, I will conduct myself with honor and integrity at all times.
// I will not lie, cheat, or steal, nor will I accept the actions of those who
// do.
// -- Karthik Yella (karthikyella)

package towerofhanoi;

// -------------------------------------------------------------------------
/**
 * Tests the methods in the Tower class
 * 
 * @author karth
 * @version Oct 22, 2024
 */
public class TowerTest
    extends student.TestCase
{
    private Tower tower1;

    // ----------------------------------------------------------
    /**
     * Create a new TowerTest object.
     */
    public TowerTest()
    {
        // Nothing needed
    }


    // ----------------------------------------------------------
    /**
     * Sets up for testing
     */
    public void setUp()
    {
        tower1 = new Tower(Position.LEFT);
    }


    // ----------------------------------------------------------
    /**
     * Tests the Position method
     */
    public void testPosition()
    {
        assertEquals(Position.LEFT, tower1.position());
    }


    // ----------------------------------------------------------
    /**
     * Tests the Overriden Push method
     */
    public void testOverriddenPush()
    {
        Disk disk1 = new Disk(10);
        Disk disk2 = new Disk(20);

        tower1.push(disk1);
        assertEquals(disk1, tower1.peek());

        try
        {
            tower1.push(disk2);
            fail("Expected IllegalStateException larger disk on smaller one");
        }
        catch (IllegalStateException e)
        {
            assertEquals(
                "Disk can not be placed on this tower",
                e.getMessage());
        }

        try
        {
            tower1.push(null);
            fail("Expected IllegalArgumentException for pushing null disk");
        }
        catch (IllegalArgumentException e)
        {
            assertEquals("Disk is null", e.getMessage());
        }

        tower1.clear();
        tower1.push(disk2);
        assertEquals(disk2, tower1.peek());

        tower1.push(disk1);
        assertEquals(disk1, tower1.peek());
    }

}
