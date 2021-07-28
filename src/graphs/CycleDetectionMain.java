package graphs;


import java.util.ArrayList;
import java.util.List;

class Vertex2 {
    private String vertexName;
    protected boolean isVisited;
    protected boolean isBeingVisited;
    private List<Vertex2> neighbours;

    public Vertex2(String vertexName) {
        this.vertexName = vertexName;
        this.neighbours = new ArrayList<>();
    }

    public void addVertices(Vertex2 ...vertices){
        for(Vertex2 v : vertices){
            this.neighbours.add(v);
        }
    }

    public List<Vertex2> getNeighbours() {
        return neighbours;
    }
}

class CycleDetection{

    public void dfs(Vertex2 vertex){
        vertex.isVisited = false;
        vertex.isBeingVisited = true;

        for(Vertex2 v : vertex.getNeighbours()){
            if(v.isBeingVisited){
                System.out.println("There's a cycle in the graph");
                return;
            }

            v.isVisited = true;
            dfs(v);
        }

        vertex.isVisited = true;
        vertex.isBeingVisited = false;
    }

}

public class CycleDetectionMain {

    public static void main(String[] args) {
        Vertex2 v1 = new Vertex2("1");
        Vertex2 v2 = new Vertex2("2");
        Vertex2 v3 = new Vertex2("3");
        Vertex2 v4 = new Vertex2("7");
        Vertex2 v5 = new Vertex2("8");
        Vertex2 v6 = new Vertex2("5");

        v1.addVertices(v2);

        v2.addVertices(v3);
        v2.addVertices(v6);

        v3.addVertices(v4,v5);

        v6.addVertices(v1);

        CycleDetection example = new CycleDetection();

        example.dfs(v1);
    }


}
