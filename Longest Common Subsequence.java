import java.util.*;
import java.lang.*;
import java.io.*;
class GFG {
    public static int dp(String s1, String s2, int n1, int n2, int i, int j, int a[][]) {
        if(i == n1 || j == n2)
        return 0;
        if(a[i][j] != 0)
            return a[i][j];
        if(s1.charAt(i) == s2.charAt(j)) {
            return a[i][j] = dp(s1, s2, n1, n2, i+1, j+1, a) + 1;
        }
        return a[i][j] = Math.max(dp(s1, s2, n1, n2, i+1, j, a),dp(s1, s2, n1, n2, i, j+1, a));
    }
     
	public static void main (String[] args) {
		Scanner sc = new Scanner(System.in);
		int t = sc.nextInt();
		while(t-- > 0){
		    int n1 = sc.nextInt();
		    int n2 = sc.nextInt();
		    String s1 = sc.next();
		    String s2 = sc.next();
		    int a[][] = new int[n1][n2];
		    System.out.println(dp(s1, s2, n1, n2, 0, 0, a));
		}
	}
}