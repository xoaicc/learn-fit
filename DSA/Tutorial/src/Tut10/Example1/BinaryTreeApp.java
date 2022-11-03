package Tut10.Example1;
/**
 * Class BinaryTreeApp demonstrates an example of how to use BinaryTree and BTNode classes.
 * @author (nxthang) 
 * @version (1.0)
 */
public class BinaryTreeApp
{
    /**
     * Constructor for objects of class BinaryTreeApp
     */
    public BinaryTreeApp()
    {
    }

    public static void main(String[] args)
    {
        BinaryTree t3=new BinaryTree();
        t3.buildTreeByValue("2",null,null);
        BinaryTree t4=new BinaryTree();
        t4.buildTreeByValue("6","5","11");
        BinaryTree t5=new BinaryTree();
        t5.buildTreeByValue("9","4",null);
        BinaryTree t1=new BinaryTree();
        t1.buildTree("7",t3,t4);
        BinaryTree t2=new BinaryTree();
        t2.buildTree("5",null,t5);
        BinaryTree t= new BinaryTree();
        t.buildTree("2",t1,t2);
    	
    	
        t.preOrderTraversal(t);        
        System.out.println("");
        System.out.println("The depth of the tree : " + t.getDepth(t));
        System.out.println("Total leaves of the tree : " + t.countLeaves(t));        
        System.out.println("Internal path length of the tree: " + t.iPathLength(t,0));
        System.out.println("Total nodes of the tree : " + t.countNodes(t));
    }
}
