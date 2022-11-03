package PR1Tutorial.Tut05;

import java.util.Scanner;

public class Act2 {
    public static float average(float[] values, int num) {
        float ave = 0;
        for (float value : values) {
            ave += value;
        }
        return ave / num;
    }

    public static float smallest(float[] values, int num) {
        float min = values[0];
        for (float value : values) {
            if (value < min) {
                min = value;
            }
        }
        return min;
    }

    public static float largest(float[] values, int num) {
        float max = values[0];
        for (float value : values) {
            if (value > max) {
                max = value;
            }
        }
        return max;
    }

    public static float range(float min, float max) {
        return max - min;
    }
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        System.out.print("Enter the number of values you want to store: ");
        int num = input.nextInt();
        float[] values = new float[num];
        for (int i = 0; i < num; i++) {
            System.out.print("Enter the " + (i + 1) + " floating-point value: ");
            values[i] = input.nextFloat();
        }
        System.out.println("The average of the values is " + average(values, num));
        float min = smallest(values, num);
        System.out.println("The smallest of the values is " + min);
        float max = largest(values, num);
        System.out.println("The largest of the values is " + max);
        System.out.println("The range is " + range(min, max));
    }
}