package graphs;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

class Vertex{
    protected String vertexName;
    protected boolean visited;
//    List of neighbours
    protected List<Vertex> neighbours;

    public Vertex(String vertexName) {
        this.vertexName = vertexName;
        this.neighbours = new ArrayList<>();
    }

    public void addNeighbour(Vertex... v){
//        for all vertices passed through the parameter, add the vertices
        for(Vertex addVertex : v){
            this.neighbours.add(addVertex);
        }
    }

}

class BFS {

//    Breadth-Firs Search
    public void bfs(Vertex rootVertex){
//        Take a queue, this is used to store and query the vertices who we will be searching for
        Queue<Vertex> queue = new LinkedList<>();
//        take root visited to be true
        rootVertex.visited = true;
//        add that to the queue
        queue.add(rootVertex);

//        while the queue is not empty
        while (!queue.isEmpty()){
//            dequeue
            Vertex actual = queue.remove();
            System.out.print(actual.vertexName+" ");

//            search all the vertices of the dequeued vertex
            for (Vertex v : actual.neighbours){
//                if the neighbour vertices are not visited
                if(!v.visited) {
//                    changed to true
                    v.visited = true;
//                    add that to the queue
                    queue.add(v);
                }
            }
        }
    }

}


public class BreadthFirstSearch {

    public static void main(String[] args) {
        BFS example = new BFS();

        Vertex v1 = new Vertex("A");
        Vertex v2 = new Vertex("B");
        Vertex v3 = new Vertex("C");
        Vertex v4 = new Vertex("D");
        Vertex v5 = new Vertex("E");
        Vertex v6 = new Vertex("F");
        Vertex v7 = new Vertex("G");
        Vertex v8 = new Vertex("H");

        v1.addNeighbour(v2,v6,v7);
        v2.addNeighbour(v3,v4);
        v7.addNeighbour(v8);
        v4.addNeighbour(v5);

        example.bfs(v1);

        /**
         * This is the level order traversal of a tree
         * */

    }


}
