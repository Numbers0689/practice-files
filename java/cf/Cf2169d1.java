import java.util.*;
import java.io.*;

public class Cf2169d1 {
    public static void main(String[] args) {
        FastScanner sc = new FastScanner();
        int t = sc.nextInt();
        while (t-- > 0) {
            long x = sc.nextLong(), y = sc.nextLong(), k = sc.nextLong();
            if (k < y) System.out.println(k);
            else if (x > y || x % y == 0) System.out.println(-1);
            else {
                long m = x%y, r = y;
                for (long i = 0; i <= k-y+1 && i <= 1_000_000_000_000L; i++) {
                    r += m;
                }
                System.out.println(r);
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
    double nextDouble() {
        return Double.parseDouble(next());
    }
}
