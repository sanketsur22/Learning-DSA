import java.util.*;
public class combinationSum2 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter the size of the array : ");
        int n = sc.nextInt();
        System.out.print("Enter the target : ");
        int target = sc.nextInt();

        int arr[] = new int[n];
        System.out.print("Enter the array elements : ");

        for(int i=0; i<n; i++){
            arr[i] = sc.nextInt();
        }

        Arrays.sort(arr);

        List<Integer> list = new ArrayList<>();
        List<List<Integer>> ans = new ArrayList<>();

        rec(0, arr, target, list, ans);

        System.out.println(ans);
    }

    public static void rec(int ind, int[] arr, int target, List<Integer> list, List<List<Integer>> ans){
        if(target == 0){
            ans.add(new ArrayList<>(list));
            return;
        }

        for(int i=ind; i<arr.length; i++){
            if(i>ind && arr[i]==arr[i-1]) continue;
            if(arr[i] > target) break;

            list.add(arr[i]);
            rec(i+1, arr, target-arr[i], list, ans);
            list.remove(list.size() - 1);
        }
    }
}
