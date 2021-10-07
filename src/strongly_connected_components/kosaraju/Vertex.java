package strongly_connected_components.kosaraju;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Vertex {
    private int id;
    private String name;
    private boolean visited;
    private List<Vertex> adjList;
    private int componentID;

    public Vertex(int id, String name) {
        this.id = id;
        this.name = name;
        this.visited = false;
        this.adjList = new ArrayList<>();
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
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

    public List<Vertex> getAdjList() {
        return adjList;
    }

    public void setAdjList(List<Vertex> adjList) {
        this.adjList = adjList;
    }

    public int getComponentID() {
        return componentID;
    }

    public void setComponentID(int componentID) {
        this.componentID = componentID;
    }

    public void addNeighbours(Vertex ...vertices) {
        adjList.addAll(Arrays.asList(vertices));
    }

    @Override
    public String toString() {
        return this.name;
    }

}
