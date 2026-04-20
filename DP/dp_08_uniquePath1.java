import java.util.*;
class dp_08_uniquePath1{
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int m = sc.nextInt();
        int n = sc.nextInt();

        int[][] dp = new int[m][n];
        
        for(int[] row : dp){
            Arrays.fill(row, -1);
        }

        int ans = memoization(m-1, n-1, dp);
        System.out.println(ans);
    }

    public static int rec(int m, int n){
        if(m<0 || n<0) return 0;
        if(m == 0 && n == 0) return 1;

        int up = rec(m-1, n);
        int left = rec(m, n-1);

        return up + left;
    }

    public static int memoization(int m, int n, int[][] dp){
        if(m<0 || n<0) return 0;
        if(m == 0 && n == 0) return 1;

        if(dp[m][n] != -1) return dp[m][n];

        int up = rec(m-1, n);
        int left = rec(m, n-1);

        return dp[m][n] = up + left;
    }
}