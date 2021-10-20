package algorithms.dynamic_programming;

public class FibonacciSequence {
    public static void main(String[] args) {
        System.out.println(Fibonacci(9));
    }

    private static int Fibonacci(int n) {
        int[] fibo = new int[n + 2];
        fibo[0] = 0;
        fibo[1] = 1;

        for(int i = 2; i <= n; ++i) {
            fibo[i] = fibo[i - 1] + fibo[i - 2];
        }

        return fibo[n];
    }
}
