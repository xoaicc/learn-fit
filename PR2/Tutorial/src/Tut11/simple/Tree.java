package lect11.simple;

import java.util.ArrayList;
import java.util.List;

public class Tree {
    Node root;
    List<Node> nodes;
    List<Edge> edges;

    public Tree(Node n) {
        root = n;
        nodes = new ArrayList<>();
        nodes.add(n);
        edges = new ArrayList<>();
    }

    public void addNode(Node p, Node n) {
        nodes.add(n);
        edges.add(new Edge(p, n));
    }

    public int count(Node n) {
        int count = 1;
        for (Node c : getChildren(n)) {
            count += count(c); // recursive call
        }
        return count;
    }

    public List<Node> getChildren(Node n) {
        List<Node> children = new ArrayList<>();
        for (Edge e : edges) {
            if (e.src == n) {
                children.add(e.tgt);
            }
        }
        return children;
    }

    public Node getParent(Node n) {
        for (Edge e : edges) {
            if (e.tgt == n) return e.src;
        }
        return null;
    }
}
