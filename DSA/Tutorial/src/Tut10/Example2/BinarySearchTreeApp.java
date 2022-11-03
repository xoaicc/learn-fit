package Tut10.Example2;
/**
 * Class BinarySearchTreeApp demonstrates an example of how to use BinarySearchTree and BSTNode classes.
 * @author (nxthang) 
 * @version (1.0)
 */
public class BinarySearchTreeApp
{
    /**
     * Constructor for objects of class BinarySearchTreeApp
     */
    public BinarySearchTreeApp()
    {
    }

    public static void main(String[]args)
    {
        BinarySearchTree t=new BinarySearchTree();
        t.addRoot(7);
        t.insert(5,t);
        t.insert(10,t);
        t.insert(4,t);        
        t.insert(20,t);        
        t.insert(6,t);        
        t.insert(8,t);                
        t.preOrderTraversal(t);
        System.out.println("");
        System.out.println("The maximum value of all nodes in the tree is: " + t.getMax(t));
        System.out.println("The minimum value of all nodes in the tree is: " + t.getMin(t));        
        System.out.println("Searching for key=8 " + t.search(8,t));
        System.out.println("Searching for key=30 " + t.search(30,t));        
    }
}
