package algorithms.divide_and_conquer;

public class Max_Min {

    /** Given an array, determine the minimum and maximum from that array */

    public static void main(String[] args) {
        int[] array = {2, 1, 3, 4, 1, 2, 1, 5, 4};

        int[] result = max_min(array, 0, array.length - 1);

        System.out.println("Max : " + result[0] +"\nMin : " + result[1]);
    }

    private static int min(int a, int b) {
        return Integer.min(a, b);
    }

    private static int max(int a, int b) {
        return Integer.max(a, b);
    }

    /** return array containing max and min, with max at index 0 and min at index 1 */

    private static int[] max_min(int[] array, int low, int high) {
        int[] result = new int[2];
        int max, min;
        if(low == high) {
            max = array[low];
            min = array[low];
        } else {
            int mid = (low + high) / 2;
            int[] leftSide = max_min(array, low, mid);
            int[] rightSide = max_min(array, mid + 1, high);

            max = max(leftSide[0], rightSide[0]);
            min = min(leftSide[1], rightSide[1]);
        }

        result[0] = max;
        result[1] = min;
        return result;
    }

}
