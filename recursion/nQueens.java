import java.util.*;
class nQueens{
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();

        List<List<String>> ans = new ArrayList<>();
        char[][] arr = new char[n][n];

        for(int i=0; i<n; i++){
            for(int j=0; j<n; j++){
                arr[i][j] = '.';
            }
        }

        solve(0, n, arr, ans);

        System.out.println(ans);
    }

    public static void solve(int col, int n, char[][] arr, List<List<String>> ans){
        if(col == n){
            ans.add(rec(arr));
            return;
        }

        for(int row=0; row<n; row++){
            if(isSafe(row, col, n, arr)){
                arr[row][col] = 'Q';
                solve(col+1, n, arr, ans);
                arr[row][col] = '.';
            }
        }
    }

    public static boolean isSafe(int row, int col, int n, char[][] arr){
        int r = row;
        int c = col;

        while(r>=0 && c>=0){
            if(arr[r][c] == 'Q') return false;
            r--;
            c--;
        }

        r = row;
        c = col;

        while(c>=0){
            if(arr[r][c] == 'Q') return false;
            c--;
        }

        r = row;
        c = col;

        while(r<n && c>=0){
            if(arr[r][c] == 'Q') return false;
            r++;
            c--;
        }

        return true;
    }

    public static List<String> rec(char[][] arr){
        List<String> list = new ArrayList<>();

        for(int i=0; i<arr.length; i++){
            String s = new String(arr[i]);
            list.add(s);
        }
        return list;
    }
}