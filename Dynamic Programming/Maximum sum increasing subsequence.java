import java.util.*;
import java.lang.*;
import java.io.*;
class GFG {
    public static long dp(int a[], int n) {
        int max = a[0];
        int b[] = new int[n];
        b[0] = a[0];
        for(int i = 1;i < n;i++) {
            b[i] = a[i];
            for(int j = 0;j < i;j++) {
                if(a[j] < a[i]) {
                    b[i] = Math.max(Math.max(b[j], 0) + a[i], b[i]);
                }
                max = Math.max(b[i], max);
            }
        }
        return max;
    }
     
	public static void main (String[] args) {
		Scanner sc = new Scanner(System.in);
		int t = sc.nextInt();
		while(t-- > 0){
		    int n = sc.nextInt();
		    int a[] = new int[n];
		    for(int  i = 0;i < n;i++) {
		        a[i] = sc.nextInt();
		    }
		    System.out.println(dp(a, n));
		}
	}
}