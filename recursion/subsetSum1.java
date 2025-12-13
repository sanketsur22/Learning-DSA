import java.util.*;
public class subsetSum1 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("enter the length of thr array : ");
        int n = sc.nextInt();
    
        int arr[] = new int[n];

        System.out.print("enter the array elements : ");
        for(int i=0; i<n; i++){
            arr[i] = sc.nextInt();
        }

        List<Integer> list = new ArrayList<>();

        rec(0, 0, arr, list);
        Collections.sort(list);
        System.out.println(list);
    }

    public static void rec(int ind, int sum, int[] arr, List<Integer> list){
        if(ind == arr.length){
            list.add(sum);
            return;
        }

        rec(ind+1, sum+arr[ind], arr, list);
        rec(ind+1, sum, arr, list);
    }
}
