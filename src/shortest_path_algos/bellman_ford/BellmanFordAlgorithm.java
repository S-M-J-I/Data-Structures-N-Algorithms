package shortest_path_algos.bellman_ford;

import java.util.ArrayList;
import java.util.List;

public class BellmanFordAlgorithm {

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

    static class Vertex{
        private String name;
        private boolean visited;
        private double distance = Double.MAX_VALUE;
        private Vertex prevVertex;
        private List<Edge> adjList;

        public Vertex(String name) {
            this.name = name;
            this.adjList = new ArrayList<>();
            this.visited = false;
        }

        public void addNeighbour(Edge ...edges){
            for(Edge e : edges){
                this.adjList.add(e);
            }
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

        public double getDistance() {
            return distance;
        }

        public void setDistance(double distance) {
            this.distance = distance;
        }

        public Vertex getPrevVertex() {
            return prevVertex;
        }

        public void setPrevVertex(Vertex prevVertex) {
            this.prevVertex = prevVertex;
        }

        public List<Edge> getAdjList() {
            return adjList;
        }

        public void setAdjList(List<Edge> adjList) {
            this.adjList = adjList;
        }

        @Override
        public String toString() {
            return this.name;
        }
    }

    /** Algorithm class */
    static class BellManFord{

        /** Take lists for vertices and edges */
        private List<Edge> edgeList;
        private List<Vertex> vertices;

        public BellManFord(List<Edge> edgeList, List<Vertex> vertices) {
            this.edgeList = edgeList;
            this.vertices = vertices;
        }


        public void Bellman_Ford(Vertex src){

            src.setDistance(0);
            for(int i = 0 ; i < vertices.size()-1 ; ++i){

                for(Edge edge : edgeList){

                    /**
                     *  v-1 iterations -> we relax all edges
                     *  get the starting and ending edges
                     * */

                    Vertex u = edge.getStartVertex();
                    Vertex v = edge.getTargetVertex();

                    if(u.getDistance() == Double.MAX_VALUE){
                        /** if no change in distance, continue the process */
                        continue;
                    }

                    /** Calculate the new distance */
                    double newDistance = u.getDistance() + edge.getWeight();

                    /** Update the new distance if there's a lesser distance found */
                    if(newDistance < v.getDistance()){
                        v.setDistance(newDistance);
                        v.setPrevVertex(u);
                    }

                }


                /** for all edges in edgelist */
                for(Edge edge : edgeList){
                    /** if there's a change in the distance */
                    if(edge.getStartVertex().getDistance() != Double.MAX_VALUE){
                        /** and if there's a cycle */
                        if(hasCycle(edge)){
                            System.out.println("There has been a negative cycle detected");
                            return;
                        }
                    }
                }

            }

        }

        public boolean hasCycle(Edge edge){
            /** check if there is a better solution i.e. if the start vertex distance travelled is less than target vertex distance travelled */
            return edge.getStartVertex().getDistance() + edge.getWeight() < edge.getTargetVertex().getDistance();
        }

        public void shortestPathTo(Vertex target){
            if(target.getDistance() == Double.MAX_VALUE){
                System.out.println("No path from source to target");
            }

            Vertex actual = target;
            while (actual.getPrevVertex() != null){
                System.out.print("Actual - " + actual.getPrevVertex());
            }
        }
    }

    public static void main(String[] args) {

        List<Vertex> vertices = new ArrayList<>();

        vertices.add(new Vertex("A"));
        vertices.add(new Vertex("B"));
        vertices.add(new Vertex("C"));

        List<Edge> edgeList = new ArrayList<>();

        edgeList.add(new Edge(1, vertices.get(0), vertices.get(1)));
        edgeList.add(new Edge(1, vertices.get(0), vertices.get(2)));
        edgeList.add(new Edge(1, vertices.get(1), vertices.get(2)));

        BellManFord bellManFord = new BellManFord(edgeList, vertices);
        bellManFord.Bellman_Ford(vertices.get(0));
        bellManFord.shortestPathTo(vertices.get(0));

    }

}
