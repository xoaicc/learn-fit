package lect11.simple;

import java.util.List;

public class DemoGetChildren {
    public static void main(String[] args) {
        // create a tree
        Node n1 = new Node(1), n2 = new Node(2), n3 = new Node(3);
        Node n4 = new Node(4), n5 = new Node(5), n6 = new Node(6);
        Node n7 = new Node(7), n8 = new Node(8), n9 = new Node(9);
        Node n10 = new Node(10), n11 = new Node(11), n12 = new Node(12);
        Tree t = new Tree(n1);
        // make n2 and n10 children of n1
        t.addNode(n1, n2);
        t.addNode(n1, n10);
        // continue building the tree
        t.addNode(n2, n3);
        t.addNode(n2, n6);
        t.addNode(n3, n4);
        t.addNode(n3, n5);
        t.addNode(n6, n7);
        t.addNode(n7, n8);
        t.addNode(n7, n9);
        t.addNode(n10, n11);
        t.addNode(n10, n12);

        List<Node> children = t.getChildren(n1);
        System.out.println("Children of n1" + children);

        System.out.println("Parent of n1: " + t.getParent(n1));
        System.out.println("Parent of n6: " + t.getParent(n6));

        System.out.println("Count(t.root): " + t.count(t.root));
        System.out.println("Count(n2): " + t.count(n2));
        System.out.println("Count(n6's parent): " + t.count(t.getParent(n6)));
    }
}
