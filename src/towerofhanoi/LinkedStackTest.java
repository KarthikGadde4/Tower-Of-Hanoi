// Virginia Tech Honor Code Pledge:
// Project 3 Fall 2024
// As a Hokie, I will conduct myself with honor and integrity at all times.
// I will not lie, cheat, or steal, nor will I accept the actions of those who
// do.
// -- Karthik Yella (karthikyella)
package towerofhanoi;

import java.util.EmptyStackException;

// -------------------------------------------------------------------------
/**
 * Tests the methods in Linked Stack class
 * 
 * @author karth
 * @version Oct 22, 2024
 */
public class LinkedStackTest
    extends student.TestCase
{
    private LinkedStack<String> stack1;
    private LinkedStack<String> stack2;

    // ----------------------------------------------------------
    /**
     * Create a new LinkedStackTest object.
     */
    public LinkedStackTest()
    {
        // Nothing is needed here
    }


    // ----------------------------------------------------------
    /**
     * sets up for testing
     */

    public void setUp()
    {
        stack1 = new LinkedStack<String>();
        stack1.push("1");
        stack1.push("2");
        stack1.push("3");

        stack2 = new LinkedStack<String>();
    }


    // ----------------------------------------------------------
    /**
     * Tests the isEmpty method
     */
    public void testIsEmpty()
    {
        assertEquals(false, stack1.isEmpty());
        stack1.clear();
        assertTrue(stack1.isEmpty());
        assertTrue(stack2.isEmpty());
    }


    // ----------------------------------------------------------
    /**
     * Tests the size method
     */
    public void testSize()
    {
        assertEquals(3, stack1.size());
        stack1.clear();
        assertEquals(0, stack1.size());
        assertEquals(0, stack2.size());
    }


    // ----------------------------------------------------------
    /**
     * Tests the peek method
     */
    public void testPeek()
    {

        assertEquals("3", stack1.peek());
        stack1.pop();
        assertEquals("2", stack1.peek());
        stack1.pop();
        assertEquals("1", stack1.peek());

        Exception exception = null;
        try
        {
            stack2.peek();
            fail("Did not throw an exception");
        }
        catch (Exception e)
        {
            exception = e;
        }
        assertTrue(
            "Did not throw an exception",
            exception instanceof EmptyStackException);
    }


    // ----------------------------------------------------------
    /**
     * Tests the pop method
     */
    public void testPop()
    {
        assertEquals("3", stack1.pop());
        assertEquals("2", stack1.pop());
        assertEquals("1", stack1.pop());

        Exception exception = null;
        try
        {
            stack2.pop();
            fail("Did not throw an exception");
        }
        catch (Exception e)
        {
            exception = e;
        }
        assertTrue(
            "Did not throw an exception",
            exception instanceof EmptyStackException);
    }


    // ----------------------------------------------------------
    /**
     * Tests the push method
     */
    public void testPush()
    {

        stack2.push("1");
        assertEquals("1", stack2.peek());
        stack2.push("2");
        assertEquals("2", stack2.peek());
        stack2.push(null);
        assertEquals(2, stack2.size());

    }


    // ----------------------------------------------------------
    /**
     * Tests the toString method
     */
    public void testToString()
    {
        assertEquals("[]", stack2.toString());
        assertEquals("[3, 2, 1]", stack1.toString());

    }

}
