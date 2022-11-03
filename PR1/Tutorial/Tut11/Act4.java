package PR1Tutorial.Tut11;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Scanner;

class Act4 {
    public static void main(String[] args) throws Exception {
        HashMap<String, ArrayList<String>> Classes = new HashMap<String, ArrayList<String>>();
        String className;
        int choice = 0;
        Scanner input = new Scanner(System.in);
        while (choice != 3) {
            ArrayList<String> Class = new ArrayList<String>();
            System.out.print("Menu: \n[1] Add a student\n[2] Display all students\n[3] Exit\nEnter your choice: ");
            choice = input.nextInt();
            input.nextLine();
            switch (choice) {
                case 1:
                    System.out.print("Enter the class name to add: ");
                    className = input.nextLine();
                    System.out.print("Enter the student name to add: ");
                    String studentName = input.nextLine();
                    if (Classes.containsKey(className)) {
                        Class = Classes.get(className);
                        Class.add(studentName);
                        Classes.put(className, Class);
                    } else {
                        Class.add(studentName);
                        Classes.put(className, Class);
                    }
                    break;
                case 2:
                    int count = 0;
                    System.out.print("Enter the class name to show: ");
                    className = input.nextLine();
                    if (Classes.containsKey(className)) {
                        System.out.print("All of students in class " + className + " are: ");
                        for (String i : Classes.get(className)) {
                            count++;
                            if (count == Classes.get(className).size()) System.out.println(i);
                            else System.out.print(i + ", ");
                        }
                    } else System.out.println("Class not found!");
                    break;
                case 3:
                    System.out.println("Goodbye!");
                    break;
                default: 
                    System.out.println("Invalid choice!");
                    break;
            }
            System.out.println();
        }
        input.close();
    }
}