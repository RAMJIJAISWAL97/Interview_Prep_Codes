class Sudoku
{
    
    public static boolean safe(int b[][], int i, int j, int n, int num) {
        for(int x = 0; x < n;x++) {
            if(b[x][j] == num || b[i][x] == num) {
                return false;
            }
        }
        int rn = (int)Math.sqrt(n);
        int sx = (i/rn)*rn;
        int sy = (j/rn)*rn;
        for(int x = sx; x < sx+rn;x++) {
            for(int y = sy; y < sy+rn;y++) {
                if(b[x][y] == num)
                    return false;
            }
        }
        return true;
    }
    
    public static boolean place(int b[][], int i, int j, int n) {
        //System.out.print(i+" ");
        if(i == n) {
            for(int k = 0;k < n;k++) {
                for(int j1 = 0;j1 < n;j1++) { 
                        System.out.print(b[k][j1]+" ");
                    }
                //System.out.println();
            }
            return true;
        }
        
        if(j == n) {
            return place(b, i+1, 0, n);
        }
        if(b[i][j] != 0) 
            return place(b, i, j+1, n);
            
        for(int num = 1; num < 10;num++) {
            if(safe(b, i, j, n, num)) {
                b[i][j] = num;
                if(place(b, i, j+1, n))
                return true;
            }
        }
        b[i][j] = 0;
        return false;
    }
    static void printGrid(int a[][]) {
        //System.out.println();
    }
    
    static boolean SolveSudoku(int b[][])
    {
            return place(b, 0, 0, 9);
    }
    
}

