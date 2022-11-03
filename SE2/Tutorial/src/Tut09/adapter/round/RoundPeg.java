package Tut09.adapter.round;

/**
 * RoundPegs are compatible with RoundHoles.
 */
public class RoundPeg {
	//TO-DO: Declare an attribute: name = radius, type = double
	private double radius;

	//TO-DO: Declare the empty constructor
	public RoundPeg() {}

	//TO-DO: Declare another constructor with a parameter
	public RoundPeg(double radius) {
		this.radius = radius;
	}

	//TO-DO: Implement getRadius() method
	public double getRadius() {
		return radius;
	}
}
