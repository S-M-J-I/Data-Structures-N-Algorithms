package spanning_trees.kruskals;

public class Edge implements Comparable<Edge>{

    private double weight;
    private Vertex startVertex;
    private Vertex targetVertex;

    public Edge(double weight, Vertex startVertex, Vertex targetVertex) {
        this.weight = weight;
        this.startVertex = startVertex;
        this.targetVertex = targetVertex;
    }

    /**
     * We will need to sort the list of Edges in ascending order.
     * Therefore, we will implement a Comparable class for Edge
     * And compare and return the minimum of the comparison between this object and the object we are comparing to
     * */
    @Override
    public int compareTo(Edge o) {
        return Double.compare(this.weight, o.getWeight());
    }

    public double getWeight() {
        return weight;
    }

    public void setWeight(double weight) {
        this.weight = weight;
    }

    public Vertex getStartVertex() {
        return startVertex;
    }

    public void setStartVertex(Vertex startVertex) {
        this.startVertex = startVertex;
    }

    public Vertex getTargetVertex() {
        return targetVertex;
    }

    public void setTargetVertex(Vertex targetVertex) {
        this.targetVertex = targetVertex;
    }
}
