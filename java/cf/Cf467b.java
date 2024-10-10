import java.util.*;
import java.io.*;

public class Cf467b {
    public static void main(String[] args) {
        FastScanner sc = new FastScanner();
        int n, m, k, c =0;
        n = sc.nextInt();
        m = sc.nextInt();
        k = sc.nextInt();
        int[] x = new int[m+1];
        for (int i = 0; i < m+1; i++) {
            x[i] = sc.nextInt();
        }
        for (int i = 0; i < m; i++) {
            if (count(x[i], x[m], n) <= k) c++;
        }
        System.out.print(c);
    }

    public static int count(int x, int b, int n) {
        int a = x ^ b;
        int c = 0;
        for (int i = 0; i < n; i++) {
            if ((a & 1) == 1) c++;
            a >>= 1;
        }
        return c;
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

