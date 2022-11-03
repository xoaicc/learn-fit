package SADTutorial.Tut01;

public class Car {
	private String name;
	private int speed;
	private double regularPrice;
	private String color;

	public Car(String name,int speed, double regularPrice, String color) {
		this.name = name;
		this.speed = speed;
		this.regularPrice = regularPrice;
		this.color = color;
	}
	public double getSalePrice() {
		return color == "Black" ? 1.5 * regularPrice : 1.2 * regularPrice;
	}
	public int getSpeed() {
		return speed;
	}
	public void setSpeed(int speed) {
		this.speed = speed;
	}
	public double getRegularPrice() {
		return regularPrice;
	}
	public void setRegularPrice(double regularPrice) {
		this.regularPrice = regularPrice;
	}
	public String getColor() {
		return color;
	}
	public void setColor(String color) {
		this.color = color;
	}

	@Override
	public String toString() {
		return String.format("%s car whose speed is %s, color %s with regular price = %s and sale price = %s", name, speed,
				color, regularPrice, getSalePrice());
	}
	public static void main(String[] args) {
		Car fordMondeo = new Car("Ford Mondeo", 80, 5000, "Red");
		System.out.println(fordMondeo.toString());
	
		Car toyotaCamry = new Car("Toyota Camry", 90, 6000,"Black");
		System.out.println(toyotaCamry.toString());
	}
}