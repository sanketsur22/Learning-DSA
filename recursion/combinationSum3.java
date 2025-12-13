import java.util.*;
public class combinationSum3 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.print("Enter the value sum : ");
        int n = sc.nextInt();
        System.out.print("Enter the number of elements to be taken at max : ");
        int k = sc.nextInt();

        List<List<Integer>> ans = new ArrayList<>();

        rec(1, k, n, ans, new ArrayList<>());

        System.out.println(ans);
    }

    public static void rec(int ind, int k, int n, List<List<Integer>> ans, List<Integer> list){
        if(n<0 || list.size() > k) return;
        if(n == 0 && list.size() == k){
            ans.add(new ArrayList<>(list));
            return;
        }
        if(ind > 9) return;
        
        list.add(ind);
        rec(ind+1, k, n-ind, ans, list);
        list.remove(list.size()-1);

        rec(ind+1, k, n, ans, list);
    }
}
