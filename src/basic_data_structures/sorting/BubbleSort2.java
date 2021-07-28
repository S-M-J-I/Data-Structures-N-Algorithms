package basic_data_structures.sorting;

import java.util.Arrays;

public class BubbleSort2 {

    public static void main(String[] args) {
        int[] array = {-12,3,5,34,56,1};
        int indexLast = array.length-1;
        boolean swapped;
        System.out.println("Before Bubble Sort: " + Arrays.toString(array));
        do {
            swapped = false;
            for(int i=0; i<indexLast ; i++){
                if(array[i] > array[i+1]){
                    swap(array,i,i+1);
                    swapped = true;
                }
            }

        }while (swapped);
        System.out.println("After Bubble Sort: " + Arrays.toString(array));
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
