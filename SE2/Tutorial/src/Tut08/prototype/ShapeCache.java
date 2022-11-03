package Tut08.prototype;

import java.util.Hashtable;

/* Create the ShapeCache class to get concrete classes from database 
   and store them in a Hashtable. */
public class ShapeCache {

	private static Hashtable<String, Shape> shapeMap = new Hashtable<String, Shape>();

	public static Shape getShape(String shapeId) {
		Shape cachedShape = shapeMap.get(shapeId);
		return (Shape) cachedShape.clone();
	}

	/*
	 * TO-DO: Implement the loadCache() method 
	 * For each shape run database query and
	 * create shape shapeMap.put(shapeKey, shape);
	 */
	public static void loadCache() {
		Circle cc = new Circle();
		cc.setId("s1");
		shapeMap.put(cc.getId(), cc);

		Square sq = new Square();
		sq.setId("s2");
		shapeMap.put(sq.getId(), sq);

		Rectangle re = new Rectangle();
		re.setId("s3");
		shapeMap.put(re.getId(), re);
	}
}