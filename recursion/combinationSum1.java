import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class combinationSum1 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("enter array length : ");
        int n = sc.nextInt();
        System.out.print("enter target : ");
        int target = sc.nextInt();
        int arr[] = new int[n];
        System.out.print("enter array length : ");
        for (int i = 0; i < arr.length; i++) {
            arr[i] = sc.nextInt();
        }

        List<Integer> list = new ArrayList<>();
        List<List<Integer>> ans = new ArrayList<>();

        rec(0, 0, arr, target, list, ans);
        System.out.println(ans);
    }

    public static void rec(int ind, int sum, int[] arr, int target, List<Integer> list, List<List<Integer>> ans){
        if(ind >= arr.length){
            if(sum == target){
                ans.add(new ArrayList<>(list));
            }
            return;
        }

        if(sum + arr[ind] <= target){
            list.add(arr[ind]);
            rec(ind, sum+arr[ind], arr, target, list, ans);
            list.remove(list.size() - 1);
        }

        rec(ind+1, sum, arr, target, list, ans);
    }
}
