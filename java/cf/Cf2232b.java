import java.util.*;
import java.io.*;

public class Cf2232b {
    public static void main(String[] args) {
       FastScanner sc = new FastScanner();
       int t = sc.nextInt();
       while (t-- > 0) {
           int n = sc.nextInt();
           int[] a = new int[n];
           for (int i = 0; i < n; i++) a[i] = sc.nextInt();
            long r = Long.MAX_VALUE, s = 0;
            for (int i = 0; i < n; i++) {
                s += a[i];
                r = Math.min(r, s / (i+1));
                System.out.print(r + " ");
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