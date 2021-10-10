package strongly_connected_components.tarjan;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class TarjanAlgorithm {

    private Stack<Vertex> stack;
    private List<Vertex> vertexList;
    private List<List<Vertex>> connectedComponentList;
    private int time = 0;
    private int count;

    public TarjanAlgorithm(List<Vertex> vertexList) {
        this.vertexList = vertexList;
        this.stack = new Stack<>();
        this.connectedComponentList = new ArrayList<>();
    }

    /** Do a customized dfs for each vertex */
    public void run() {
        for(Vertex vertex : vertexList) {
            if(!vertex.isVisited()) {
                dfs(vertex);
            }
        }
    }

    /** special dfs for tarjan */
    private void dfs(Vertex vertex) {
        /** Assign a special index to a vertex */
        vertex.setLowLink(time++);
        System.out.println("Visiting " + vertex.getName() + " lowlink:" +vertex.getLowLink());
        vertex.setVisited(true);
        this.stack.add(vertex);
        boolean isComponentRoot = true; // keep track that the vertex is a root of SCC or not

        // for all vertices in the vertex adj list
        for(Vertex v : vertex.getNeighbourList()) {
            /** if not visited, then do dfs again */
            if(!v.isVisited()) {
                System.out.println("Recursive visit " + v.getName());
                dfs(v);
            }

            /** if visited, then check if v has a lesser lowLink than vertex. If yes, then there is a back edge in the graph for v */
            if(vertex.getLowLink() > v.getLowLink()) {
                vertex.setLowLink(v.getLowLink());
                System.out.println("Vertex " + v.getName() + " not a SCC root");
                isComponentRoot = false;
            }
        }

        if(isComponentRoot) {
            count++;
            System.out.println("Vertex " + vertex.getName() + " is a root");
            List<Vertex> component = new ArrayList<>();

            while (true) {
                Vertex v = stack.pop();
                System.out.println(v.getName() + " in SCC");
                component.add(v);
                v.setLowLink(9999);

                if(v.getName().equals(vertex.getName())) {
                    break;
                }
            }

            connectedComponentList.add(component);
        }
    }

    public void printComponents() {
        System.out.println(connectedComponentList);
    }
}
