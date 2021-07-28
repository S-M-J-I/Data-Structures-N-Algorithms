package graphs;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

class TopologicalSort{

    /**
     * CREATE A STACK
     * THIS WILL BE THE TOPOLOGICAL ORDER
     * THIS IS JUST LIKE DFS
     *
     * EXCEPT, WE VISIT ALL THE NODES TILL THE LAST NODE, THEN WE ADD IT TO STACK
     * */

    private Stack<Vertex> stack;

    public TopologicalSort(){
        this.stack = new Stack<>();
    }

    public void DFS(Vertex vertex){

        vertex.visited = true;

        for(Vertex v : vertex.neighbours){
            if(!v.visited){
                DFS(v);
            }
        }

        stack.push(vertex);

    }

    public Stack<Vertex> getStack(){
        return this.stack;
    }

}


public class TopologicalOrdering {

    public static void main(String[] args) {

        TopologicalSort example = new TopologicalSort();

        List<Vertex> graph = new ArrayList<>();

        graph.add(new Vertex("0"));
        graph.add(new Vertex("1"));
        graph.add(new Vertex("2"));
        graph.add(new Vertex("3"));
        graph.add(new Vertex("4"));
        graph.add(new Vertex("5"));

        connectGraph(graph,2,3);

        connectGraph(graph,3,1);

        connectGraph(graph,4,0);
        connectGraph(graph,4,1);

        connectGraph(graph,5,0);
        connectGraph(graph,5,2);

        for (Vertex vertex : graph) {
            if (!vertex.visited) {
                example.DFS(vertex);
            }
        }

        Stack<Vertex> stack = example.getStack();

        for(int i=0; i< graph.size(); i++){
            Vertex v = stack.pop();
            System.out.print(v.vertexName + " - ");
        }


    }

    public static void connectGraph(List<Vertex> graph, int i, int j){
        graph.get(i).addNeighbour(graph.get(j));
    }

}
