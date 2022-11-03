package Tut11.tree;

import Tut11.tree.topdown.Tree;

public class TopDownTreeTest {
    public static void main(String[] args) {
        Node<Integer> n1 = new Node<>(1), n2 = new Node<>(2),
                n3 = new Node<>(3), n4 = new Node<>(4),
                n5 = new Node<>(5), n6 = new Node<>(6),
                n7 = new Node<>(7), n8 = new Node<>(8),
                n9 = new Node<>(9), n10 = new Node<>(10),
                n11 = new Node<>(11), n12 = new Node<>(12);

        Tree t = new Tree(n1);

        System.out.printf("tree(1): %n%s%n%n", t);

        boolean aok;
        aok = t.addNode(n1, n2);
        System.out.printf("addNode(1,2): %b%n", aok);

        t.addNode(n2, n3);
        t.addNode(n2, n6);

        System.out.printf("after adding 2, 3, 6: %n%s%n%n", t);

        t.addNode(n1, n10);
        t.addNode(n10, n11);
        t.addNode(n10, n12);

        System.out.printf("after adding 10, 11, 12: %n%s%n%n", t);

        t.addNode(n3, n4);
        t.addNode(n3, n5);

        System.out.printf("after adding 4, 5: %n%s%n%n", t);

        t.addNode(n6, n7);

        t.addNode(n7, n8);
        t.addNode(n7, n9);

        System.out.printf("after adding 7, 8, 9: %n%s%n%n", t);

        boolean repOk = t.repOK();
        if (repOk) {
            System.out.printf("complete tree: %n%s%n%n", t);
        }
        System.out.println("valid: " + repOk);
    }
}
