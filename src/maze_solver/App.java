package maze_solver;

public class App {

    public static void main(String[] args) {
        FileReader fr = new FileReader("D:\\Codes\\Data Structures\\src\\maze_solver\\map.txt", 5, 5);
        fr.parseFile();
        MazeSolver mz = new MazeSolver(fr.getMap(), fr.getStartRow(), fr.getStartCol(), fr.getNumOfRows(), fr.getNumOfColumns());
        mz.solveMaze();
    }
}
