import java.util.*;
import java.io.*;

public class Cf2189b {
    public static void main(String[] args) {
        FastScanner sc = new FastScanner();
        int t = sc.nextInt();
        while (t-- > 0) {
            int n = sc.nextInt();
            long x = sc.nextLong();
            long m = Long.MIN_VALUE, r = 0;
            for (int i = 0; i < n; i++) {
                long a = sc.nextLong(), b = sc.nextLong(), c = sc.nextLong();
                r += a*(b-1);
                m = Math.max(m, a*b-c);
            }
            if (r >= x) System.out.println(0);
            else if (m <= 0) System.out.println(-1);
            else System.out.println((x-r+m-1)/m);
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
