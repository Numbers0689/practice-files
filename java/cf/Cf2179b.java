import java.util.*;
import java.io.*;

public class Cf2179b {
    public static void main(String[] args) {
        FastScanner sc = new FastScanner();
        int t = sc.nextInt();
        while (t-- > 0) {
            int n = sc.nextInt();
            int[] a = new int[n];
            for (int i = 0; i < n; i++) a[i] = sc.nextInt();

            int ms = 0;
            for (int i = 1; i < n; i++) ms += Math.abs(a[i] - a[i-1]);

            int cs = 0, f = Integer.MAX_VALUE;
            for (int i = 0; i < n; i++) {
                if (i == 0) cs = ms - Math.abs(a[i] - a[i+1]);
                else if (i == n - 1) cs = ms - Math.abs(a[i] - a[i-1]);
                else cs = ms - Math.abs(a[i-1] - a[i]) - Math.abs(a[i] - a[i+1]) + Math.abs(a[i-1] - a[i+1]); 

                if (cs < f) f = cs;
            }
            System.out.println(f);
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