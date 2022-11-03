package Tut11.tree.bottomup;

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
 *    <p>The following is a <b>bottom-up</b> recursive tree design that incrementally 
 *    builds a new tree by adding roots.
 *
 * @attributes
 *   root    Node                 
 *   nodes   Set<Node>            Vector<Node>           
 *   edges   Set<Edge>   Vector<Edge>
 *
 * @object A typical tree T is the tuple <r,N,E>, where 
 *   root(r), nodes(N), and edges(E).  
 *
 *   <p>Trees are defined recursively as follows: 
 *   Basis
 *    For any node r, T = <r,{r},{}> is a tree. 
 *   Induction
 *    For all natural number k >= 1 and k trees T1, T2,...,Tk 
 *    and for all node r:
 *    r is not in T1,...,Tk -> 
 *      T = <r, 
 *      T1.nodes+...+Tk.nodes+{r}, 
 *      {edge(r,T1.root),...,edge(r,Tk.root)} +T1.edges+...+Tk.edges> is a tree 
 *
 * @abstract_properties <pre>
 *    mutable(root)=false /\ optional(root)=false /\ 
 *    mutable(nodes)=true /\ optional(nodes)=false /\
 *    mutable(edges)=true /\ optional(edges)=true /\ 
 *    root in nodes /\ 
 *    for all n in nodes.
 *      // (i) acyclicity
 *      (exists p in nodes. parent(n)=p /\ 
 *       for all p, q in nodes. (parent(n)=p /\ parent(n)=q -> p=q)) /\
 *       // (ii) connectedness
 *    for all n in nodes.d
 *      (n != root -> exists a sequence of edges from root to n)
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
     * @requires r != null /\ trees.length >= 1 /\
     *   for all t in trees. r not in t.nodes
     *
     * @effects initialise this as a tree T =
     *     <r,
     *     T1.nodes+...+Tk.nodes+{r},
     *     {edge(r,T1.root),...,edge(r,Tk.root)} +T1.edges+...+Tk.edges>,
     *     where Tis are in <tt>trees</tt>
     */
    public Tree(Node<?> r, Tree... trees) {
        this(r);
        edges = new Vector<>();
        // this.r = r /\ this.nodes = {r} /\ this.edges = {}
        Edge e;
        for (Tree t : trees) {
            nodes.addAll(t.nodes);
            // this.nodes = this.nodes + t.nodes
            e = new Edge(r, t.root);
            edges.add(e);
            // this.edges = this.edges + {edge(r,t.root)}
            if (t.edges != null)
                edges.addAll(t.edges);
        }
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
                if (e.hasSrc(n)) {  // e[0] is parent
                    count += count(e.getTgt()); // e[1]: child of n (recursive call)
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
     * @modifies sb
     *
     * @effects
     *  update <tt>sb</tt> with the string representation of the sub-tree
     *  rooted at <tt>n</tt>.
     */
    private void toString(StringBuffer sb, int level, Node<?> n) {
        // bol(n.level)
        if (level > 0) {
            sb.append("\n");
            sb.append("|");
        }

        // spaceMarkers(n.level)
        for (int i = 0; i < level; i++) {
            sb.append("-");
        }

        sb.append(n);

        if (edges != null) {
            level++;
            for (Edge e : edges) {
                if (e.hasSrc(n)) {  // found a child of n
                    // recursive call to next level
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