package strongly_connected_components.kosaraju;

import java.util.ArrayList;
import java.util.List;

public class Graph {
    private List<Vertex> vertices;
    private List<Edge> edges;

    public Graph() {
        this.vertices = new ArrayList<>();
        this.edges = new ArrayList<>();
    }

    public Graph(List<Vertex> vertices, List<Edge> edges) {
        this.vertices = vertices;
        this.edges = edges;
    }

    public List<Vertex> getVertices() {
        return vertices;
    }

    public void setVertices(List<Vertex> vertices) {
        this.vertices = vertices;
    }

    public List<Edge> getEdges() {
        return edges;
    }

    public void setEdges(List<Edge> edges) {
        this.edges = edges;
    }

    public Graph transposeGraph() {
        Graph transpose = new Graph();

        List<Vertex> transposeVertices = new ArrayList<>(this.vertices);

        for(Edge edge : this.edges) {
            /** Reverse the edges */
            Vertex target = edge.getTargetVertex();
            Vertex start = edge.getStartVertex();
            int indexOfEdge = transposeVertices.indexOf(target);
            transposeVertices.get(indexOfEdge).addNeighbours(start);
        }

        transpose.setVertices(transposeVertices);

        return transpose;
    }

}
