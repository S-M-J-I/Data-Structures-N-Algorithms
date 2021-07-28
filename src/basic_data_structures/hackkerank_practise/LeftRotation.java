package basic_data_structures.hackkerank_practise;

import java.util.Scanner;

public class LeftRotation {

    private static final Scanner s = new Scanner(System.in);
    public static void main(String[] args) {
        int n = s.nextInt();
        int d = s.nextInt();
        int[] array = new int[n];

        for(int i=0 ; i< array.length ; i++){
            array[(i+n-d)%n] = s.nextInt();
            /*
            * (i+n-d)%n
            * This means that when taking input at i position, we are assigning the left shift (-d) n times already --> hence i+n-d
            * and we use the %n to stay inside loop. for example if (4+5-4) 5 % 5 = 0. If the result is 0 then input will be array[0] will be first
            * */
        }

        for(int x : array) System.out.print(x+" ");
    }
}
