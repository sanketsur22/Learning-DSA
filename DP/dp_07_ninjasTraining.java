import java.util.*;
class dp_07_ninjasTraining {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();

        int[][] arr = new int[n][3];

        for(int i=0; i<n; i++){
            arr[i][0] = sc.nextInt();
            arr[i][1] = sc.nextInt();
            arr[i][2] = sc.nextInt();
        }

        int[][] dp = new int[n][4];

        for(int[] x : dp){
            Arrays.fill(x, -1);
        }

        int ans = tabulization(n, arr, dp);

        System.out.println(ans);

    }

    // Recursion

    // TC - O(2^n)
    // SC - O(n)

    public static int rec(int n, int last, int[][] arr){
        if(n == 0){
            int maxi = Integer.MIN_VALUE;

            for(int i=0; i<=2; i++){
                if(i != last){
                    maxi = Math.max(maxi, arr[n][i]);
                }
            }

            return maxi;
        }

        int maxi = Integer.MIN_VALUE;

        for(int i=0; i<=2; i++){
            if(i != last){
                int points = rec(n-1, i, arr) + arr[n][i];
                maxi = Math.max(maxi, points);
            }
        }

        return maxi;
    }

    // Memoization

    // TC - O(n * 4) * 3
    // SC - O(n) + O(n+4)

    public static int memoization(int n, int last, int[][] arr, int[][] dp){
        if(n == 0){
            int maxi = Integer.MIN_VALUE;

            for(int i=0; i<=2; i++){
                if(i != last){
                    maxi = Math.max(maxi, arr[n][i]);
                }
            }

            return maxi;
        }

        if(dp[n][last] != -1) return dp[n][last];

        int maxi = Integer.MIN_VALUE;

        for(int i=0; i<=2; i++){
            if(i != last){
                int points = memoization(n-1, i, arr, dp) + arr[n][i];
                maxi = Math.max(maxi, points);
            }
        }

        return dp[n][last] = maxi;
    }

    // Tabulization

    // TC - O(n * 4) * 3
    // SC - O(n+4)

    public static int tabulization(int n, int[][] arr, int[][] dp){
        dp[0][0] = Math.max(arr[0][1], arr[0][2]);
        dp[0][1] = Math.max(arr[0][0], arr[0][2]);
        dp[0][2] = Math.max(arr[0][0], arr[0][1]);
        dp[0][3] = Math.max(Math.max(arr[0][0], arr[0][1]), arr[0][2]);

        for(int day = 1; day < n; day++){
            for(int last = 0; last < 4; last++){
                dp[day][last] = 0;
                for(int task = 0; task<3; task++){
                    if(task != last){
                        int points = arr[day][task] + dp[day-1][task];
                        dp[day][last] = Math.max(dp[day][last], points);
                        // System.out.println(Arrays.deepToString(dp));
                    }
                }
            }
        }

        return dp[n-1][3];
    }
}