import java.util.*;
import java.io.*;

public class Atdp001 {
    public static void main(String[] args) {
        FastScanner sc = new FastScanner();
        int n = sc.nextInt(), w = sc.nextInt();
        int[] wi = new int[n+1], vi = new int[n+1];
        for (int i = 1; i <= n; i++) {
            wi[i] = sc.nextInt();
            vi[i] = sc.nextInt();
        }

        long[] f = new long[w+1];
        for (int i = 1; i <= n; i++) {
            for (int j = w; j >= wi[i]; j--) f[j] = Math.max(f[j], f[j - wi[i]] + vi[i]);
        }

        System.out.println(f[w]);
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