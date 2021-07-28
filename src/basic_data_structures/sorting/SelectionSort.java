package basic_data_structures.sorting;

import java.util.Arrays;

public class SelectionSort {

    public static void main(String[] args) {
        int[] array = {20,35,-15,7,55,1,-22};
        System.out.println("Before Selection Sort : " + Arrays.toString(array));
        int lastUnPartitionedIndex = array.length - 1;

        while (lastUnPartitionedIndex>=0){
            int largest = 0;
            for(int i=1 ; i<=lastUnPartitionedIndex ; i++){
                if(array[i] > array[largest]){
                    largest = i;
                }
            }
            swap(array, largest, lastUnPartitionedIndex);
            lastUnPartitionedIndex--;
        }

        System.out.println("After Selection Sort : " + Arrays.toString(array));
    }

    public static void swap(int[] a, int i, int j){
        if(i==j){
            return;
        }

        int temp = a[i];
        a[i] = a[j];
        a[j] = temp;
    }
}
