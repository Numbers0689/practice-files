import java.util.*;
import java.io.*;

public class Cf2169a {
    public static void main(String[] args) {
        FastScanner sc = new FastScanner();
        int t = sc.nextInt();
        while (t-- > 0) {
            int n = sc.nextInt();
            int a = sc.nextInt();
            int p = 0, e = 0;
            for (int i = 0; i < n; i++) {
                int c = sc.nextInt();
                if (a > c) e++;
                else if (a < c) p++;
            }
            if (e > p) System.out.println(a-1);
            else if (p > e) System.out.println(a+1);
            else System.out.println(a);
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
