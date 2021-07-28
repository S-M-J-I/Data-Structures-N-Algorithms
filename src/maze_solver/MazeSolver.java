package maze_solver;

public class MazeSolver {
    private int[][] map;
    private boolean[][] visited;
    private int startRow;
    private int startCol;

    public MazeSolver(int[][] map, int startRow, int startCol, int rows, int cols) {
        this.map = map;
        this.visited = new boolean[rows][cols];
        this.startRow = startRow;
        this.startCol = startCol;
    }

    public void solveMaze(){
        try{
            dfs(startRow,startCol);
            System.out.println("No exit Route Found!!");
        }catch (RuntimeException e){
            System.out.println("Route found to exit!!!");
        }
    }

    private void dfs(int startRow, int startCol){
        System.out.println("Visiting " + (startRow+1) + "," + (startCol+1));

        if(map[startRow][startCol] == 3){
            throw new RuntimeException();
        }

        if(visited[startRow][startCol]){
            return;
        }else if ( startRow < 0 || startRow >= map.length-1){
            return;
        }else if ( startCol < 0 || startCol >= map.length-1){
            return;
        }else {
            visited[startRow][startCol] = true;

            dfs(startRow+1,startCol); // down
            dfs(startRow,startCol+1); // right
            dfs(startRow,startCol-1); // left
            dfs(startRow-1,startCol); // up
        }
    }
}
