import java.util.*;
public class palindromePartitioning {
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);

        System.out.print("Enter the String : ");
        String s = sc.nextLine();

        List<List<String>> ans = new ArrayList<>();
        List<String> list = new ArrayList<>();

        rec(0, s, list, ans);

        System.out.println(ans);
    }

    public static void rec(int ind, String s, List<String> list, List<List<String>> ans){
        if(ind == s.length()){
            ans.add(new ArrayList<>(list));
            return;
        }

        for(int i=ind; i<s.length(); i++){
            if(isPalindrome(ind, i, s)){
                list.add(s.substring(ind, i+1));
                rec(i+1, s, list, ans);
                list.remove(list.size() - 1);
            }
        }
    }

    public static boolean isPalindrome(int start, int end, String s){
        while(start <= end){
            if(s.charAt(start) != s.charAt(end)) return false;
            start++;
            end--;
        }
        return true;
    }
}
