import java.util.Arrays;
import java.util.Scanner;

class dp_06_houseRobber2 {
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();

        int[] nums = new int[n];

        for(int i=0; i<n; i++){
            nums[i] = sc.nextInt();
        }

        if(n == 1){
            System.out.println(nums[0]);
        }
        else{
            int[] arr = new int[n-1];
            int[] brr = new int[n-1];

            int a = 0;
            int b = 0;

            for(int i=0; i<n; i++){
                if(i>0) arr[a++] = nums[i];
                if(i<n-1) brr[b++] = nums[i];
            }

            int[] dp = new int[nums.length];
            Arrays.fill(dp, -1);

            int first = tabulization(n, arr, dp);
            Arrays.fill(dp, -1);
            int second = tabulization(n, brr, dp);

            int ans = Math.max(first, second);

            System.out.println(ans);
        }
    }

    // Recursion
    // TC - O(2^n)
    // SC - O(n)

    public static int rec(int ind, int[] nums){
        if(ind >= nums.length) return 0;

        int take = nums[ind] + rec(ind + 2, nums);
        int notTake = rec(ind + 1, nums);

        return Math.max(take, notTake);
    }

    // Memoization

    // TC - O(n)
    // SC - O(n) + O(n)

    public static int memoization(int ind, int[] nums, int[] dp){
        if(ind >= nums.length) return 0;

        if(dp[ind] != -1) return dp[ind];

        int take = nums[ind] + memoization(ind+2, nums, dp);
        int notTake = memoization(ind+1, nums, dp);

        return dp[ind] = Math.max(take, notTake);
    }

    // Tabulization

    // TC - O(n)
    // SC - O(n)

    public static int tabulization(int n, int[] nums, int[] dp){

        for(int i = n - 1; i >= 0; i--){
            int take = nums[i] + dp[i + 2];
            int notTake = dp[i + 1];

            dp[i] = Math.max(take, notTake);
        }

        return dp[0];
    }

    // Optimization

    // TC - O(n)
    // SC - O(1)

    public static int optimization(int[] nums){
        int prev1 = 0; 
        int prev2 = 0; 

        for(int i = nums.length - 1; i >= 0; i--){
            int take = nums[i] + prev2;
            int notTake = prev1;

            int curr = Math.max(take, notTake);

            prev2 = prev1;
            prev1 = curr;
        }

        return prev1;
    }
}