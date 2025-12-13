import java.util.*;
public class subsetSum2 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.println("enter the size of the array : ");
        int n = sc.nextInt();
        int arr[] = new int[n];
        System.out.println("enter the array elements : ");

        for (int i = 0; i < arr.length; i++) {
            arr[i] = sc.nextInt();  
        }

        Arrays.sort(arr);

        List<List<Integer>> ans = new ArrayList<>();

        rec(0, arr, ans, new ArrayList<>());

        System.out.println(ans);
    }

    public  static void rec(int ind, int[] arr, List<List<Integer>> ans, List<Integer> list){
        ans.add(new ArrayList<>(list));

        for(int i=ind; i<arr.length; i++){
            if(i>ind && arr[i] == arr[i-1]) continue;

            list.add(arr[i]);
            rec(i+1, arr, ans, list);
            list.remove(list.size()-1);
        }
    }
}
