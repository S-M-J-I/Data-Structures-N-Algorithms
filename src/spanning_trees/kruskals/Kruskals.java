package spanning_trees.kruskals;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Kruskals {

    private double fullCost = 0;

    public void run(List<Vertex> vertices, List<Edge> edges) {

        DisjointSet disjointSet = new DisjointSet(vertices);
        List<Edge> MST = new ArrayList<>();

        Collections.sort(edges);


        for(Edge edge : edges) {
            Vertex u = edge.getStartVertex();
            Vertex v = edge.getTargetVertex();

            if( disjointSet.FIND(u.getNode()) != disjointSet.FIND(v.getNode()) ) {
                MST.add(edge);
                fullCost += edge.getWeight();
                disjointSet.UNION(u.getNode(), v.getNode());
            }
        }

        for(Edge edge : MST) {
            System.out.println(edge.getStartVertex()+"--"+edge.getTargetVertex());
        }
        System.out.println();

        System.out.println("Minimum Cost : " + fullCost);

    }
}
