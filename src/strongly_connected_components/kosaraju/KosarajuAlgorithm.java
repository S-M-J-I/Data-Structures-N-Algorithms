package strongly_connected_components.kosaraju;

public class KosarajuAlgorithm {
    private int[] id; // id[V] = id of SCC of the given V (vertex)
    private int count; // no. of SCC
    private boolean[] marked;

    public KosarajuAlgorithm(Graph graph) {

        DepthFirstOrder dfs = new DepthFirstOrder(graph.transposeGraph());

        marked = new boolean[graph.getVertices().size()];
        id = new int[graph.getVertices().size()];

        for(Vertex vertex : dfs.getReversePostOrder()) {
            if(!marked[vertex.getId()]) {
                dfs(vertex);
                count++;
            }
        }
    }

    private void dfs(Vertex vertex) {
        marked[vertex.getId()] = true;
        id[vertex.getId()] = count;
        vertex.setComponentID(count);

        for(Vertex v : vertex.getAdjList()) {
            if(!marked[v.getId()]) {
                dfs(v);
            }
        }
    }

    public int getCount() {
        return count;
    }

}
