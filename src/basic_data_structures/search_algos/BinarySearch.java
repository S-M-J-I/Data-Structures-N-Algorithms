package basic_data_structures.search_algos;

public class BinarySearch {

    public static void main(String[] args) {
        int[] array = {-22,-15,1,7,20,35,55};
        int position = iterativeSearch(array, 1);
        switch (position){
            case -1:{
                System.out.println("Not found");
                break;
            }
            default:{
                System.out.println("Found @ position " + position);
                break;
            }
        }


        position = recursiveSearch(array, 1);
        switch (position){
            case -1:{
                System.out.println("Not found");
                break;
            }
            default:{
                System.out.println("Found @ position " + position);
                break;
            }
        }
    }

    public static int iterativeSearch(int[] arr, int value){
        int start = 0;
        int end = arr.length;

        while (start < end){
            int mid = (start+end) / 2;
            if(arr[mid] == value){
                return mid;
            }else if (arr[mid] < value){
                start = mid + 1;
            }else {
                end = mid;
            }
        }

        return -1;
    }

    public static int recursiveSearch(int[] arr, int start, int end, int value){
        if(start >= end){
            return -1;
        }

        int mid = (start + end) / 2;

        if(arr[mid] == value){
            return mid;
        }else if(arr[mid] < value){
            return recursiveSearch(arr,mid+1,end,value);
        }else {
            return recursiveSearch(arr,start,mid,value);
        }
    }

    public static int recursiveSearch(int[] arr, int val){
        return recursiveSearch(arr,0,arr.length,val);
    }


}
