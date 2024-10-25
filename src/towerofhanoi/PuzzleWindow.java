// Virginia Tech Honor Code Pledge:
// Project 3 Fall 2024
// As a Hokie, I will conduct myself with honor and integrity at all times.
// I will not lie, cheat, or steal, nor will I accept the actions of those who
// do.
// -- Karthik Yella (karthikyella)

package towerofhanoi;

import cs2.Button;
import cs2.Shape;
import cs2.Window;
import cs2.WindowSide;

import java.awt.*;
import java.util.Observable;
import java.util.Observer;

/**
 * The main front-end work and the view for the Tower of Hanoi puzzle (Fall
 * 2024)
 *
 * @author Name
 * @version Date
 */
@SuppressWarnings("deprecation")
public class PuzzleWindow
    implements Observer
{

    private HanoiSolver game;
    private Shape left;
    private Shape center;
    private Shape right;
    private Window window;

    /**
     * A factor in which the width of the disks are multiplied by
     */
    public static final int WIDTH_FACTOR = 15;
    /**
     * The vertical gap between each disk on the tower
     */
    public static final int DISK_GAP = 0;
    /**
     * The height of each disk on the tower
     */
    public static final int DISK_HEIGHT = 15;

    /**
     * Creates a new PuzzleWindow view for a given HanoiSolver game
     *
     * @param g
     *            the game to create a view for
     */
    public PuzzleWindow(HanoiSolver g)
    {
        this.game = g;
        game.addObserver(this);

        this.window = new Window("Tower of Hanoi");
        window.setSize(700, 150);
        // The height and Y location of each pole are the same
        int poleHeight = 400;
        int poleY = (window.getGraphPanelHeight() / 2) - (poleHeight / 2);
        left = new Shape(
            (200 - 15 / 2),
            poleY,
            15,
            poleHeight,
            new Color(50, 50, 50));
        center = new Shape(
            ((window.getGraphPanelWidth() / 2) - 15 / 2),
            poleY,
            15,
            poleHeight,
            new Color(50, 50, 50));
        right = new Shape(
            ((window.getGraphPanelWidth() - 200) - 15 / 2),
            poleY,
            15,
            poleHeight,
            new Color(50, 50, 50));

        for (int width =
            (game.disks() + 1) * WIDTH_FACTOR; width > WIDTH_FACTOR; width -=
                WIDTH_FACTOR)
        {
            Disk newDisk = new Disk(width);
            window.addShape(newDisk);
            game.getTower(Position.LEFT).push(newDisk);
            moveDisk(Position.LEFT);

        }
        window.addShape(left);
        window.addShape(center);
        window.addShape(right);

        Button solve = new Button("Solve");
        window.addButton(solve, WindowSide.SOUTH);
        solve.onClick(this, "clickedSolve");
    }


    private void moveDisk(Position position)
    {
        Disk currentDisk;
        Shape currentPole = null;
        Tower currentTower = game.getTower(position);
        currentDisk = currentTower.peek();
        switch (position)
        {
            case LEFT:
                currentPole = left;
                break;
            case RIGHT:
                currentPole = right;
                break;
            case CENTER:
                currentPole = center;
                break;
            default:
                currentPole = left;
                break;

        }
        int xPos = currentPole.getX()
            - (currentDisk.getWidth() - currentPole.getWidth()) / 2;
        int yPos = currentPole.getY() + currentPole.getHeight()
            - DISK_HEIGHT * (currentTower.size())
            - DISK_GAP * (currentTower.size());
        currentDisk.moveTo(xPos, yPos);
    }


    /**
     * Updates the view whenever a disk is moved in the back-end
     *
     * @param o
     *            The observable that triggered the update
     * @param arg
     *            arguments sent by the game; should be a position
     */
    @Override
    public void update(Observable o, Object arg)
    {
        if (arg.getClass() == Position.class)
        {
            Position position = (Position)arg;
            moveDisk(position);
            sleep();
        }
    }


    /**
     * Runs when the Solve button is clicked, tells the puzzle to start solving
     *
     * @param button
     *            the button that was clicked
     */
    public void clickedSolve(Button button)
    {
        button.disable();
        new Thread() {
            public void run()
            {
                game.solve();
            }
        }.start();
    }


    private void sleep()
    {
        try
        {
            Thread.sleep(500);
        }
        catch (Exception e)
        {
        }
    }
}
