import java.util.*;
import java.io.*;

public class Cf2189a {
    public static void main(String[] args) {
        FastScanner sc = new FastScanner();
        int t = sc.nextInt();
        while (t-- > 0) {
            int n = sc.nextInt(), h = sc.nextInt(), l = sc.nextInt();
            int k = 0, gk = 0, g = Math.max(l, h);
            for (int i = 0; i < n; i++) {
                int a = sc.nextInt();
                if (a <= l && a <= h) k++;
                else if (a <= g) gk++;
            }
            if (gk >= k) System.out.println(k);
            else System.out.println((k-gk)/2+gk);
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
