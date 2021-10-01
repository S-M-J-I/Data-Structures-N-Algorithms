package spanning_trees.prims;

import java.util.ArrayList;
import java.util.List;

public class Vertex {

    private String name;
    private boolean visited;
    private Vertex prevVertex;
    private List<Edge> adj;

    public Vertex(String name) {
        this.name = name;
        this.adj = new ArrayList<>();
    }

    public void addEdge(Edge edge) {
        adj.add(edge);
    }

    @Override
    public String toString() {
        return this.name;
    }


    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public boolean isVisited() {
        return visited;
    }

    public void setVisited(boolean visited) {
        this.visited = visited;
    }

    public Vertex getPrevVertex() {
        return prevVertex;
    }

    public void setPrevVertex(Vertex prevVertex) {
        this.prevVertex = prevVertex;
    }

    public List<Edge> getAdj() {
        return adj;
    }

    public void setAdj(List<Edge> adj) {
        this.adj = adj;
    }
}
