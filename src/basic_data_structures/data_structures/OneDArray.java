package basic_data_structures.data_structures;

import java.util.Arrays;

class Array{

    public int[] addElement(int[] array, int position, int value){
        int[] result = new int[array.length+1];
        for(int i=0; i<position ; i++){
            result[i] = array[i];
        }
        result[position] = value;
        for (int i=position+1 ; i<result.length ; i++){
            result[i] = array[i-1];
        }

        return result;
    }

    public int searchElement(int[] array, int key){
        int lock = -1;

        for(int i=0; i< array.length ; i++){
            if(array[i] == key){
                lock = i;
                break;
            }
        }

        return lock;
    }

    public int[] deleteElement(int[] array, int target){
        int lock = searchElement(array, target);
        if(lock>=0){
            for(int i=lock+1; i<array.length; i++){
                array[i-1] = array[i];
            }
        }

        return Arrays.copyOf(array,array.length-1);
    }
};


public class OneDArray {

    public static void main(String[] args) {
	    int[] arr = {1,5,2,8,7,3};
        Array array = new Array();
        System.out.println(Arrays.toString(array.addElement(arr, 4, 15)));
        System.out.println(Arrays.toString(array.deleteElement(arr,15)));
    }
}
