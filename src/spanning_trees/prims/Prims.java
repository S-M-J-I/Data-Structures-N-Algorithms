package spanning_trees.prims;

import java.util.ArrayList;
import java.util.List;
import java.util.PriorityQueue;

public class Prims {

    private List<Vertex> unvisitedVertices;
    private List<Edge> MST;
    private PriorityQueue<Edge> edgeHeap;
    private double fullCost = 0;

    public Prims(List<Vertex> unvisitedVertices) {
        this.unvisitedVertices = unvisitedVertices;
        this.MST = new ArrayList<>();
        edgeHeap = new PriorityQueue<>();
    }

    public void run(Vertex vertex) {

        // remove the first vertex from the unvisited list
        this.unvisitedVertices.remove(vertex);

        // while all vertices are not yet visited
        while (!unvisitedVertices.isEmpty()) {
            // for all the edges in the adjacency list
            for(Edge edge : vertex.getAdj()) {
                // if the target vertex of the current edge is not visited
                if(this.unvisitedVertices.contains(edge.getTargetVertex())){
                    // add it to the priority queue
                    edgeHeap.add(edge);
                }
            }

            // remove the minimum edge
            Edge minEdge = edgeHeap.remove();

            //
            this.MST.add(minEdge);
            this.fullCost += minEdge.getWeight();

            vertex = minEdge.getTargetVertex();
            this.unvisitedVertices.remove(vertex);
        }

        for(Edge edge : MST) {
            System.out.println(edge.getStartVertex() + "--" + edge.getTargetVertex());
        }

        System.out.println("Minimum cost : " + fullCost);
    }
}
