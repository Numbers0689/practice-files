import java.util.*;
import java.io.*;

public class Cf2025b {
    public static void main(String[] args) {
        FastScanner sc = new FastScanner();
        int t = sc.nextInt();
        int[] n = new int[t];
        int[] k = new int[t];
        for (int i = 0; i < t; i++) {
            n[i] = sc.nextInt();
        }
        for (int i = 0; i < t; i++) {
            k[i] = sc.nextInt();
        }
        int[][] c = bi();
        for (int i = 0; i < t; i++) {
            System.out.println(c[n[i]][k[i]]);
        }
    }

    public static int[][] bi() {
        int[][] C = new int[100002][100001];
        for (int n = 0; n < 100002; n++) {
            C[n][0] = 1;
            if (n < 101) C[n][n] = 1; 
            for (int k = 1; k < n && k < 101; k++) {
                C[n][k] = (C[n][k - 1] + C[n - 1][k - 1]) % 1000000007;
            }
        }
        return C;
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

