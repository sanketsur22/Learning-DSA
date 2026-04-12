import java.util.*;
public class dp_04_frogJumpWithKDistances {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        
        int n = sc.nextInt();
        int[] arr = new int[n];

        for(int i=0; i<n; i++){
            arr[i] = sc.nextInt();
        }

        int k = sc.nextInt();

        int[] dp = new int[n+1];
        Arrays.fill(dp, -1);

        int ans = solveDp2(n-1, arr, k, dp);

        System.out.println(ans);

    }

    // Recursion

    // TC - O(k^n) k -> choices at each step , n -> total steps
    // SC - O(n)
    
    public static int rec(int ind, int[] height, int k){
        if(ind == 0) return 0;

        int minSteps = Integer.MAX_VALUE;
        
        for(int j=1; j<=k; j++){
            if(ind - j >= 0){
                int jump = rec(ind-j, height, k) + Math.abs(height[ind]-height[ind-j]);
                minSteps = Math.min(minSteps, jump);
            }
        }
        
        return minSteps;
    }
    
    // Memoization

    // TC - O(n) * k
    // SC - O(n) + O(n)
    
    public static int solveDp(int ind, int[] height, int k, int[] dp){
        if(ind == 0) return 0;
        
        if(dp[ind] != -1) return dp[ind];
        
        int minSteps = Integer.MAX_VALUE;
        
        for(int j=1; j<=k; j++){
            if(ind - j >= 0){
                int jump = solveDp(ind-j, height, k, dp) + Math.abs(height[ind]-height[ind-j]);
                minSteps = Math.min(minSteps, jump);
            }
        }
        
        return dp[ind] = minSteps;
    }
    
    // Tabulization

    // TC - O(n) * k
    // SC - O(n)
    
    public static int solveDp2(int n, int[] height, int k, int[] dp){
        dp[0] = 0;
        
        for(int i=1; i<=n; i++){
            int minSteps = Integer.MAX_VALUE;
        
            for(int j=1; j<=k; j++){
                if(i - j >= 0){
                    int jump = dp[i-j] + Math.abs(height[i]-height[i-j]);
                    minSteps = Math.min(minSteps, jump);
                }
            }
            dp[i] = minSteps;
        }
        
        return dp[n];
    }
}
