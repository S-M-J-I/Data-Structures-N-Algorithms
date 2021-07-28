package basic_data_structures.queue;

import java.util.LinkedList;
import java.util.Locale;

public class QueueChallenge {

    public static void main(String[] args) {
        System.out.println(checkIfPalindrome("dad"));
    }

    public static boolean checkIfPalindrome(String string){
        //declare stack and queue
        LinkedList<Character> stack = new LinkedList<>();
        LinkedList<Character> queue = new LinkedList<>();
        //take the lower cased of the string
        String lowerCased = string.toLowerCase();

        //iterate through string
        for(int i=0; i<lowerCased.length(); i++){
            char c = lowerCased.charAt(i);
            if(c>='a' && c<='z'){
                //add char at last of queue and first at stack
                queue.addLast(c);
                stack.push(c);
            }
        }

        //while stack is not empty
        while (!stack.isEmpty()){
            //if the top of stack is not the same as first element of queue --- false (not a palindrome)
            if(!stack.pop().equals(queue.removeFirst())){
                return false;
            }
        }

        // else true
        return true;
    }
}
