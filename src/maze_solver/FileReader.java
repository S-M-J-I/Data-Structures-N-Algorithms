package maze_solver;

import java.io.File;
import java.io.IOException;
import java.util.List;
import java.util.Scanner;

public class FileReader {
    private String filename;
    private int numOfRows;
    private int numOfColumns;
    private int startCol; // the start column index of the entry point (2)
    private int startRow; // the start row index of the entry point (2)
    private int[][] map; // this will be the map
    List<String> grid;

    public FileReader(String filename, int numOfRows, int numOfColumns) {
        this.filename = filename;
        this.numOfRows = numOfRows;
        this.numOfColumns = numOfColumns;
        this.map = new int[numOfRows][numOfColumns];
    }

    public void parseFile(){

        try(Scanner s = new Scanner(new File(this.filename))){

            for(int i=0; i<numOfRows; i++) {
                for(int j=0; j<numOfColumns; j++) {
                    map[i][j] = s.nextInt();

                    if(map[i][j] == 2){
                        startRow = i;
                        startCol = j;
                    }
                    
                }
            }
        }catch(IOException e){
            e.getStackTrace();
        }
    }

    public String getFilename() {
        return filename;
    }

    public int getNumOfRows() {
        return numOfRows;
    }

    public int getNumOfColumns() {
        return numOfColumns;
    }

    public int getStartCol() {
        return startCol;
    }

    public int getStartRow() {
        return startRow;
    }

    public int[][] getMap() {
        return map;
    }
}
