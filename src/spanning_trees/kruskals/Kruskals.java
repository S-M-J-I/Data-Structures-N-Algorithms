package spanning_trees.kruskals;

import spanning_trees.DisjointSet;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.PriorityQueue;

public class Kruskals {

    public void run(List<Vertex> vertices, List<Edge> edges) {

        DisjointSet disjointSet = new DisjointSet(vertices);
        List<Edge> MST = new ArrayList<>();

        Collections.sort(edges);


        for(Edge edge : edges) {
            Vertex u = edge.getStartVertex();
            Vertex v = edge.getTargetVertex();

            if( disjointSet.FIND(u.getNode()) != disjointSet.FIND(v.getNode()) ) {
                MST.add(edge);
                disjointSet.UNION(u.getNode(), v.getNode());
            }
        }

        for(Edge edge : MST) {
            System.out.print(edge.getStartVertex()+" "+edge.getTargetVertex()+" -- ");
        }

    }
}
