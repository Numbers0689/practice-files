import java.util.*;
import java.io.*;

public class Cf200b {
    public static void main(String[] args) {
        FastScanner sc = new FastScanner();
        int n = sc.nextInt();
        Double[] a = new Double[n];
        Double m = 0.0;
        for (int i = 0; i < n; i++) {
            a[i] = sc.nextDouble();
            m += a[i] / 100.0;
        }
        Double r = (m / (double)n) * 100.0;
        System.out.printf("%.12f", r);
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
