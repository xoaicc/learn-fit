package Tut08.factory;

// Create the Admission class to generate object of sub-classes
class Admission {
	// use admittingCourse method to get object of type Course
	public Course admittingCourse(String courseName) {
		//TO-DO: if courseName is null => return null
		if (courseName.equals("")) return null;
		 
		//TO-DO: if courseName is similar to 1 of 3 sub-class's name => return corresponding objects
		courseName = courseName.toLowerCase().replace(" ", "");

		if (courseName.equals("civilservice")) {
			CivilService cs = new CivilService();
			cs.getDuration();
			cs.getFeePerSemester();
			return cs;
		}

		if (courseName.equals("health")) {
			Health he = new Health();
			he.getDuration();
			he.getFeePerSemester();
			return he;
		}

		if (courseName.equals("computer")) {
			Computer co = new Computer();
			co.getDuration();
			co.getFeePerSemester();
			return co;
		}
	 
		//return null for default
		return null;
	}
} 