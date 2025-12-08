import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class subsequence {

    public static void rec(int ind, int[] nums, List<List<Integer>> ans, List<Integer>list, int n) {
        if(ind==n){
            ans.add(new ArrayList<>(list));
            return;
        }
        list.add(nums[ind]);
        rec(ind+1, nums, ans, list, n);
        list.remove(list.size()-1);
        rec(ind+1, nums, ans, list, n);
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] nums = new int[n];

        for(int i=0; i<n; i++){
            nums[i] = sc.nextInt();
        }

        List<List<Integer>> ans = new ArrayList<>();
        List<Integer> list = new ArrayList<>();
        rec(0, nums, ans, list, n);

        System.out.println(ans);        
    }   
}
