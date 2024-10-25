// Virginia Tech Honor Code Pledge:
// Project 3 Fall 2024
// As a Hokie, I will conduct myself with honor and integrity at all times.
// I will not lie, cheat, or steal, nor will I accept the actions of those who
// do.
// -- Karthik Yella (karthikyella)

package towerofhanoi;

import java.util.EmptyStackException;
import stack.StackInterface;

// -------------------------------------------------------------------------
/**
 * This class is the linked node implementation of a stack to be used to
 * respresent the stack of disks in the Tower of Hanoi game.
 * 
 * @param <T>
 * @author karth
 * @version Oct 22, 2024
 */
public class LinkedStack<T>
    implements StackInterface<T>
{

    private int size;
    private Node topNode;

    // ----------------------------------------------------------
    /**
     * Create a new LinkedStack object.
     */
    public LinkedStack()
    {
        topNode = null;
        size = 0;
    }


    @Override
    public void clear()
    {
        topNode = null;
        size = 0;

    }


    // ----------------------------------------------------------
    /**
     * Gives size
     * 
     * @return size of stack
     */
    public int size()
    {
        return size;
    }


    @Override
    public boolean isEmpty()
    {

        return size == 0;
    }


    @Override
    public T peek()
    {
        if (size == 0)
        {
            throw new EmptyStackException();
        }
        return topNode.data;
    }


    @Override
    public T pop()
    {
        if (size == 0)
        {
            throw new EmptyStackException();
        }
        T removed = topNode.data;
        topNode = topNode.next;
        size--;
        return removed;
    }


    @Override
    public void push(T anEntry)
    {
        Node newNode = new Node(anEntry, topNode);
        topNode = newNode;
        if (anEntry != null)
        {
            size++;
        }

    }


    @Override
    public String toString()
    {
        if (isEmpty())
        {
            return "[]";
        }

        StringBuilder sb = new StringBuilder("[");
        Node current = topNode;

        while (current != null)
        {
            sb.append(current.data);
            current = current.next;
            if (current != null)
            {
                sb.append(", ");
            }
        }

        sb.append("]");
        return sb.toString();
    }

    private class Node
    {
        private Node next;
        private T data;

        public Node(T entry, Node node)
        {
            this(entry);
            this.setNextNode(node);
        }


        public Node(T data)
        {
            this.data = data;
        }


        public T getData()
        {
            return this.data;
        }


        public Node getNextNode()
        {
            return next;
        }


        public void setNextNode(Node node)
        {
            this.next = node;
        }

    }

}
