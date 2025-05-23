import java.util.*;
import java.io.*;

public class Cf2044e {
    public static void main(String[] args) {
        FastScanner sc = new FastScanner();
        int t = sc.nextInt();
        while (t-- > 0) {
            int k, l1, r1, l2, r2;
            k = sc.nextInt();
            l1 = sc.nextInt();
            r1 = sc.nextInt();
            l2 = sc.nextInt();
            r2 = sc.nextInt();

            long count = 0;
            long kn = 1;
            while (true) {
                if (l1 * kn > r2) break;
                int lx, rx;
                lx = Math.max(l1);
            }
            System.out.println(count);
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

