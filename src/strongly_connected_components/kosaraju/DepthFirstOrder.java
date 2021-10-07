package strongly_connected_components.kosaraju;

import java.util.Stack;

public class DepthFirstOrder {
    private Stack<Vertex> stack;

    public DepthFirstOrder(Graph graph) {
        stack = new Stack<>();

        for(Vertex vertex : graph.getVertices()) {
            if( !vertex.isVisited() ) {
                dfs(vertex);
            }
        }
    }

    private void dfs(Vertex vertex) {
        vertex.setVisited(true);

        for(Vertex v : vertex.getAdjList()) {
            if(!v.isVisited()) {
                dfs(v);
            }
        }

        stack.push(vertex);
    }

    public Stack<Vertex> getReversePostOrder() {
        return this.stack;
    }
}
