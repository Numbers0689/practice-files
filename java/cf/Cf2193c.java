import java.util.*;
import java.io.*;

public class Cf2193c {
    public static void main(String[] args) {
        FastScanner sc = new FastScanner();
        int t = sc.nextInt();
        while (t-- > 0) {
            int n = sc.nextInt();
            int q = sc.nextInt();
            int[] a = new int[n+1], b = new int[n+1];
            for (int i = 1; i <= n; i++) a[i] = sc.nextInt();
            for (int i = 1; i <= n; i++) b[i] = sc.nextInt();
            int m = 0;
            for (int i = n; i >= 1; i--) {
                m = Math.max(m, Math.max(a[i], b[i]));
                a[i] = m;
            }
            for (int i = 1; i <= n; i++) {
                a[i] += a[i-1];
            }
            for (int i = 0; i < q; i++) {
                int l = sc.nextInt(), r = sc.nextInt();
                System.out.print(a[r]-a[l-1] + " ");
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
