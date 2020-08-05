import java.util.*;
import java.lang.*;
import java.io.*;

class GFG {
    public static boolean isSafe(int b[][], int i, int j, int val, boolean row[][], boolean col[][], boolean d[][]) {
        int n = (int)Math.sqrt(b.length);
            if(!(row[i][val - 1] || col[j][val - 1] || d[((i / n) * n) + (j / n)][val - 1])) {
                return false;
            }
        return true;
    }
    
    
    public static boolean place(int b[][], int i, int j1, boolean row[][], boolean col[][], boolean d[][]) {
        int n = b.length;
        int n1 = (int)Math.sqrt(n);
        System.out.print(i+" ");
        if(i >= 9) {
            for(int k = 0;k < n;k++) {
                for(int j = 0;j < n;j++) { 
                        System.out.print(b[k][j]+" ");
                    }
                System.out.println();
            }
            return true;
        }
        for(int j = j1;j < 9;j++) {
            if(b[i][j] == 0) {
                for(int val = 1; val < 10; val++) {
                    if(isSafe(b, i, j, val, row, col, d)) {
                        row[i][val - 1] = true;
                        col[j][val - 1] = true;
                        d[((i / n1) * n1) + (j / n1)][val -1] = true;
                        b[i][j] = val;
                        if(place(b, i, j+1, row, col, d))
                            return true;
                        row[i][val -1] = false;
                        col[j][val -1] = false;
                        d[((i / n1) * n1) + (j / n1)][val -1] = false;
                        b[i][j] = 0;
                    }
                }
            }
        }
        if(place(b, i+1, 0, row, col, d))
        return true;
        return false;
    }
    
    public static void solveSudoku(int[][] b) {
        int n = b.length;
        int n1 = (int)Math.sqrt(n);
        boolean  row[][] = new boolean[n][n];
        boolean  col[][] = new boolean[n][n];
        boolean  d[][] = new boolean[n][n];
        for(int i = 0;i < n;i++) {
            
            for(int j = 0;j < n;j++) {
                
                if(b[i][j] != 0) {
                    row[i][b[i][j] - 1] = true;
                    
                    col[j][b[i][j] - 1] = true;
                    
                    d[((i / n1) * n1) + (j / n1)][b[i][j] - 1] = true;
                    
                }
            }
        }
        place(b, 0, 0, row, col, d);
    }
        
	public static void main (String[] args) {
		Scanner sc = new Scanner(System.in);
		int t = sc.nextInt();
		while(t-- > 0) {
		    int b[][] = new int[9][9];
		    for(int i = 0;i < 9;i++) {
		        for(int j = 0;j < 9;j++){
		            b[i][j] = sc.nextInt();
		        }
		    }
		    solveSudoku(b);
		}
	}
}