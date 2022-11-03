package Tut08.abstract_factory;

/* Create the AbstractFactoryTest class which uses the FactoryProducer 
 * to get AbstractFactory in order to get factories 
 * of concrete classes by passing an information such as type.
 */

public class AbstractFactoryTest {
	//TO-DO: Implement the main() method for testing purpose
	public static void main(String[] args) {
		// get shape factory
		ShapeFactory sf = new ShapeFactory();
 
		// get an object of Shape Rectangle
		Shape s1 = sf.getShape("rectangle");
 
		// call draw method of Shape Rectangle
		s1.draw();
 
		// get an object of Shape Square
		Shape s2 = sf.getShape("square");
 
		// call draw method of Shape Square
		s2.draw();
	}
}