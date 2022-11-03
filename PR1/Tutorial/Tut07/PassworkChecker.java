package PR1Tutorial.Tut07;

import java.util.Scanner;

public class PassworkChecker {
    static int checkPass(String pass) throws Exception {
        int result = 0;
        char[] charArray = pass.toCharArray();
        String specialChars = "/*!@#$%^&*()\"{}_[]|\\?/<>,.";
        
        // Check length
        if (charArray.length == 0) throw new Exception("You don't enter a passwork!");
        if (charArray.length >= 8) result += 1;
        if (charArray.length >= 12) result += 1;
        
        // Check upperCase
        for (int i = 0; i < charArray.length; i++) {
            if(Character.isUpperCase(charArray[i])) {
                result += 1;
                break;
            }
        }
        
        // Check lowerCase
        for (int i = 0; i < charArray.length; i++){
            if(Character.isLowerCase(charArray[i])) {
                result += 1;
                break;
            }
        }
        
        // Check contain digit
        for (int i = 0; i < charArray.length; i++) {
            if(Character.isDigit(charArray[i])) {
                result += 1;
                break;
            }
        }
        
        // Check contain symbol
        for (int i = 0; i < charArray.length; i++) {
            if (specialChars.contains(Character.toString(charArray[i]))) {
                result += 1;
                break;
            }
        }

        return result;
    }

    public static void main(String[] args) throws Exception {
        Scanner input = new Scanner(System.in);
        System.out.print("Enter a new password: ");
        String pass = input.nextLine();
        System.out.print("Strength: ");

        int output = checkPass(pass);
        if (output < 3) System.out.println(output + " (weak)");
        else if (output < 5) System.out.println(output + " (medium)");
        else System.out.println(output + " (strong)");
    }
}