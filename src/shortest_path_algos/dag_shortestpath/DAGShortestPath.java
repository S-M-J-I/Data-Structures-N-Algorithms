package shortest_path_algos.dag_shortestpath;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Stack;

public class DAGShortestPath {

    static class Vertex{
        private String name;
        private Vertex predecessor;
        private boolean visited;
        private List<Edge> adjList;
        private double distance = Double.MAX_VALUE;

        Vertex(String name){
            this.name = name;
            this.visited = false;
            this.adjList = new ArrayList<>();
        }

        void addEdges(Edge ...edges){
            for (Edge edge : edges){
                this.adjList.add(edge);
            }
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

        public List<Edge> getAdjList() {
            return adjList;
        }

        public void setAdjList(List<Edge> adjList) {
            this.adjList = adjList;
        }

        public double getDistance() {
            return distance;
        }

        public void setDistance(double distance) {
            this.distance = distance;
        }

        @Override
        public String toString() {
            return this.name;
        }

    }


    static class Edge{

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

    static class TopologicalOrdering{
        private Stack<Vertex> stack;

        public TopologicalOrdering() {
            this.stack = new Stack<>();
        }

        public void topSort(List<Vertex> vertexList){
            for(Vertex v : vertexList){
                if(!v.isVisited()){
                    DFS(v);
                }
            }
        }

        public void DFS(Vertex vertex){

            for(Edge e : vertex.adjList){
                if(!e.getTargetVertex().isVisited()){
                    e.getTargetVertex().setVisited(true);
                    DFS(e.getTargetVertex());
                }
            }

            this.stack.push(vertex);
        }

        public Stack<Vertex> getTopOrdering(){
            Collections.reverse(this.stack);
            return this.stack;
        }

    }

    static class AcyclicShortestPath{
        public void shortestPath(List<Vertex> vertexList, Vertex start, Vertex target){
            start.setDistance(0);
            TopologicalOrdering top = new TopologicalOrdering();
            top.topSort(vertexList);

            Stack<Vertex> stack = top.getTopOrdering();

            for(Vertex actualVertex : stack){

                for(Edge e : actualVertex.getAdjList()){
                    Vertex u = e.getStartVertex();
                    Vertex v = e.getTargetVertex();

                    double newDistance = u.getDistance() + e.getWeight();

                    if(newDistance < v.getDistance()){
                        v.setDistance(newDistance);
                        v.setPredecessor(actualVertex);
                    }
                }

                /** Continue from tomorrow */

            }
        }
    }



    public static void main(String[] args) {

    }
}
