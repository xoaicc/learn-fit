/**
 * Class SLNode implement an elements (a node) of a linked-list data structure.
 * Each element of the list contains a string (data) and a reference variable named next.
 * Please refer to Lecture 6 for the Node ADT in detail.
 * 
 * @author (nxthang) 
 * @version (1.0)
 */
package Tut06.SLList;
public class SLNode
{
    private String data;
    private SLNode next;

    /**
     * Constructor for objects of class SLNode
     * This constructor create a node from an input string (data)
     */
    public SLNode(String data)
    {
        this.data=data;
    }

    /**
     * This operation sets the next reference to the node specify in the parameter (next)
     */    
    public void setNext(SLNode abc)
    {
        this.next=abc;
    }

    /**
     * This operation return the next reference
     */    
    public SLNode getNext()
    {
        return this.next;
    }

    /**
     * This operation assigns data of the node to the input string (data)
     */        
    public void setData(String xyz)
    {
        this.data=xyz;
    }

    /**
     * This operation return the current data of the node
     */        
    public String getData()
    {
        return this.data;
    }    
}