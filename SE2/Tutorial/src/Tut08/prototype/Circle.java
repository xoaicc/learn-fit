package Tut08.prototype;

//Create the Circle concrete class which extends the Shape abstract class
public class Circle extends Shape {
	// TO-DO: Declare the constructor
	public Circle() {
		// Set type to be similar with class name
		type = "Circle";
	}

	// TO-DO: Declare the draw() method
	@Override
	public void draw() {
		/*
		 * Only print out the draw() method to test. No need to implement the real
		 * drawing
		 */
		System.out.println("Inside Circle::draw() method.");
	}
}
