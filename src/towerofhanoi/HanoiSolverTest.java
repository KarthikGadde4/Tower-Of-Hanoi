// Virginia Tech Honor Code Pledge:
// Project 3 Fall 2024
// As a Hokie, I will conduct myself with honor and integrity at all times.
// I will not lie, cheat, or steal, nor will I accept the actions of those who
// do.
// -- Karthik Yella (karthikyella)

package towerofhanoi;

// -------------------------------------------------------------------------
/**
 * Tests the methods in the HanoiSolver class
 * 
 * @author karth
 * @version Oct 22, 2024
 */
public class HanoiSolverTest
    extends student.TestCase
{

    private HanoiSolver hsolve;
    private Disk disk1;
    private Disk disk2;

    // ----------------------------------------------------------
    /**
     * Create a new HanoiSolverTest object.
     */
    public HanoiSolverTest()
    {
        // Nothing needed
    }


    // ----------------------------------------------------------
    /**
     * Sets up for testing
     */
    public void setUp()
    {
        hsolve = new HanoiSolver(2);
        disk1 = new Disk(10);
        disk2 = new Disk(15);
    }


    // ----------------------------------------------------------
    /**
     * Tests the disks method
     */
    public void testDisks()
    {
        assertEquals(2, hsolve.disks());
    }


    // ----------------------------------------------------------
    /**
     * Tests the get tower method
     */
    public void testGetTower()
    {
        Tower tower1 = new Tower(Position.RIGHT);
        assertEquals(
            tower1.position(),
            hsolve.getTower(Position.RIGHT).position());
        Tower tower2 = new Tower(Position.LEFT);
        assertEquals(
            tower2.position(),
            hsolve.getTower(Position.LEFT).position());
        Tower tower3 = new Tower(Position.CENTER);
        assertEquals(
            tower3.position(),
            hsolve.getTower(Position.CENTER).position());
        Tower tower4 = new Tower(Position.CENTER);
        assertEquals(
            tower4.position(),
            hsolve.getTower(Position.DEFAULT).position());
    }


    // ----------------------------------------------------------
    /**
     * Tests the toString method
     */
    public void testToString()
    {
        assertEquals(hsolve.toString(), "[][][]");
        hsolve.getTower(Position.LEFT).push(disk1);
        hsolve.getTower(Position.RIGHT).push(disk2);
        assertEquals(hsolve.toString(), "[10][][15]");
    }


    // ----------------------------------------------------------
    /**
     * Tests the solve method
     */
    public void testSolve()
    {
        hsolve.getTower(Position.LEFT).push(disk2);
        hsolve.getTower(Position.LEFT).push(disk1);
        hsolve.solve();
        assertEquals(hsolve.toString(), "[][][10, 15]");

    }

}
