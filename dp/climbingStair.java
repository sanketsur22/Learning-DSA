import java.util.*;

public class climbingStair {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();

        int[] dp = new int[n+1];
        Arrays.fill(dp, -1);

        int ans = solveDp(n, dp);

        System.out.println(ans);
    }

    public static int rec(int n){
        if(n == 0) return 1;

        int left = rec(n-1);
        int right = 0;
        if(n > 1) right = rec(n-2);

        return left + right;
    }

    public static int solveDp(int n, int[] dp){
        if(n == 0) return 1;
        
        if(dp[n] != -1) return dp[n];

        int left = solveDp(n-1, dp);
        int right = 0;
        if(n > 1) right = solveDp(n-2, dp);

        return dp[n] = left + right;
    }
}
