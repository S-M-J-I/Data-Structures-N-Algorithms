package basic_data_structures.sorting;

import java.util.Arrays;


public class Challenge1 {

    public static void main(String[] args) {
        int[] array = {20,35,-15,7,55,1,-22};
        System.out.println("Array before MergeSort: " + Arrays.toString(array));

        mergeSort(array,0, array.length);

        System.out.println("Array after MergeSort: " + Arrays.toString(array));

    }

    private static void mergeSort(int[] array, int first, int last){
        if(last-first < 2) {
            return;
        }

        int mid = (first+last) / 2;
        mergeSort(array,first,mid);
        mergeSort(array,mid,last);
        merge(array,first,mid,last);
    }

    private static void merge(int[] array, int first, int mid, int last){
        if(array[mid-1] >= array[mid]) {
            return;
        }

        int i = first;
        int j = mid;
        int tempIndex = 0;
        int[] temp = new int[last-first];
        while (i<mid && j<last){
            temp[tempIndex++] = array[i] >= array[j] ? array[i++] : array[j++];
        }

        System.arraycopy(array,i,array,first+tempIndex,mid-i);
        System.arraycopy(temp,0,array,first,tempIndex);
    }

}
