package Tut11.tree;

import utils.DomainConstraint;

/**
 * @overview
 *  Represents a binary, directed edge.
 * @attributes
 *  src  Node
 *  tgt  Node
 *
 * @abstract_properties
 *  mutable(src)=true /\ optional(src) = false /\ 
 *  mutable(tgt)=true /\ optional(tgt) = false
 *
 */
public class Edge {
    @DomainConstraint(type = "Node", mutable = true, optional = false)
    private Node src;
    @DomainConstraint(type = "Node", mutable = true, optional = false)
    private Node tgt;

    /**
     * @requires src != null /\ tgt != null
     * @effects
     *   initialise this as Edge(src,tgt)
     */
    public Edge(Node src, Node tgt) {
        this.src = src;
        this.tgt = tgt;
    }

    /**
     * @requires src != null
     * @effects
     *   sets this.src = src
     */
    public void setSrc(Node src) {
        if (src != null) {
            this.src = src;
        }
    }

    /**
     * @effects
     *   return src
     */
    public Node getSrc() {
        return src;
    }

    /**
     * @requires tgt != null
     * @effects
     *   sets this.tgt = tgt
     */
    public void setTgt(Node tgt) {
        if (tgt != null) {
            this.tgt = tgt;
        }
    }

    /**
     * @effects
     *  return tgt;
     */
    public Node getTgt() {
        return tgt;
    }

    /**
     * @effects
     *  if n.equals(src)
     *    return true
     *  else
     *    return false
     */
    public boolean hasSrc(Node n) {
        if (n == null) return false;

        return (src.equals(n));
    }

    /**
     * @effects
     *  if n.equals(tgt)
     *    return true
     *  else
     *    return false
     */
    public boolean hasTgt(Node n) {
        if (n == null) return false;

        return (tgt.equals(n));
    }

    @Override
    public String toString() {
        return toString(false);
    }

    public String toString(boolean full) {
        if (full)
            return "Edge(" + src.getLabel() + "," + tgt.getLabel() + ")";
        else
            return "(" + src.getLabel() + "," + tgt.getLabel() + ")";
    }

    @Override
    public boolean equals(Object o) {
        if (o == null || !(o instanceof Edge))
            return false;

        Edge e = (Edge) o;

        return e.src.equals(src) && e.tgt.equals(tgt);
    }
}
