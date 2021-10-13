package algorithms.dynamic_programming;

public class LongestCommonSubsequence {

    public static void main(String[] args) {
        String S = "ABCDT";
        String T = "ABT";

        LCS(S, T);
    }

    private static void LCS(String S, String T) {
        int n = S.length();
        int m = T.length();

        int[][] dp = new int[n+1][m+1];

        for(int i = 1; i <= n; ++i) {
            for(int j = 1; j <= m; ++j) {

                if(j < i) {
                    dp[i][j] = dp[i-1][j];
                }

                if(S.charAt(i-1) == T.charAt(j-1)) {
                    dp[i][j] = dp[i-1][j-1]+1;
                } else {
                    dp[i][j] = Integer.max(dp[i][j-1], dp[i-1][j]);
                }
            }
        }

        System.out.println("Length : "+dp[n][m]);

        StringBuilder string = new StringBuilder();
        int i = n, j = m;
        while (i > 0 && j > 0) {
            if(dp[i][j] > dp[i-1][j]) {
                string.append(S.charAt(i-1));
                i--; j--;
            } else if (dp[i][j] == dp[i-1][j]) {
                i--;
            }
        }

        System.out.println(string.reverse());
    }
}
