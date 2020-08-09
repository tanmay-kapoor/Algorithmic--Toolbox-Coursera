import java.util.*;

public class Knapsack {
    static int optimalWeight(int W, int[] w) {
        //write you code here
        int n = w.length;
        int[][] dp = new int[n+1][W+1];
        
        for(int i = 0; i<=n; i++) {
            for(int j = 0; j<=W; j++) {
                if(i==0 || j==0) {
                    dp[i][j] = 0;
                }
                else if(j-w[i-1] < 0) {
                    dp[i][j] = dp[i-1][j];
                }
                else {
                    dp[i][j] = Math.max(w[i-1] + dp[i-1][j-w[i-1]], dp[i-1][j]);    //add value(weight=value here) of current row and calc for previous row
                }
            }
        }
        return dp[n][W];
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int W, n;
        W = sc.nextInt();
        n = sc.nextInt();
        int[] w = new int[n];
        for (int i = 0; i < n; i++) {
            w[i] = sc.nextInt();
        }
        Arrays.sort(w);
        System.out.println(optimalWeight(W, w));
    }
}

