package basic_data_structures.sorting;

import java.util.Arrays;

public class Challenge2 {

    public static void main(String[] args) {
        int[] array = {20,35,-15,7,55,1,-22};
        System.out.println("Array before InsertionSort: " + Arrays.toString(array));

        insertionSort(array, array.length);

        System.out.println("Array before InsertionSort: " + Arrays.toString(array));

    }

    private static void insertionSort(int[] array, int numItems){
        if(numItems < 2) return;

        insertionSort(array,numItems-1);

        int newElement = array[numItems-1];
        int i;
        for(i=numItems-1; i>0 && array[i-1]>newElement; i--){
            array[i] = array[i-1];
        }
        array[i] = newElement;


    }
}
