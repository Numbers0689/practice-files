import java.util.*;
import java.io.*;

public class Cf2175b {
    public static void main(String[] args) {
        FastScanner sc = new FastScanner();
        int t = sc.nextInt();
        while (t-- > 0) {
            int n = sc.nextInt();
            int l = sc.nextInt(), r = sc.nextInt();
            int[] p = new int[n+1];
            for (int i = 1; i <= n; i++) {
                p[i] = i;
                if (i == r) p[i] = l-1;
            }

            for (int i = 1; i <= n; i++) {
                System.out.print((p[i] ^ p[i-1]) + " ");
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