import java.util.*;
class GFG {
    public static int coin(int b[], int n) {
        int a[] =  new int[n + 1], n1 = b.length;
        a[0] = 1;
        for(int i = 0;i < n1;i++)
        if(b[i] < n) 
            a[b[i]] = 1;
        for(int i = 0;i <= n;i++) {
            for(int x: b) {
                if(i > x && a[i - x] != Integer.MIN_VALUE)
                    a[i] += a[i - x];
            }
        }
        return a[n];
    }
    
	public static void main (String[] args) {
		Scanner sc = new Scanner(System.in);
		int t = sc.nextInt();
		while(t-- > 0) {
		    int n = sc.nextInt();
		    int a[] = new int[n];
		    for(int i = 0;i < n;i++) {
		        a[i] = sc.nextInt();
		    }
		    int num = sc.nextInt();
		    System.out.println(coin(a, num));
		}
	}
}
