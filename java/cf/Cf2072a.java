import java.util.*;
import java.io.*;

public class Cf2072a {
    public static void main(String[] args) {
        FastScanner sc = new FastScanner();
        int t = sc.nextInt();
        int n, k, p;
        while(t-- > 0) {
            n = sc.nextInt();
            k = sc.nextInt();
            p = sc.nextInt();

            int x = Math.abs(k) / Math.abs(p);
            if (x > n) System.out.println(-1);
            else if (x == n && Math.abs(k) % Math.abs(p) == 0) System.out.println(x);
            else if (x == n && Math.abs(k) % Math.abs(p) != 0) System.out.println(-1);
            else if (x < n) {
                if (Math.abs(k) % Math.abs(p) == 0) System.out.println(x);
                else System.out.println(x + 1);
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

