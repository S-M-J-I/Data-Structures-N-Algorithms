package basic_data_structures.hackkerank_practise;

import java.util.Scanner;

public class StringSubstring {

    private static Scanner s = new Scanner(System.in);

    public static void main(String[] args) {
        String inputString = s.nextLine();
        int n = s.nextInt();
        s.close();
        String largest = inputString.substring(0,n);
        String smallest = inputString.substring(0,n);

        for(int i=0; i+n<=inputString.length(); i++){
            if(inputString.substring(i,i+n).compareTo(smallest) < 0){
                smallest = inputString.substring(i,i+n);
            }

            if(inputString.substring(i,i+n).compareTo(largest) > 0){
                largest = inputString.substring(i,i+n);
            }
        }

        System.out.println(smallest);
        System.out.println(largest);


    }
}
