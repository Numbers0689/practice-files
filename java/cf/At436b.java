import java.util.*;
import java.io.*;

public class At436b {
    public static void main(String[] args) {
        FastScanner sc = new FastScanner();
        int n = sc.nextInt();
        int[][] a = new int[n][n];
        int r = 0, c = (n-1)/2, k = 1;
        a[r][c] = k;
        for (int i = 0; i < n*n-1; i++) {
            if (a[(r-1+n)%n][(c+1)%n] == 0) {
                r = (r-1+n)%n;
                c = (c+1)%n;
            } else {
                r = (r+1)%n;
            }
            a[r][c] = ++k;
        }
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                System.out.print(a[i][j] + " ");
            }
            System.out.println();
        }
    }
}

class FastScanner {
    BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
    StringTokenizer st=new StringTokenizer("");
    String next() {
        while (!st.hasMoreTokens())
            try { 
                st=new StringTokenizer(br.readLine());				               
            } catch (IOException e) {}
        return st.nextToken();
    }
    
    int nextInt() {
        return Integer.parseInt(next());
    }
    long nextLong() {
        return Long.parseLong(next());
    }
}