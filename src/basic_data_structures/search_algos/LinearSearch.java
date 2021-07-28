package basic_data_structures.search_algos;

public class LinearSearch {

    public static void main(String[] args) {
        int[] arr = {90,19,2,523,4,-15,3,65};
        int position = search(arr,-15);
        switch (position){
            case -1:{
                System.out.println("No such element in the array");
                break;
            }
            default:{
                System.out.println("-15 is at position : " + position);
                break;
            }
        }
    }

    public static int search(int[] arr, int value){
        for(int i=0; i<arr.length; i++){
            if(arr[i] == value){
                return i;
            }
        }

        return -1;
    }
}
