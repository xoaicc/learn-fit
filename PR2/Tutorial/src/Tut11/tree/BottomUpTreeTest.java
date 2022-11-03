package Tut11.tree;

import Tut11.tree.bottomup.Tree;

public class BottomUpTreeTest {
    public static void main(String[] args) {
        Tree t = createTree();

        boolean repOk = t.repOK();
        if (repOk)
            System.out.printf("complete tree: %n%s%n%n", t);

        System.out.println("valid: " + repOk);
    }

    /**
     * @effects
     *
     */
    public static Tree createTree() {
        Tree t4 = new Tree(new Node<>(4)), t5 = new Tree(new Node<>(5));

        Tree t8 = new Tree(new Node<>(8)), t9 = new Tree(new Node<>(9)),
                t7 = new Tree(new Node<>(7), t8, t9);

        Tree t11 = new Tree(new Node<>(11)),
                t12 = new Tree(new Node<>(12)),
                t10 = new Tree(new Node<>(10), t11, t12);

        Tree t3 = new Tree(new Node<>(3), t4, t5),
                t6 = new Tree(new Node<>(6), t7),
                t2 = new Tree(new Node<>(2), t3, t6),
                t1 = new Tree(new Node<>(1), t2, t10);

        return t1;
    }
}
