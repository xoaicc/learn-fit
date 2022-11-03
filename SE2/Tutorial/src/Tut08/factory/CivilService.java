package Tut08.factory;

// Create the CivilService class that extends Course abstract class 
class CivilService extends Course {
	// TO-DO: Implement getDuration() method: set a specific duration and print value
	public void getDuration() {
 		duration = 1;
	}

	// TO-DO: Implement getFeePerSemester() method: set a specific fee and print value
	public void getFeePerSemester() {
 		fee = 99.99;
	}
}