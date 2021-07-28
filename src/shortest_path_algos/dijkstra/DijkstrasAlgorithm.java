package shortest_path_algos.dijkstra;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.PriorityQueue;

public class DijkstrasAlgorithm {

    /** Vertex class */
    static private class Vertex implements Comparable<Vertex>{

        /** name, a list of edges it is connected to, visited, the predecessor vertex, the distance set to an infinite value */
        private String name;
        private List<Edge> adjEdgeList;
        private boolean visited;
        private Vertex predecessor;
        private double distance = Double.MAX_VALUE;

        public Vertex(String name) {
            this.name = name;
            this.visited = false;
            this.adjEdgeList = new ArrayList<>();
        }

        /** add neighbours to the edge list */
        public void addNeighbours(Edge ...edges){
            for(Edge edge : edges){
                this.adjEdgeList.add(edge);
            }
        }

        // used to compare the two vertices, prefers the smaller one.
        @Override
        public int compareTo(Vertex o) {
            return Double.compare(this.distance, o.getDistance());
        }

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }

        public List<Edge> getAdjEdgeList() {
            return adjEdgeList;
        }

        public void setAdjEdgeList(List<Edge> adjEdgeList) {
            this.adjEdgeList = adjEdgeList;
        }

        public boolean isVisited() {
            return visited;
        }

        public void setVisited(boolean visited) {
            this.visited = visited;
        }

        public Vertex getPredecessor() {
            return predecessor;
        }

        public void setPredecessor(Vertex predecessor) {
            this.predecessor = predecessor;
        }

        public double getDistance() {
            return distance;
        }

        public void setDistance(double distance) {
            this.distance = distance;
        }

        @Override
        public String toString(){
            return this.name;
        }

    }

    static private class Edge{

        /** Edge will have a weight, a start and end vertex */
        private double weight;
        private Vertex startVertex;
        private Vertex targetVertex;

        public Edge(double weight, Vertex startVertex, Vertex targetVertex) {
            this.weight = weight;
            this.startVertex = startVertex;
            this.targetVertex = targetVertex;
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


    /** Computing the path */
    public static void computePath(Vertex srcVertex){

        /**
         * set the distance of the src vertex to 0
         * take a priority queue (here the compareTo func in vertex will choose the lesser value, creating a min priority queue)
         * add it to the src vertex
         * */
        srcVertex.setDistance(0);
        PriorityQueue<Vertex> priorityQueue = new PriorityQueue<>();
        priorityQueue.add(srcVertex);

        // while the queue is not empty
        while (!priorityQueue.isEmpty()){

            /**
             *  remove the least value element from the priority queue
             *  for all edges in the edge-list of the vertex removed,
             *  calculate the distance from the removed vertex to each of its neighbouring vertices
             *  if a distance is found that is better (lower than the distance)
             *  then update the distance
             *  remove the vertex from the queue
             *  set the new distance
             *  set the predecessor of the vertex to the vertex removed and add it to the priority queue
             * */
            Vertex actualVertex = priorityQueue.poll();
            for(Edge e : actualVertex.getAdjEdgeList()){
                Vertex v = e.getTargetVertex();

                double newDistance = actualVertex.getDistance() + e.getWeight();

                // if the new distance calculated is less than (a better choice) than the previous distance
                if(newDistance < v.getDistance()){
                    priorityQueue.remove(v);
                    v.setDistance(newDistance);
                    v.setPredecessor(actualVertex);
                    priorityQueue.add(v);
                }
            }

        }

    }

    /** Return list of vertices*/
    public static List<Vertex> getShortestPathTo(Vertex targetVertex){

        /**
         *  take a list of vertices
         *  get all the predecessors and add them to the list
         *  reverse the list
         * */
        List<Vertex> shortestPath = new ArrayList<>();

        for(Vertex vertex = targetVertex; vertex != null; vertex = vertex.getPredecessor()){
            shortestPath.add(vertex);
        }

        Collections.reverse(shortestPath);

        return shortestPath;
    }

    public static void main(String[] args) {

        Vertex v0 = new Vertex("A");
        Vertex v1 = new Vertex("B");
        Vertex v2 = new Vertex("C");

        v0.addNeighbours(new Edge(1, v0, v1));
        v0.addNeighbours(new Edge(3, v0, v2));
        v1.addNeighbours(new Edge(1, v1, v2));

        computePath(v0);
        System.out.println(getShortestPathTo(v2));

    }


}
