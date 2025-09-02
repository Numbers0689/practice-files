import java.util.*;
import java.io.*;

public class Cf2131b {
    public static void main(String[] args) {
        FastScanner sc = new FastScanner();
        int t = sc.nextInt();
        while (t-- > 0) {
            int n = sc.nextInt();
            if (n == 2) {
                System.out.println("-1 2");
            } else {
                StringBuilder sb = new StringBuilder("");
                for (int i = 1; i <= n; i++) {
                    if (i == n && i % 2 == 0) sb.append("2");
                    else if (i % 2 == 0) sb.append("3 ");
                    else sb.append("-1 ");
                }
                System.out.println(sb);
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

