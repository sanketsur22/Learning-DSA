import java.util.*;
public class sudoku {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        char[][] arr = new char[9][9];

        for(int i=0; i<9; i++){
            for(int j=0; j<9; j++){
                arr[i][j] = sc.next().charAt(0);
            }
        }

        solve(arr);

        System.out.println("The solved sudoku is below");

        for (int i = 0; i < 9; i++) {
            for (int j = 0; j < 9; j++) {
                System.out.print(arr[i][j] + " ");
            }
            System.out.println();
        }
    }

    public static boolean solve(char[][] arr){
        for(int i=0; i<9; i++){
            for(int j=0; j<9; j++){
                if(arr[i][j] == '.'){

                    for(char c='1'; c<='9'; c++){
                        if(isValid(arr, i, j, c)){
                            arr[i][j] = c;
                            if(solve(arr) == true) return true;
                            else arr[i][j] = '.';
                        }
                    }
                    return false;
                }
            }
        }
        return true;
    }

    public static boolean isValid(char[][] arr, int row, int col, char c){
        for(int i=0; i<9; i++){
            if(arr[i][col] == c) return false;
            if(arr[row][i] == c) return false;
            if(arr[3*(row/3) + i/3][3*(col/3) + i%3] == c) return false;
        }
        return true;
    }
}
