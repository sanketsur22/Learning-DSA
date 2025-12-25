import java.util.*;
public class frogJump {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        
        int n = sc.nextInt();
        int[] arr = new int[n];

        for(int i=0; i<n; i++){
            arr[i] = sc.nextInt();
        }

        int[] dp = new int[n+1];
        Arrays.fill(dp, -1);

        int ans = solveDp3(n, arr);

        System.out.println(ans);

    }

    // Recursion
    
    public static int rec(int ind, int[] height){
        if(ind == 0) return 0;
        
        int left = rec(ind-1, height) + Math.abs(height[ind] - height[ind-1]);
        int right = Integer.MAX_VALUE;
        if(ind > 1){
            right = rec(ind-2, height) + Math.abs(height[ind] - height[ind-2]);
        }
        
        return Math.min(left, right);
    }
    
    // Memoization
    
    public static int solveDp(int ind, int[] height, int[] dp){
        if(ind == 0) return 0;
        
        if(dp[ind] != -1) return dp[ind];
        
        int left = solveDp(ind-1, height, dp) + Math.abs(height[ind] - height[ind-1]);
        int right = Integer.MAX_VALUE;
        if(ind > 1){
            right = solveDp(ind-2, height, dp) + Math.abs(height[ind] - height[ind-2]);
        }
        
        return dp[ind] = Math.min(left, right);
    }
    
    // Tabulization
    
    public static int solveDp2(int n, int[] height, int[] dp){
        dp[0] = 0;
        
        for(int i=1; i<n; i++){
            int left = dp[i-1] + Math.abs(height[i] - height[i-1]);
            int right = Integer.MAX_VALUE;
            if(i > 1){
                right = dp[i-2] + Math.abs(height[i] - height[i-2]);
            }
            dp[i] = Math.min(left, right);
        }
        
        return dp[n-1];
    }
    
    // Optimization
    
    public static int solveDp3(int n, int[] height){
        int prev1 = 0;
        int prev2 = 0;
        
        for(int i=1; i<n; i++){
            int left = prev1 + Math.abs(height[i] - height[i-1]);
            int right = Integer.MAX_VALUE;
            if(i > 1){
                right = prev2 + Math.abs(height[i] - height[i-2]);
            }
            int curr = Math.min(left, right);
            
            prev2 = prev1;
            prev1 = curr;
        }
        
        return prev1;
    }
}
