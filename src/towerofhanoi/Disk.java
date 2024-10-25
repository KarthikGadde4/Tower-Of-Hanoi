// Virginia Tech Honor Code Pledge:
// Project 3 Fall 2024
// As a Hokie, I will conduct myself with honor and integrity at all times.
// I will not lie, cheat, or steal, nor will I accept the actions of those who
// do.
// -- Karthik Yella (karthikyella)

package towerofhanoi;

import cs2.Shape;
import java.awt.Color;
import student.TestableRandom;

// -------------------------------------------------------------------------
/**
 * he Disk class implements the Comparable interface specifically for Disk
 * objects and is a subclass of Shape, designed for use in a Tower of Hanoi
 * game.
 * 
 * @author karth
 * @version Oct 22, 2024
 */
public class Disk
    extends Shape
    implements Comparable<Disk>

{
    // ----------------------------------------------------------
    /**
     * Create a new Disk object.
     * 
     * @param width
     *            is the width of the disk
     */
    public Disk(int width)
    {
        super(0, 0, width, PuzzleWindow.DISK_HEIGHT);
        TestableRandom rand = new TestableRandom();
        Color color =
            new Color(rand.nextInt(256), rand.nextInt(256), rand.nextInt(256));
        setBackgroundColor(color);

    }


    @Override
    public int compareTo(Disk otherDisk)
    {
        if (otherDisk == null)
        {
            throw new IllegalArgumentException();
        }
        if (getWidth() < otherDisk.getWidth())
        {
            return -1;
        }
        else if (getWidth() > otherDisk.getWidth())
        {
            return 1;
        }
        else
        {
            return 0;
        }
    }


    // ----------------------------------------------------------
    /**
     * Creates a string representation of disk widths
     * 
     * @return string representation of array
     */
    public String toString()
    {
        String str = Integer.toString(getWidth());
        return str;
    }


    // ----------------------------------------------------------
    /**
     * Compares two disk objects to see if they are equals
     * 
     * @param otherDisk
     *            disk to be checked against
     * @return true if equal false if not
     */
    public boolean equals(Object otherDisk)
    {
        if (otherDisk == null)
        {
            return false;
        }
        if (otherDisk.getClass() != this.getClass())
        {
            return false;
        }
        Disk disk = (Disk)otherDisk;
        return (this.compareTo(disk) == 0);
    }

}
