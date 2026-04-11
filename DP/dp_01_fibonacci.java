import java.util.*;
public class dp_01_fibonacci {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.print("Enter the number : ");
        int n = sc.nextInt();

        long[] dp = new long[n+1];
        Arrays.fill(dp, -1);
 
        long ans = optimization(n);

        System.out.println("The ans is " + ans);
    }

    // Recursion

    // TC - O(n^2)
    // SC - O(n)

    public static int rec(int n){
        if(n <= 1) return n;

        return rec(n-1) + rec(n-2);
    }

    // Memoization

    // TC - O(n)
    // SC - O(n) + O(n) (Recursion stack space + Array)

    public static long memoization(int n, long[] dp){
        if(n <= 1) return n;

        if(dp[n] != -1) return dp[n];

        return dp[n] = memoization(n-1, dp) + memoization(n-2, dp);
    }

    // Tabulization

    // TC - O(n)
    // SC - O(n)

    public static long tabulization(int n, long[] dp){
        dp[0] = 0;
        dp[1] = 1;

        for(int i=2; i<=n; i++){
            dp[i] = dp[i-1] + dp[i-2];
        }

        return dp[n];
    }

    // Optimization

    // TC - O(n)
    // SC - No space used

    public static long optimization(int n){
        long prev2 = 0;
        long prev1 = 1;

        for(int i=2; i<=n; i++){
            long curr = prev1 + prev2;
            prev2 = prev1;
            prev1 = curr;
        }

        return prev1;
    }
}
