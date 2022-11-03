package Tut09.Example2;

/**
 * Class ArrayBinaryTree implements Binary Tree data structure using an array. 
 * Binary Tree's nodes are indexed using the numbering scheme introduced in Lecture 09.
 * Node has a string label that is stored in the l array.
 * Please refers to Lecture 09 and week 09 tutorial instruction for more detail on Binary Tree's ADT.
 * @author (nxthang) 
 * @version (1.0)
 */
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;

public class ArrayBinaryTree
{
    private static final int maxSize=100; //Maximum possible number of nodes in the tree
    private String[] l;
    
    /**
     * Constructor for objects of class ArrayBinaryTree
     * Create an empty Binary Tree
     */
    public ArrayBinaryTree()
    {
        l = new String[maxSize];
        Arrays.fill(l,null);
    }

    public void addRoot(String label)
    {
        if (l[0]==null)
        {
            l[0]=label;     
        }
    }
    
    public int getLeftChild(int node)
    {
        return 2*node+1;
    }
    
    public int getRightChild(int node)
    {
        return 2*node+2;
    }
    
    public int getParent(int node)
    {
        return (int)Math.floor((node-1)/2);
    }
    
    public String getNodeLabel(int node)
    {
        return l[node];
    }
    
    public void setNodeLabel(String label, int node)
    {
        l[node]=label;
    }
    
    public void addLeftChild(String label, int node)
    {
        setNodeLabel(label,getLeftChild(node));
    }

    public void addRightChild(String label, int node)
    {
        setNodeLabel(label,getRightChild(node));
    }
    
    public void preOrderTravel(int node)
    {
        if (l[node] != null)
        {
            System.out.print(l[node] + " ");
            preOrderTravel(getLeftChild(node));
            preOrderTravel(getRightChild(node));
        }
    }
    
    public boolean isEmpty()
    {
        return (l[0]==null);
    }

    public boolean isLeaf(int node) {
        return getLeftChild(node) > maxSize;
    }

    public int countLeaves() {
        int count = 0;
        for (int i = 1; i < maxSize; i++) {
            if (isLeaf(i)) count++;
        }
        return count;
    }

    public int getLevel(int node) {
        int level = 0;
        int pNode = node;
        if (pNode != 0) {
            do {
                pNode = getParent(pNode);
                level++;
            } while (pNode != 0);
        }
        return level;
    }

    public int getDepth() {
        for (int i = maxSize; i > 0; i--) {
            if (l[i] != null) return getLevel(maxSize);
        }
        return -1;
    }

    public void inOrderTravel(int node) {
        HashSet<String> traversal = new HashSet<>();
        for (int i = node; i < maxSize; i++) {
            if (l[i] != null) traversal.add(l[i]);
        }
    }

    public void postOrderTravel(int node) {
        HashSet<String> traversal = new HashSet<>();
        for (int i = maxSize; i > node; i--) {
            if (l[i] != null) traversal.add(l[i]);
        }
    }

    public int search(String label) {
        for (int i = 0; i < maxSize; i++) {
            if (l[i].equals(label)) return i;
        }
        return -1;
    }
}