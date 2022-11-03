package Tut10.Example2;
/**
 * Class BinarySearchTree implements a binary search tree. Please refer to the lecture 10 for details.
 * @author (nxthang) 
 * @version (1.0)
 */
public class BinarySearchTree
{
    BSTNode root;
    BinarySearchTree leftSubTree;
    BinarySearchTree rightSubTree;
    
    /**
     * Constructor for objects of class BinarySearchTree
     * Create an empty binary search tree
     */
    public BinarySearchTree()
    {
        root=null;
        leftSubTree=null;
        rightSubTree=null;
    }
    
    public void addRoot(int value)
    {
        root=new BSTNode(value);
    }
    
    public boolean isEmpty()
    {
        return ((root==null)&&(leftSubTree==null)&&(rightSubTree==null));
    }
    
    public int getTreeValue()
    {
        return root.getValue();
    }
    
    public BinarySearchTree getRightSubTree()
    {
        return rightSubTree;
    }
    
    public BinarySearchTree getLeftSubTree()
    {
        return leftSubTree;
    }
    
    public void setRightSubTree(BinarySearchTree right)
    {
        rightSubTree=right;
    }

    public void setLeftSubTree(BinarySearchTree left)
    {
        leftSubTree=left;
    }
    
    public boolean insert(int key, BinarySearchTree t)
    {
        if (t.isEmpty())
        {
            t.addRoot(key);
            return true;
        }    
        else
        {
            if (key == t.getTreeValue())
                return false;
            else
            {
                if (key > t.getTreeValue())
                {
                    if (t.getRightSubTree() == null)
                    {
                        BinarySearchTree t1=new BinarySearchTree();
                        t1.addRoot(key);
                        t.setRightSubTree(t1);
                        return true;
                    }
                    else
                        return insert(key,t.getRightSubTree());
                }    
                else
                {
                    if (t.getLeftSubTree() == null)
                    {
                        BinarySearchTree t1=new BinarySearchTree();
                        t1.addRoot(key);
                        t.setLeftSubTree(t1);
                        return true;
                    }
                    else
                        return insert(key,t.getLeftSubTree());
                }   
            }
        }
    }

    public int getMax(BinarySearchTree t)
    {
        if (t.getRightSubTree() == null)
            return t.getTreeValue();
        return getMax(t.getRightSubTree());    
    }

    public int getMin(BinarySearchTree t)
    {
        if (t.getLeftSubTree() == null)
            return t.getTreeValue();
        return getMin(t.getLeftSubTree());    
    }
    
    public boolean search(int key, BinarySearchTree t)
    {
        if (t==null)
            return false;
        if (key == t.getTreeValue())
            return true;
        if (key > t.getTreeValue())
            return search(key,t.getRightSubTree());
        else
            return search(key,t.getLeftSubTree());
    }
    public void preOrderTraversal(BinarySearchTree t)
    {
        if (t!=null)
        {
            System.out.print(t.getTreeValue() + " ");
            preOrderTraversal(t.getLeftSubTree());
            preOrderTraversal(t.getRightSubTree());
        }        
    }
}
