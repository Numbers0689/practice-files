import java.util.*;
import java.io.*;

public class Cf2164b {
    public static void main(String[] args) {
        FastScanner sc = new FastScanner();
        int t = sc.nextInt();
        while (t-- > 0) {
            int n = sc.nextInt();
            int[] a = new int[n];
            for (int i = 0; i < n; i++) a[i] = sc.nextInt();
            boolean f = false;
            outer:
            for (int i = 0; i < n-1; i++) {
                for (int j = i+1; j < n; j++) {
                    if ((a[j]%a[i])%2 == 0) {
                        System.out.println(a[i] + " " + a[j]);
                        f = true;
                        break outer;
                    }
                }
            }
            if (!f) System.out.println(-1);
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
    double nextDouble() {
        return Double.parseDouble(next());
    }
}
