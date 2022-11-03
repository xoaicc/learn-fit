package Tut08.prototype;

/* Create the ShapeDraw class which uses ShapeCache class 
to get clones of shapes stored in a Hashtable. */
public class ShapeDraw {
	// TO-DO: Implement the main() method for testing purpose
	public static void main(String[] args) {
		// run loadCache() method
		ShapeCache.loadCache();

		/*
		 * create 3 cloned shapes with 3 different types Hint: use getShape() &
		 * getType() methods
		 */
		Shape sh1 = (Shape) ShapeCache.getShape("s1");
		System.out.println("Shape: " + sh1.getType());

		Shape sh2 = (Shape) ShapeCache.getShape("s2");
		System.out.println("Shape: " + sh2.getType());

		Shape sh3 = (Shape) ShapeCache.getShape("s3");
		System.out.println("Shape: " + sh3.getType());
	}
}