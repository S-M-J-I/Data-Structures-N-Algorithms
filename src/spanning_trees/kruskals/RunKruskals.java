package spanning_trees.kruskals;

import java.util.ArrayList;
import java.util.List;

public class RunKruskals {

    public static void main(String[] args) {
        Vertex A = new Vertex("A");
        Vertex B = new Vertex("B");
        Vertex C = new Vertex("C");

        List<Vertex> vertices = new ArrayList<>();
        vertices.add(A);
        vertices.add(B);
        vertices.add(C);

        List<Edge> edgeList = new ArrayList<>();
        edgeList.add(new Edge(3, vertices.get(0), vertices.get(1))); // A - B
        edgeList.add(new Edge(2, vertices.get(0), vertices.get(2))); // A - C
        edgeList.add(new Edge(5, vertices.get(1), vertices.get(2))); // B - C

        Kruskals algorithm = new Kruskals();
        algorithm.run(vertices, edgeList);
    }

}
