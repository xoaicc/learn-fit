package Tut11.tree;

import utils.DomainConstraint;

/**
 * @overview
 *  Represents a labelled node.
 *
 * @attributes
 *  label T
 *
 * @abstract_properties
 *  mutable(label)=true /\ optional(label) = false
 *
 */
public class Node<T> {
    @DomainConstraint(mutable = true, optional = false)
    private T label;

    /**
     * @requires label != null /\ label.length() > 0
     * @effects
     *  initialise this as Node(label)
     */
    public Node(T label) {
        this.label = label;
    }

    /**
     * @effects
     *  return label
     */
    public T getLabel() {
        return label;
    }

    /**
     * @requires label != null /\ label.length() > 0
     * @effects
     *  sets this.label = label
     */
    public void setLabel(T label) {
        this.label = label;
    }

    @Override
    public String toString() {
        return toString(false);
    }

    public String toString(boolean full) {
        if (full)
            return "Node(" + label + ")";
        else
            return label + "";
    }

    @Override
    public boolean equals(Object o) {
        if (o == null || !(o instanceof Node))
            return false;

        return ((Node) o).label.equals(label);
    }

    /**
     * This operation is added for use in a chapter exercise.
     *
     * @effects
     *  return the length of the string representation of this.label
     */
    public int getLabelLength() {
        return label.toString().length();
    }
}
