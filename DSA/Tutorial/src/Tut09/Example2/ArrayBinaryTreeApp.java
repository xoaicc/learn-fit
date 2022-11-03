package Tut09.Example2;
/**
 * Class ArrayBinaryTreeApp demonstrates an example about how to use ArrayBinaryTree class.
 * @author (nxthang) 
 * @version (1.0)
 */
public class ArrayBinaryTreeApp
{
    /**
     * Constructor for objects of class ArrayBinaryTreeApp
     */
    public ArrayBinaryTreeApp()
    {
    }

    public static void main(String[]args)
    {
        ArrayBinaryTree T=new ArrayBinaryTree();
        T.addRoot("A");
        T.addLeftChild("B",0);
        T.addRightChild("C",0);
        T.addLeftChild("D",1);
        T.addLeftChild("E",2);        
        T.addRightChild("F",2);
        T.addLeftChild("G",3);
        T.addLeftChild("H",5);        
        T.addRightChild("I",5);        
        T.addRightChild("K",6);                
        T.preOrderTravel(0);
    }    
}
