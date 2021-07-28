package basic_data_structures.hackkerank_practise;

import java.util.Scanner;

public class SecondProblem {

    private static Scanner s = new Scanner(System.in);
    public static void main(String[] args) {
        int sum = 0;
        int[][] array = new int[6][6];
        for(int i=0 ; i< array.length; i++){
            for(int j=0 ; j<array[i].length; j++){
                array[i][j] = s.nextInt();
            }
        }

        int maxX = 3;
        int maxY = 3;
        int total = -64;

        for(int y=0 ; y<maxY ; y++){
            for(int x=0 ; x<maxX ; x++){
                //Top Glass
                sum += (array[y][x] + array[y][x+1] + array[y][x+2]);

                //Middle Glass
                sum += (array[y+1][x+1]);

                //Bottom Glass
                sum += (array[y+2][x] + array[y+2][x+1] + array[y+2][x+2]);

                if(total<sum) total = sum;
            }
        }

        System.out.println(total);
    }
}
