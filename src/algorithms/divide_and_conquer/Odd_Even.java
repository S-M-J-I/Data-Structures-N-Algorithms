package algorithms.divide_and_conquer;

public class Odd_Even {

    /** Given an array of non-negative numbers, print the odd numbers only*/

    public static void main(String[] args) {
        int[] array = {2, 1, 3, 4, 1, 2, 1, 5, 4};

        oddPrint(array, 0, array.length - 1);
    }

    private static void oddPrint(int[] array, int low, int high) {
        if(low == high && array[low] % 2 == 1) {
            System.out.print(array[low] + " ");
        } else if(low == high && array[low] % 2 == 0) {
            return;
        } else{
            int mid = (low + high) / 2;
            oddPrint(array, low, mid);
            oddPrint(array, mid + 1, high);
        }
    }

}
