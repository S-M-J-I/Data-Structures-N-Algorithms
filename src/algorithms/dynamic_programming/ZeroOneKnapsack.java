package algorithms.dynamic_programming;

public class ZeroOneKnapsack {
    public static void main(String[] args) {
        int[] itemWeight = {1, 2, 2, 4 , 5};
        int[] price = {10, 12, 13, 18, 20};
        int maxKnapsackWeight = 6;

        Knapsack(itemWeight, price, maxKnapsackWeight);
    }

    private static void Knapsack(int[] itemWeight, int[] price,int maxKnapsackWeight) {
        int[][] dp = new int[itemWeight.length + 1][maxKnapsackWeight + 1];

        for(int it = 1; it <= itemWeight.length; it++) {
            for(int w = 1; w <= maxKnapsackWeight; ++w) {
                if(itemWeight[it-1] <= w) {
                    int include = price[it - 1] + dp[it - 1][w - itemWeight[it-1]];
                    int exclude = dp[it - 1][w];

                    dp[it][w] = Integer.max(include, exclude);
                } else  {
                    dp[it][w] = dp[it-1][w];
                }
            }
        }

        System.out.println("Max Weight: "+dp[itemWeight.length][maxKnapsackWeight]);
    }

}
