
/**
 * Class SLList implement a linked-list data structure. Each element of the list is a string.
 * Please refer to Lecture 6 for the detail Linked-List ADT.
 * 
 * @author (nxthang) 
 * @version (1.0)
 */
package Tut06.SLList;

public class SLList
{
    private SLNode head;

    /**
     * Constructor for objects of class SLList.
     * This constructor will create an empty list.
     */
    public SLList()
    {
        head=null;
    }

    /**
     * This operation returns true if the list is empty, otherwise it returns false
     */

    public boolean isEmpty()
    {
        if (head==null)
            return true;
        else
            return false;
    }

    /**
     * This operation adds a newNode into the beginning of the list
     */

    public void add(SLNode newNode)
    {
        newNode.setNext(head);
        head=newNode;
    }

    /**
     * This is a private operation (supplementary operation). It returns the node at the pos position of the list.
     */    
    private SLNode traversing(int pos)
    {
        int count=1;
        SLNode current = head;
        while (count < pos)
        {
            count++;
            current=current.getNext();
        }
        return current;
    }

    /**
     * This operation adds a newNode right at the pos position of the list.
     */

    public void addAt(int pos, SLNode newNode)
    {
        SLNode prevNode=traversing(pos-1); 
        newNode.setNext(prevNode.getNext());
        prevNode.setNext(newNode);
    }

    /**
     * This operation delete the node at the pos postition of the list.
     */    
  
    public void remove(int pos)
    {
        if (!isEmpty())
        {
            if (pos == 1)
            {
                head=head.getNext();
            }
            else
            {
                SLNode prevNode=traversing(pos-1);
                SLNode posNode=prevNode.getNext();
                prevNode.setNext(posNode.getNext());
            }  
        }
        
      
    }

    /**
     * This operation remove all nodes from the list.
     */    
    public void removeAll()
    {
        head=null;
    }

    /**
     * This operation returns the node at the pos position of the list.
     */    
    public SLNode get(int pos)
    {
        if (!isEmpty())
            return traversing(pos);
        else
            return null;
    }

    /**
     * This operation returns the current length of the list. 
     */    
  
    public int getLength()
    {
        int count=0;
        SLNode current=this.head;
        while (current != null)
        {
            count++;
            current=current.getNext();
        }
        return count;
    }
    
    /**
     * This operation search for a string in the list. 
     * If found the operation returns the position of the node contain this string, otherwise it returns -1. 
     */    
    public int search(String data)
    {
    	 int count=1;
         SLNode current=this.head;       
         while ((current !=null) && (!current.getData().equalsIgnoreCase(data)))
         {
             count++;
             current=current.getNext();
         }
         if (current == null)
             return -1;
         else
             return count;  
    }
}