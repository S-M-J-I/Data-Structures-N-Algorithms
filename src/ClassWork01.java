import java.util.Arrays;
import java.util.Scanner;

public class ClassWork01 {

    private static final Scanner s = new Scanner(System.in);
    public static void main(String[] args) {
        int n = s.nextInt();
        int[] a = new int[n];

        for(int i = 0;  i < n; i++){
            a[i] = (int)(Math.random() * 10 )  + 1;
        }
        sort(a, n);
        System.out.println(Arrays.toString(a));
        int key = s.nextInt();
        int searchKey = bSearch(a, n, key);
        if(searchKey > 0){
            System.out.println("Found at " + searchKey);
        }else{
            System.out.println("Not found!");
        }
    }

    private static void sort(int[] arr, int n){
        for(int i = 0 ; i < n; i++){
            for(int j = 0; j < n - i - 1; j++){
                if(arr[j] > arr[j+1]){
                    int temp = arr[j];
                    arr[j] = arr[j+1];
                    arr[j+1] = temp;
                }
            }
        }
    }

    private static int bSearch(int[] arr, int n, int key){
        int l = 0;
        int h = n;
        while (l <= h){
            int mid = (l + h) / 2;

            if(arr[mid] == key) {
                return mid;
            } else if (arr[mid] < key){
                l = mid + 1;
            } else {
                h = mid;
            }
        }

        return -1;
    }
}
