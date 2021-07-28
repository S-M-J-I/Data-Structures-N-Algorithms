package graphs;

import java.util.Stack;

class DFS{

    /**
     * Same working principle as BFS, instead we use a stack
     * */

    public void dfs(Vertex root){
        Stack<Vertex> stack = new Stack<>();
        root.visited = true;
        stack.push(root);

        while(!stack.empty()){
            Vertex actual = stack.pop();
            System.out.print(actual.vertexName+" ");

            for(Vertex v : actual.neighbours){
                if(!v.visited){
                    v.visited = true;
                    stack.push(v);
                }
            }
        }
    }

    public void recursiveDFS(Vertex vertex){
        vertex.visited = true;
        System.out.print(vertex.vertexName + " ");

        for(Vertex v : vertex.neighbours){
            if(!v.visited){
                recursiveDFS(v);
            }
        }
    }
}


public class DepthFirstSearch {

    public static void main(String[] args) {
        DFS example = new DFS();

        Vertex v1 = new Vertex("A");
        Vertex v2 = new Vertex("B");
        Vertex v3 = new Vertex("C");
        Vertex v4 = new Vertex("D");
        Vertex v5 = new Vertex("E");
        Vertex v6 = new Vertex("F");
        Vertex v7 = new Vertex("G");
        Vertex v8 = new Vertex("H");

        v1.addNeighbour(v2,v6,v7);
        v2.addNeighbour(v3,v4);
        v7.addNeighbour(v8);
        v4.addNeighbour(v5);

        /**
         *
         * The one using stack traverses from the left
         *
         * */
        example.dfs(v1);
        System.out.println();

        v1 = new Vertex("A");
        v2 = new Vertex("B");
        v3 = new Vertex("C");
        v4 = new Vertex("D");
        v5 = new Vertex("E");
        v6 = new Vertex("F");
        v7 = new Vertex("G");
        v8 = new Vertex("H");

        v1.addNeighbour(v2,v6,v7);
        v2.addNeighbour(v3,v4);
        v7.addNeighbour(v8);
        v4.addNeighbour(v5);

        /**
         *
         * The one using recursion traverses from the right
         *
         * */

        example.recursiveDFS(v1);


    }
}
