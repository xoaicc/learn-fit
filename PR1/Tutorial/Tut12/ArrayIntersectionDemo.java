package PR1Tutorial.Tut12;

import java.util.HashSet;
import java.util.Scanner;

class ArrayIntersectionDemo {
    static HashSet<Integer> intersect (HashSet<Integer> A, HashSet<Integer> B) {
        HashSet<Integer> C = new HashSet<Integer>();
        if (A.size() < B.size()) for (int x : A) {
            if (B.contains(x)) C.add(x);
        }
        else for (int y : B) if (A.contains(y)) C.add(y);
        return C;
    }

    public static void main (String[] args) {
        HashSet<Integer> A = new HashSet<Integer>();
        HashSet<Integer> B = new HashSet<Integer>();

        Scanner input = new Scanner(System.in);
        System.out.print("Enter integer set A: ");
        String set1 = input.nextLine();
        System.out.print("Enter integer set B: ");
        String set2 = input.nextLine();
        input.close();

        for (String i : set1.split(" ")) A.add(Integer.parseInt(i));
        for (String i : set2.split(" ")) B.add(Integer.parseInt(i));

        System.out.print("The intersection set C is: " + intersect(A, B).toString());
    }
}