package basic_data_structures.stack;

import java.util.LinkedList;
import java.util.Locale;

public class StackChallenge {

    /* CHECK IF A STRING IS PALINDROME OR NOT */

    public static void main(String[] args) {
        System.out.println(checkPalindrome("Racecar"));
        System.out.println(checkPalindrome("UIU"));
        System.out.println(checkPalindrome("Wizard"));
    }

    public static boolean checkPalindrome(String string){

        LinkedList<Character> stack = new LinkedList<Character>();
        StringBuilder stringNoPunctuation = new StringBuilder(string.length());
        String lowerCase = string.toLowerCase();

        for(int i=0; i<lowerCase.length(); i++){
            char c = lowerCase.charAt(i);
            if(c >= 'a' && c<= 'z'){
                stringNoPunctuation.append(c);
                stack.push(c);
            }
        }

        StringBuilder reverseString = new StringBuilder(stack.size());
        while (!stack.isEmpty()){
            reverseString.append(stack.pop());
        }

        return reverseString.toString().equals(stringNoPunctuation.toString());

    }
}
