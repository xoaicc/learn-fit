package lect11.simple;

public class Node {
    int label;

    public Node(int label) {
        this.label = label;
    }

    @Override
    public String toString() {
        return Integer.toString(label);
    }
}
