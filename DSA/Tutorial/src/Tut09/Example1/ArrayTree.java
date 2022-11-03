package Tut09.Example1;

/**
 * Class ArrayTree implements Tree data structure using arrays. 
 * Tree's nodes are indexed using the numbering scheme introduced in Lecture 09.
 * Node has a string label that is stored in the l array. p array is used to store
 * parent-child relationship.
 * Please refers to Lecture 09 and week 09 tutorial instruction for more detail on Tree's ADT.
 * @author (nxthang) 
 * @version (1.0)
 */
import java.util.Arrays;
public class ArrayTree
{
    private static final int maxSize=10; //Maximum possible number of nodes in the tree
    private int n;                        //Current number of nodes in the tree
    private String[] l;
    private int[] p;
    
    /**
     * Constructor for objects of class ArrayTree
     * Create an empty Tree.
     */
    public ArrayTree()
    {
        n=0;
        l=new String[maxSize];
        p=new int[maxSize];
        Arrays.fill(p,-2);
    }
    
    public boolean isFull()
    {
        return (n==maxSize);
    }
    
    public boolean isEmpty()
    {
        return (n==0);
    }

    public boolean isLeaf(int node) {
        return leftMostChild(node) == -1;
    }

    public void addNode(String label, int parent)
    {
        if (!isFull())
        {
            if (parent==-1) //Adding a root node
            {
                l[0]=label;
                p[0]=-1;
            }
            else
            {
                //Finding a correct position in the array for the new node 
                int pos=parent+1;
                while ((pos<n)&&(getParent(pos)<=parent))
                {
                    pos++;
                }
                //Shift all array elements from pos one slot to the right
                for (int i=n;i>pos;i--)
                {
                    l[i]=l[i-1];
                    p[i]=p[i-1];
                }
                l[pos]=label;
                p[pos]=parent;
            }
            n++;
            System.out.println("Added node "+label);
        }
        else
        	System.out.println("Tree is full now");
    }

    public int getParent(int node)
    {
        return p[node];
    }
    
    public int getDegree(int node) {
        int deg = 0;
        for (int i = node; i < n; i++) {
            if (p[i] == node) deg++;
        }
        return deg;
    }

    public String getNodeLabel(int node)
    {
        if (node != -1)
            return l[node];
        else
            return null;
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
        return getLevel(n);
    }

    public void setNodeLabel(int node, String label)
    {
        l[node]=label;
    }

    public int countLeaves() {
        int count = 0;
        for (int i = 0; i < n; i++) {
            if (isLeaf(i)) count++;
        }
        return count;
    }

    public int leftMostChild(int node)
    {
        int i=node+1;
        //Find the first node i that i's parent is node (p[i]==node).
        while ((i<n-1)&&(getParent(i)!=node))
            i++;

        if (getParent(i)==node)
            return i;
        else
            return -1;
    }
    
    public int nearestRightSibling(int node)
    {
        int i=node+1;
        //Check if i's parent is node's parent
        if (getParent(i)==getParent(node))
            return i;
        else    
            return -1;
    }

    public int search(String label) {
        for (int i = 0; i < n; i++) {
            if (l[i].equals(label)) return i;
        }
        return -1;
    }

    public void printTree()
    {
    	System.out.println("Tree currently: ");
    	for (int i=0;i<n;i++)
    	{
    		System.out.print(" "+l[i]);
    	}
    	System.out.println();
    	for (int i=0;i<n;i++)
    	{
    		System.out.print(p[i]+" ");	
    	}
    	System.out.println();
    }
}
