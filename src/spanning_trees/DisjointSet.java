package spanning_trees;

import spanning_trees.kruskals.Node;
import spanning_trees.kruskals.Vertex;

import java.util.ArrayList;
import java.util.List;

public class DisjointSet {

    private int nodeCount; /** track how many nodes do we have */
    private int setCount; /** track how many sets do we have */
    private List<Node> representatives;

    public DisjointSet(List<Vertex> vertices) {
        this.representatives = new ArrayList<>(vertices.size());
        this.nodeCount = 0;
        this.setCount = 0;

        makeSets(vertices);
    }

    /** Iterate through all the vertices in the graph and makeSet() */
    private void makeSets(List<Vertex> vertices) {
        for(Vertex v : vertices) {
            makeSet(v);
        }
    }


    /**
     * We create a new node with id 0,
     * and assign it's rank as the current size of the representatives list
     * we then add the node as a representative
     * we increase the count of nodes and dj sets
     * */
    private void makeSet(Vertex v) {
        Node node = new Node(0, representatives.size(), null);
        v.setNode(node);
        this.representatives.add(node);
        this.setCount++;
        this.nodeCount++;
    }

    /** Find the parent of a node */
    public int FIND(Node node) {
        // take a curr node to traverse the tree
        Node curr = node;

        // keep shifting curr to it's parent until a node's parent is NULL
        while (curr.getParent() != null) {
            curr = curr.getParent();
        }
        // at this stage, curr should be as the representative of the set

        // create a root and make it point to curr
        Node rootNode = curr;
        // and assign the node as the curr
        curr = node;

        /** PATH COMPRESSION */
        // and while curr != root,
        while (curr != rootNode) {
            // store the curr parent in a node
            Node temp = curr.getParent();
            // make curr node point to the root (note root has the representative value)
            curr.setParent(rootNode);
            curr = temp; // then shift curr to it's parent
        }

        // return the root's ID
        return rootNode.getId();
    }


    public void UNION(Node a, Node b) {
        int repA = FIND(a);
        int repB = FIND(b);

        if(repA == repB) {
            return; // ignore because same set
        }

        Node rootA = this.representatives.get(repA);
        Node rootB = this.representatives.get(repB);

        if(rootA.getRank() > rootB.getRank()) {
            rootB.setParent(rootA);
        } else if (rootA.getRank() < rootB.getRank()) {
            rootA.setParent(rootB);
        } else {
            rootA.setParent(rootB);
            rootA.setRank(rootA.getRank()+1);
        }

        this.setCount--;

    }

    public int getSetCount() {
        return setCount;
    }
}
