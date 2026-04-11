import java.util.*;

public class dp_02_climbingStair {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();

        int[] dp = new int[n+1];
        Arrays.fill(dp, -1);

        int ans = optimization(n);

        System.out.println(ans);
    }

    // Recursion

    // TC - O(2^n)
    // SC - O(n)

    public static int rec(int n){
        if(n == 0) return 1;

        int left = rec(n-1);
        int right = 0;
        if(n > 1) right = rec(n-2);

        return left + right;
    }

    // Memoization

    // TC - O(n)
    // SC - O(n) + O(n) (Recursion stack space + Array)

    public static int memoization(int n, int[] dp){
        if(n == 0) return 1;
        
        if(dp[n] != -1) return dp[n];

        int left = memoization(n-1, dp);
        int right = 0;
        if(n > 1) right = memoization(n-2, dp);

        return dp[n] = left + right;
    }

    // Tabulization

    // TC - O(n)
    // SC - O(n)

    public static int tabulization(int n) {
        int[] dp = new int[n + 1];

        // base case
        dp[0] = 1;

        for (int i = 1; i <= n; i++) {
            int left = dp[i - 1];
            int right = 0;
            if (i > 1) right = dp[i - 2];

            dp[i] = left + right;
        }

        return dp[n];
    }

    // Optimization

    // TC - O(n)
    // SC - O(1)

    public static int optimization(int n){
        int prev2 = 1;
        int prev1 = 1;

        for (int i = 2; i <= n; i++) {
            int curr = prev1 + prev2;
            prev2 = prev1;
            prev1 = curr;
        }

        return prev1;
    }
}
