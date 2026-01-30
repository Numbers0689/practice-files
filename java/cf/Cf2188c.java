import java.util.*;
import java.io.*;

public class Cf2188c {
    public static void main(String[] args) {
        FastScanner sc = new FastScanner();
        int t = sc.nextInt();
        while (t-- > 0) {
            int n = sc.nextInt();
            int[] a = new int[n], b = new int[n];
            for (int i = 0; i < n; i++) b[i] = a[i] = sc.nextInt();
            Arrays.sort(b);
            int m = Integer.MAX_VALUE;
            for (int i = 0; i < n; i++) {
                if (b[i] < a[i]) m = Math.min(m, a[i] - b[i]);
            }
            System.out.println(m);
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
