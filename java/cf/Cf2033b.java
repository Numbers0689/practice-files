import java.util.*;
import java.io.*;

public class Cf2033b {
    public static void main(String[] args) {
        FastScanner sc = new FastScanner();
        int t = sc.nextInt();
        int r, min;
        for (int c = 0; c < t; c++) {
            int n = sc.nextInt();
            int a[][] = new int[n][n];
            r = 0;
            for (int i = 0; i < n; i++) 
                for (int j = 0; j < n; j++)
                    a[i][j] = sc.nextInt();

            for (int s = 0; s < n; s++) {
                int i = 0, j = s;
                min = 0;
                while (i < n && j < n) {
                    if (a[i][j] < min) min = a[i][j];
                    i++;
                    j++;
                }
                r += Math.abs(min);
            }
            for (int s = 1; s < n; s++) {
                int i = s, j = 0;
                min = 0;
                while (i < n && j < n) {
                    if (a[i][j] < min) min = a[i][j];
                    i++;
                    j++;
                }
                r += Math.abs(min);
            }
            System.out.println(r);
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

