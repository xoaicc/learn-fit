/**
 * Class ArrayList implements an array-based list data structure. Each element of the list is an integer.
 * Please refer to Lecture 6 for the array-based list ADT in detail. 
 * 
 * @author (nxthang) 
 * @version (1.0)
 */
package Tut06.ArrayList;
public class ArrayList
{
    private int[] items;
    private static final int maxSize=100;
    private int length;
    /**
     * Constructor for objects of class ArrayList.
     * This constructor creates an empty list.
     */
    public ArrayList()
    {
        items=new int[maxSize];
        length=0;
    }

    /**
     * This operation returns true if the list is empty, otherwise it returns false
     */    
    public boolean isEmpty()
    {
        if (length==0)
            return true;
        else
            return false;
    }

    /**
     * This operation returns the current length of the list. 
     */        
    public int getLength()
    {
        return length;
    }

    /**
     * This operation adds a newNode at the pos position of the list.
     */

    public void add(int pos, int newItem)
    {
        if (length<maxSize)
        {
            length++;
            for (int i=length-1; i>=pos; i--)
                items[i]=items[i-1];
         
            items[pos-1]=newItem;
        }
    }

    /**
     * This operation delete the node at the pos postition of the list.
     */  
   
    public void remove(int pos)
    {
        if (isEmpty()) {
            if (pos == 1) {
                length=0;
            } else {
                length--;
                for (int i = pos; i < length; i++)
                    items[i] = items[i + 1];
            }
        }
    }
    
    /**
     * This operation remove all nodes from the list.
     */        
    public void removeAll()
    {
        length=0;
    }

    /**
     * This operation returns the node at the pos position of the list.
     */        
    public int get(int pos)
    {
        return items[pos-1];
    }
}