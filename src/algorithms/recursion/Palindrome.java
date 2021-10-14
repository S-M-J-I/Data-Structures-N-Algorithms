package algorithms.recursion;

public class Palindrome {
    public static void main(String[] args) {
        String s = "maam";
        String t = "none";
        String u = "UIU";
        String v = "NIU";
        String w = "UU";

        isPalindrome(s);
        isPalindrome(t);
        isPalindrome(u);
        isPalindrome(v);
        isPalindrome(w);
    }

    private static void isPalindrome(String s) {
        if(s.length() <= 1) {
            System.out.println("Palindrome");
            return;
        }

        if(s.charAt(0) == s.charAt(s.length()-1)) {
            isPalindrome(s.substring(1, s.length()-1));
        } else {
            System.out.println("Not a Palindrome");
        }

    }
}
