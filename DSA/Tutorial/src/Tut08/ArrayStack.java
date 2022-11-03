/**
 * Class ArrayStack implements an array-based stack data structure. Each element of the stack is an integer.
 * Please refer to Lecture 7 for the array-based stack ADT in detail. 
 * 
 * @author (nxthang) 
 * @version (1.0)
 */
package Tut08;
public class ArrayStack
{
    private int[] items;
    private static final int maxSize=100;
    private int top;
    /**
     * Constructor for objects of class ArrayStack.
     * This constructor creates an empty stack.
     */
    public ArrayStack()
    {
        items=new int[maxSize];
        top=-1;
    }

    /**
     * This operation returns true if the stack is empty, otherwise it returns false
     */    
    public boolean isEmpty()
    {
        if (top==-1)
            return true;
        else
            return false;
    }
    
    /**
     * This operation returns true if the stack is full, otherwise it returns false
     */    
    public boolean isFull()
    {
        if (top==maxSize-1)
            return true;
        else
            return false;
    }
    
    /**
     * This operation adds a newItem to the stack
     */        
    public void push(int newItem)
    {
        if (!isFull())
        {
            top++;
            items[top]=newItem;
        }
    }

    /**
     * This operation returns the item at the top position of the stack and deletes this item.
     */    
    public int pop()
    {
        if (!isEmpty())
        {
            int tmp=items[top];
            top--;
            return tmp;
        }
        else
            return -1; 
    }
    
    /**
     * This operation returns an item at the top position of the stack. This item will not be deleted.
     */        
    public int peek()
    {
        if (!isEmpty())
            return items[top];
        else
            return -1;  
    }
}