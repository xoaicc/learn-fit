package Tut10.Example1;
/**
 * Class BTNode implements a node of a binary tree.
 * Please refer to the lecture 10 and tutorial week 10 documents for the detail.
 * @author (nxthang) 
 * @version (1.0)
 */
public class BTNode
{
    private String label;
    
    /**
     * Constructor for objects of class BTNode
     */
    public BTNode(String label)
    {
        this.label=label;
    }

    public void setLabel(String label)
    {
        this.label=label;
    }
    
    public String getLabel()
    {
        return label;
    }
}
