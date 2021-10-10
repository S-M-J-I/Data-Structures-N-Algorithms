package strongly_connected_components.tarjan;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Vertex {
    private String name;
    private List<Vertex> neighbourList;
    private Vertex predecessor;
    private boolean visited;
    private int lowLink;

    public Vertex(String name) {
        this.name = name;
        this.neighbourList = new ArrayList<>();
    }

    public void addNeighbour(Vertex ...vertices) {
        neighbourList.addAll(Arrays.asList(vertices));
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<Vertex> getNeighbourList() {
        return neighbourList;
    }

    public void setNeighbourList(List<Vertex> neighbourList) {
        this.neighbourList = neighbourList;
    }

    public Vertex getPredecessor() {
        return predecessor;
    }

    public void setPredecessor(Vertex predecessor) {
        this.predecessor = predecessor;
    }

    public boolean isVisited() {
        return visited;
    }

    public void setVisited(boolean visited) {
        this.visited = visited;
    }

    public int getLowLink() {
        return lowLink;
    }

    public void setLowLink(int lowLink) {
        this.lowLink = lowLink;
    }
}
