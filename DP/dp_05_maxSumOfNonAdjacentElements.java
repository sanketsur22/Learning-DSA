import java.util.*;

public class dp_05_maxSumOfNonAdjacentElements {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

       int n = sc.nextInt();

        int[] arr = new int[n];

        for(int i=0; i<n; i++){
            arr[i] = sc.nextInt();
        } 

        int[] dp = new int[n];

        Arrays.fill(dp, -1);

        int ans = optimization(n, arr);

        System.out.println(ans);
    }

    // Recursion

    // TC - O(n^2)
    // SC - O(n)

    public static int rec(int n, int[] arr){
        if(n < 0) return 0;
        if(n == 0) return arr[0];
        
        int take = rec(n-2, arr) + arr[n];
        int notTake = rec(n-1, arr);

        return Math.max(take, notTake);
    }

    // Memoization

    // TC - O(n)
    // SC - O(n) + O(n)

    public static int memoization(int n, int[] arr, int[] dp){
        if(n < 0) return 0;
        if(n == 0) return arr[0];

        if(dp[n] != -1) return dp[n];
        
        int take = rec(n-2, arr) + arr[n];
        int notTake = rec(n-1, arr);

        return dp[n] = Math.max(take, notTake);
    }

    // Tabulization

    // TC - O(n)
    // SC - O(n)

    public static int tabulization(int n, int[] arr, int[] dp){
        dp[0] = arr[0];

        for(int i=1; i<n; i++){
            int take = arr[i];
            if(i>1) take += dp[i-2];
            int notTake = dp[i-1];

            dp[i] = Math.max(take, notTake);
        }

        return dp[n-1];
    }

    // Optimization

    // TC - O(n)
    // SC - O(1)

    public static int optimization(int n, int[] arr){
        int prev1 = arr[0];
        int prev2 = 0;

        for(int i=1; i<n; i++){
            int take = arr[i];
            if(i>1) take += prev2;
            int notTake = prev1;

            int curr = Math.max(take, notTake);

            prev2 = prev1;
            prev1 = curr;
        }

        return prev1;
    }
}