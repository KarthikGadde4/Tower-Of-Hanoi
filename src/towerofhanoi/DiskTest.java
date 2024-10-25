// Virginia Tech Honor Code Pledge:
// Project 3 Fall 2024
// As a Hokie, I will conduct myself with honor and integrity at all times.
// I will not lie, cheat, or steal, nor will I accept the actions of those who
// do.
// -- Karthik Yella (karthikyella)

package towerofhanoi;

// -------------------------------------------------------------------------
/**
 * Tests the Disk class methods
 * 
 * @author karth
 * @version Oct 22, 2024
 */
public class DiskTest
    extends student.TestCase
{
    private Disk disk1;
    private Disk disk2;
    private Disk disk3;
    private Disk disk4;
    private String str;

    // ----------------------------------------------------------
    /**
     * Sets up for testing
     */
    public void setUp()
    {
        disk1 = new Disk(2);
        disk2 = new Disk(2);
        disk3 = new Disk(3);
        disk4 = new Disk(1);
        str = "test";
    }


    // ----------------------------------------------------------
    /**
     * Tests the compareTo method
     */
    public void testCompareTo()
    {
        try
        {
            disk1.compareTo(null);
            System.out
                .println("Test failed: Expected IllegalArgumentException");
        }
        catch (IllegalArgumentException e)
        {
            System.out.println("Test passed: Caught IllegalArgumentException");
        }
        assertEquals(-1, disk1.compareTo(disk3));
        assertEquals(1, disk1.compareTo(disk4));
        assertEquals(0, disk1.compareTo(disk2));
    }


    // ----------------------------------------------------------
    /**
     * Tests the toString method
     */
    public void testToString()
    {
        assertEquals("2", disk1.toString());
        assertNotSame("3", disk2.toString());
    }


    // ----------------------------------------------------------
    /**
     * Tests the equals method
     */
    @SuppressWarnings("unlikely-arg-type")
    public void testEquals()
    {
        assertEquals(false, disk1.equals(null));
        assertEquals(false, disk1.equals(str));
        assertEquals(false, disk1.equals(disk3));
        assertEquals(true, disk1.equals(disk2));
    }

}
