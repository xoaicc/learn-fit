package PR1Tutorial.Tut09;

import java.io.PrintWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;

class Act4 {
    static int m = 0;
    static String[] strArray = new String[0];
    static char[] charArray = new char[0];

    // Backtracking algorithm in my mine
    static String[] createArray(int j, int n) {
        for (int i = 0; i < 2; i++) {
            while (true) {
                charArray[j] = Character.forDigit(i, 10);
                if (j == 4) {
                    strArray[m] = "".copyValueOf(charArray, 0, n);
                    m++;
                    if (i == 1) {
                        j--;
                        return strArray;
                    } else break;
                }
                createArray(j+1, n);
                break;
            }
        }
        return strArray;
    }
    public static void main(String[] args) throws IOException {
        Scanner input = new Scanner(System.in);
        int n;
        int k;
        String check1 = "";
        ArrayList<String> strArray2 = new ArrayList<String>();
        do {
            System.out.print("Enter N and K: ");
            n = input.nextInt();
            k = input.nextInt();
        } while (!(1 <= k) || !(k < n) || !(n <= 32));
        for (int i = 0; i < k; i++) {
            check1 += "A";
        }
        String check2 = check1 + "A";
        strArray = new String[(int) Math.pow(2, n)];
        charArray = new char[n];
        input.close();
        createArray(0, n);
        for (int i = 0; i < strArray.length; i++) {
            strArray[i] = strArray[i].replaceAll("0", "A");
            strArray[i] = strArray[i].replaceAll("1", "B");
            if (strArray[i].contains(check1) == true) {
                if (strArray[i].contains(check2) == false) {
                    strArray2.add(strArray[i]);
                }
            }
        }
        try {
            PrintWriter fileOut = new PrintWriter("ketqua.txt");
            fileOut.println(strArray2.size());
            for (int i = 0; i < strArray2.size(); i++) {
                if (i == strArray2.size()-1) fileOut.print(strArray2.get(i));
                else fileOut.println(strArray2.get(i));
            }
            fileOut.close();
        } catch (Exception e) {
            e.getStackTrace();
        }
    }
}