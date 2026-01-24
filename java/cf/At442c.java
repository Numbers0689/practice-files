import java.util.*;
import java.io.*;

public class At442c {
    public static void main(String[] args) {
        FastScanner sc = new FastScanner();
            int n = sc.nextInt(), m = sc.nextInt();
            int[] a = new int[n+1];
            for (int i = 1; i <= m; i++) {
                int ai = sc.nextInt(), bi = sc.nextInt();
                a[ai]++;
                a[bi]++;
            }
            for (int i = 1; i <= n; i++) {
                long s = n-a[i]-1;
                if (s < 3) System.out.print("0 ");
                else System.out.print((s*(s-1)*(s-2)/6) + " ");
            }
            System.out.println();
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
