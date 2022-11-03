package Tut11.tree.topdown;

import java.util.Vector;

import Tut11.tree.Edge;
import Tut11.tree.Node;
import utils.DomainConstraint;

/**
 * @overview A tree is a set of nodes that are connected to to each other by 
 *    edges such that one node, called the root, is connected to some nodes, 
 *    each of these nodes is connected to some other nodes that have not been 
 *    connected, and so on.  
 *
 *    <p>The following is a <b>top-down</b> recursive design that incrementally build a 
 *    tree by adding leaf nodes.
 *
 * @attributes
 *   root    Node                 
 *   nodes   Set<Node>   Vector<Node>           
 *   edges   Set<Edge>   Vector<Edge>
 *
 * @object A typical tree T is the tuple <r,N,E>, where 
 *   root(r), nodes(N), and edges(E).  
 *
 *   <p>Trees are defined recursively as follows: 
 *   Basis
 *    For any node r, T = <r,{r},{}> is a tree. 
 *   Induction
 *    For all node n and tree T' and for some node p in T':
 *    n is not in T' -> 
 *      T = <T'.root, T'.nodes+{n}, T'.edges+{edge(p,n)}> is a tree 
 *
 * @abstract_properties <pre>
 *    mutable(root)=false /\ optional(root)=false /\ 
 *    mutable(nodes)=true /\ optional(nodes)=false /\
 *    mutable(edges)=true /\ optional(edges)=true /\ 
 *    root in nodes /\ 
 *    for any n,m in nodes:
 *      (exists exactly one sequence edge(n,n1),edge(n1,n2),...,edge(nk,m))
 *  </pre>
 *
 */
public class Tree {
    @DomainConstraint(type = "Node", mutable = false, optional = false)
    private Node<?> root;
    @DomainConstraint(type = "Vector", mutable = true, optional = false)
    private Vector<Node<?>> nodes;
    @DomainConstraint(type = "Vector", mutable = true, optional = true)
    private Vector<Edge> edges;

    // constructors

    /**
     * @requires r != null
     * @effects initialise this as <r,{r},{}>
     */
    public Tree(Node<?> r) {
        // single-node tree
        this.root = r;
        nodes = new Vector<>();
        nodes.add(r);
    }

    /**
     * @requires <tt>n != null /\ parent != null</tt>
     * @effects
     *  if <tt>parent</tt> is in <tt>nodes</tt>
     *    add <tt>n</tt> as a child of <tt>parent</tt>, i.e. <tt>edge(parent,n)</tt>
     *    return true
     *  else
     *    return false
     */
    public boolean addNode(Node<?> parent, Node<?> n) {
        // check that parent is in nodes
        boolean found = false;
        for (Node<?> node : nodes) {
            if (node.equals(parent)) {
                found = true;
                break;
            }
        }

        if (!found) {
            return false;
        }

        // add node
        nodes.add(n);

        // create an edge <parent,n>
        if (edges == null)
            edges = new Vector<>();

        Edge e = new Edge(parent, n);
        edges.add(e);
        return true;
    }


    /**
     * A recursive procedure to count the number of nodes in a subtree
     * rooted at n.
     *
     * @effects
     *  if n is a leaf
     *    return 1
     *  else
     *    return the number of nodes in the sub-tree rooted at n
     */
    public int count(Node<?> n) {
        int count = 1; // includes n
        if (edges != null) {
            for (Edge e : edges) {
                if (e.hasSrc(n)) {
                    count += count(e.getTgt());
                }
            }
        }

        return count;
    }

    /**
     * @effects
     *  return a structured textual representation of this
     */
    @Override
    public String toString() {
        StringBuffer sb = new StringBuffer();
        toString(sb, 0, root);
        return sb.toString();
    }

    /**
     * This is a recursive operation that incrementally constructs the string representation of the
     * tree/subtree rooted at n.
     *
     * @effects
     *  update <tt>sb</tt> with the string representation of the sub-tree
     *  rooted at <tt>n</tt>.
     */
    private void toString(StringBuffer sb, int level, Node<?> n) {
        // bol(n)
        if (level > 0) {
            sb.append("\n");
            sb.append("|");
        }

        // spaceMarkers(n)
        for (int i = 0; i < level; i++) {
            sb.append("-");
        }

        sb.append(n); // n.toString

        if (edges != null) {
            level++;
            for (Edge e : edges) {
                if (e.hasSrc(n)) {  // found a child of n
                    toString(sb, level, e.getTgt());
                }
            }
        }
    }

    /**
     * @effects
     * if this satisfies abstract properties
     *  return true
     * else
     *  return false
     */
    public boolean repOK() {
        // root != null
        if (root == null) {
            System.err.println("Tree.repOK: root is null");
            return false;
        }

        // nodes != null
        if (nodes == null) {
            System.err.println("Tree.repOK: nodes is not initialised");
            return false;
        }


        // root in nodes
        boolean hasRoot = false;
        for (Node<?> n : nodes) {
            if (n.equals(root)) {
                hasRoot = true;
                break;
            }
        }

        if (!hasRoot) {
            System.err.println("Tree.repOK: tree does not contain root");
            return false;
        }

        //  for all n, m in nodes. n neq m
        Node<?> n;
        Edge eobj;
        for (int i = 0; i < nodes.size(); i++) {
            n = nodes.get(i);
            for (int j = i + 1; j < nodes.size(); j++) {
                if (n.equals(nodes.get(j))) {
                    System.err.println("Tree.repOK: duplicate node: " + n);
                    return false;
                }
            }
        }

        //  for all e, f in edges. e neq f
        if (edges != null) {
            for (int i = 0; i < edges.size(); i++) {
                eobj = edges.get(i);
                for (int j = i + 1; j < edges.size(); j++) {
                    if (eobj.equals(edges.get(j))) {
                        System.err.println("Tree.repOK: duplicate edge: " + eobj);
                        return false;
                    }
                }
            }
        }

        // check: every non-root node has exactly one parent
        Node<?> parent;
        for (Node<?> o : nodes) {
            parent = null;
            if (o != root) {
                for (Edge e : edges) {
                    if (e.hasTgt(o)) {
                        if (parent == null) {
                            parent = e.getSrc();
                        } else {
                            // invalid: two parents
                            System.err.println("Tree.repOK: node has two parents: " + o + " -> (" + parent + "," + e.getSrc() + ")");
                            return false;
                        }
                    }
                }

                if (parent == null) {
                    // invalid: no parents
                    System.err.println("Tree.repOK: node has no parents: " + o);
                    return false;
                }
                // o has one parent
            }
        }

        // all non-root nodes are reachable from n (i.e. tree is connected)
        // walk the tree from the root and count the number of nodes
        // check that this number is the same as cardinality of nodes
        int count = count(root);
        if (count != nodes.size()) {
            System.err.println("Tree.repOK: tree is not connected");
            return false;
        }
        return true;
    }
} // end Tree