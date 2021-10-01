package spanning_trees.prims;


import java.util.ArrayList;
import java.util.List;

public class RunPrims {

    public static void main(String[] args) {
        Vertex A = new Vertex("A");
        Vertex B = new Vertex("B");
        Vertex C = new Vertex("C");

        List<Vertex> vertices = new ArrayList<>();
        vertices.add(A);
        vertices.add(B);
        vertices.add(C);

        A.addEdge(new Edge(1, A, B));
        A.addEdge(new Edge(1, A, C));
        A.addEdge(new Edge(10, B, C));

        B.addEdge(new Edge(1, B, A));

        C.addEdge(new Edge(1, C, A));
        C.addEdge(new Edge(10, C, B));


        Prims algorithm = new Prims(vertices);
        algorithm.run(C);
    }
}
