import java.util.*;
import java.io.*;

public class At422d {
    public static void main(String[] args) {
        FastScanner sc = new FastScanner();
        int n = sc.nextInt(), q = sc.nextInt();
        int[] a = new int[n+1];
        int[] ps = new int[n+1];
        for (int i = 1; i <= n; i++) {
            a[i] = sc.nextInt();
            ps[i] = ps[i-1]+a[i];
        }
        for (int i = 0; i < q; i++) {
            int t = sc.nextInt();
            int x, l, r;
            if (t == 1) {
                x = sc.nextInt();
                int tp = a[x];
                a[x] = a[x+1];
                a[x+1] = tp;
                ps[x] = ps[x]-a[x+1]+a[x];
            }
            else {
                l = sc.nextInt();
                r = sc.nextInt();
                long s = ps[r] - ps[l-1];
                System.out.println(s);
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
