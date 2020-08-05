import java.util.*;
class GFG {
    public static long dp(int n, int x, int y, int z) {
        if(n < 0)
        return Integer.MIN_VALUE;
        if(n == 0)
        return 0;
        return 1 + Math.max(Math.max(dp(n - x, x,y,z),dp(n - y, x,y,z)), dp(n - z, x,y,z));
    }
    
    public static long dp1(int n, int x, int y, int z) {
            int a[] = new int[n + 1];
            Arrays.fill(a, Integer.MIN_VALUE);
            if(x <= n)
            a[x] = 1; 
            if(y <= n)
            a[y] = 1; 
            if(z <= n)
            a[z] = 1;
            for(int i = 0;i < n+1;i++) {
                if(i > x && a[i - x] != Integer.MIN_VALUE)
                    a[i] = Math.max(a[i], a[i - x] + 1);
                if(i > y && a[i - y] != Integer.MIN_VALUE)
                    a[i] = Math.max(a[i], a[i - y] + 1);
                if(i > z && a[i - z] != Integer.MIN_VALUE)
                    a[i] = Math.max(a[i], a[i - z] + 1);
            }
            return a[n];   
        } 
    
	public static void main (String[] args) {
		Scanner sc = new Scanner(System.in);
		int t = sc.nextInt();
		while(t-- > 0){
		    int n =sc.nextInt();
		    int x =sc.nextInt();
		    int y =sc.nextInt();
		    int z =sc.nextInt();
		    System.out.println(dp1(n, x, y, z));
		}
	}
}