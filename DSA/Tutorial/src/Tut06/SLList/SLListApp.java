    
/**
 * Write a description of class SLListApp here.
 * 
 * @author (nxthang) 
 * @version (1.0)
 */
package Tut06.SLList;

public class SLListApp
{
    /**
     * Constructor for objects of class SLListApp
     */
    public SLListApp()
    {
    }
    
    public static void printList(SLList list)
    {
        int l=list.getLength();
        String str="";
        for (int i=1; i<=l; i++)
        {
            SLNode aNode=list.get(i);
            str=str+aNode.getData()+ "  ";
        }
        System.out.println(str);
    }
    public static void main(String[]args)
    {
        SLList myList=new SLList();
        myList.add(new SLNode("The First String"));
        myList.add(new SLNode("The Second String"));
        myList.add(new SLNode("The Third String"));       
        
        printList(myList);
        myList.addAt(3,new SLNode("ABC"));
        printList(myList);
        System.out.println(myList.search("abc"));
        myList.remove(2);
        printList(myList);
        myList.removeAll();
        myList.add(new SLNode("A new string"));
        printList(myList);        
    }    
}
