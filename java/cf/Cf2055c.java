import java.util.*;
import java.io.*;

public class Cf2055c {
    public static void main(String[] args) {
        FastScanner sc = new FastScanner();
        int t = sc.nextInt();
        while (t-- > 0) {
            int n = sc.nextInt(), m = sc.nextInt();
            long[][] a = new long[n][m];
            long[] rowSum = new long[n];
            long[] colSum = new long[m];

            String s = sc.next();

            for (int i = 0; i < n; i++) {
                for (int j = 0; j < m; j++) {
                    a[i][j] = sc.nextLong();
                    rowSum[i] += a[i][j];
                    colSum[j] += a[i][j];
                }
            }

            long su = 0;
            int x = 0, y = 0;
            for (int i = 0; i < n + m - 2; i++) {
                if (s.charAt(i) == 'D') {
                    su = rowSum[x];
                    a[x][y] = -su;
                    colSum[y] -= su;
                    x++;
                } else {
                    su = colSum[y];
                    a[x][y] = -su;
                    rowSum[x] -= su;
                    y++;
                }
                su = 0;
            }

            for (int i = 0; i < n; i++) {
                su += a[i][m-1];
            }
            a[n-1][m-1] = -su;

            for (int i = 0; i < n; i++) {
                for (int j = 0; j < m; j++) System.out.print(a[i][j] + " ");
                System.out.println();
            }
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

