package algorithms.recursion;

public class FibonacciSequence {
    public static void main(String[] args) {
        System.out.println(Fibonacci(9));
    }

    private static int Fibonacci(int n) {
        if(n <= 1) {
            return n;
        }

        return Fibonacci(n - 2) + Fibonacci(n - 1);
    }
}
