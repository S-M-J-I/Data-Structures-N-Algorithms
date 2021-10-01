package spanning_trees.kruskals;

import java.util.ArrayList;
import java.util.List;

public class RunKruskals {

    public static void main(String[] args) {
        Vertex A = new Vertex("A");
        Vertex B = new Vertex("B");
        Vertex C = new Vertex("C");
        Vertex D = new Vertex("D");
        Vertex E = new Vertex("E");
        Vertex F = new Vertex("F");
        Vertex G = new Vertex("G");
        Vertex H = new Vertex("H");

        List<Vertex> vertices = new ArrayList<>();
        vertices.add(A);
        vertices.add(B);
        vertices.add(C);
        vertices.add(D);
        vertices.add(E);
        vertices.add(F);
        vertices.add(G);
        vertices.add(H);

        List<Edge> edgeList = new ArrayList<>();
        edgeList.add(new Edge(3, vertices.get(0), vertices.get(1)));
        edgeList.add(new Edge(2, vertices.get(0), vertices.get(2)));
        edgeList.add(new Edge(5, vertices.get(0), vertices.get(3)));
        edgeList.add(new Edge(13, vertices.get(1), vertices.get(5)));
        edgeList.add(new Edge(2, vertices.get(1), vertices.get(3)));
        edgeList.add(new Edge(5, vertices.get(2), vertices.get(4)));
        edgeList.add(new Edge(2, vertices.get(2), vertices.get(3)));
        edgeList.add(new Edge(4, vertices.get(3), vertices.get(4)));
        edgeList.add(new Edge(6, vertices.get(3), vertices.get(5)));
        edgeList.add(new Edge(3, vertices.get(3), vertices.get(6)));
        edgeList.add(new Edge(6, vertices.get(4), vertices.get(6)));
        edgeList.add(new Edge(2, vertices.get(5), vertices.get(6)));
        edgeList.add(new Edge(3, vertices.get(5), vertices.get(7)));
        edgeList.add(new Edge(6, vertices.get(6), vertices.get(7)));

        Kruskals algorithm = new Kruskals();
        algorithm.run(vertices, edgeList);
    }

}
