package algorithms.divide_and_conquer;

public class MaximumSubarraySum {

    /** An array of positive and negative numbers is given, find the maximum sum from this array */

    public static void main(String[] args) {
        int[] array = {-2, 1, -3, 4, -1, 2, 1, -5, 4};

        System.out.println(maxSubArraySum(array, 0, array.length-1));
    }

    private static int max(int a, int b) {
        return Integer.max(a, b);
    }
    
    private static int max(int a, int b, int c) {
        return Integer.max(max(a, b), c);
    } 

    private static int crossArraySum(int[] array, int low, int mid, int high) {
        int left_sum, right_sum, cross_sum;
        left_sum = right_sum = Integer.MIN_VALUE;

        int sum = 0;
        for(int i = mid; i >= low; i--) {
            sum += array[i];
            if( sum > left_sum ) {
                left_sum = sum;
            }
        }

        sum = 0;
        for(int i = mid + 1; i <= high; ++i) {
            sum += array[i];
            if( sum >= right_sum ) {
                right_sum = sum;
            }
        }
        
        cross_sum = left_sum + right_sum;
        
        return max(left_sum, right_sum, cross_sum);

    }
    
    private static int maxSubArraySum(int[] array, int low, int high) {
        if(low == high) {
            return array[low];
        }
        else {
            int mid =( low + high) / 2;
            int left = maxSubArraySum(array, 0, mid);
            int right = maxSubArraySum(array, mid+1, high);
            int cross = crossArraySum(array, low, mid, high);

            return max(left, right, cross);
        }
    }

}
