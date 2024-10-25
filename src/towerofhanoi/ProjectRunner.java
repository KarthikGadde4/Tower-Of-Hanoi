// Virginia Tech Honor Code Pledge:
// Project 3 Fall 2024
// As a Hokie, I will conduct myself with honor and integrity at all times.
// I will not lie, cheat, or steal, nor will I accept the actions of those who
// do.
// -- Karthik Yella (karthikyella)
package towerofhanoi;

// -------------------------------------------------------------------------
/**
 * Runs the PuzzleWindow file and displays the game. This instantiates any other
 * classes needed for running the game.
 * 
 * @version 2024
 */
public class ProjectRunner
{

    // ----------------------------------------------------------
    /**
     * Create a new ProjectRunner object.
     */
    public ProjectRunner()
    {
        // nothing needed
    }


    // ----------------------------------------------------------
    /**
     * This method runs the program.
     * 
     * @param args
     */
    public static void main(String[] args)
    {
        HanoiSolver hs;
        int disks = 6;
        if (args.length == 1)
        {
            disks = Integer.parseInt(args[0]);
        }
        hs = new HanoiSolver(disks);
        new PuzzleWindow(hs);

    }

}
