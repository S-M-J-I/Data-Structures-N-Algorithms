package basic_data_structures.sorting;

import java.util.Arrays;

public class BubbleSort {

    public static void main(String[] args) {
        long startTime = System.currentTimeMillis();
        int[] array = {-12,3,5,34,56,1};
        System.out.println("Before BubbleSort: " + Arrays.toString(array));
        int unsortedPartitionIndex = array.length - 1;
        while (unsortedPartitionIndex>=0){
            for(int i=0 ; i<unsortedPartitionIndex ; i++){
                if(array[i] > array[i+1]){
                    swap(array,i,i+1);
                }
            }
            unsortedPartitionIndex--;
        }
        System.out.println("After BubbleSort: " + Arrays.toString(array));
        long endTime = System.currentTimeMillis();
        System.out.println("Time Taken: " + (endTime-startTime));
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
