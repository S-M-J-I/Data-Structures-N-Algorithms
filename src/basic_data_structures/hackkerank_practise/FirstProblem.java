package basic_data_structures.hackkerank_practise;

import java.util.Arrays;
import java.util.Scanner;

public class FirstProblem {

    private static Scanner s= new Scanner(System.in);
    public static void main(String[] args) {
        int n = s.nextInt();
        int[] array = new int[n];
        for(int i=0 ;i<array.length; i++) array[i] = s.nextInt();
        array = reverseArray(array);
        for(int i=0 ;i< array.length ; i++) System.out.print(array[i] + " ");
        s.close();
    }
    public static int[] reverseArray(int[] array){
        int[] result= new int[array.length];
        for(int i=0 ; i<array.length ; i++){
            result[i] = array[array.length-i-1];
        }
        return result;
    }


}
