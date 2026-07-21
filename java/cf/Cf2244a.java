import java.util.*;
import java.io.*;

public class Cf2244a {
    public static void main(String[] args) {
        FastScanner sc = new FastScanner();
        int t = sc.nextInt();
        while (t-- > 0) {
            int n = sc.nextInt();
            String s = sc.next();
            int c = 0, m = 0;
            for (int i = 0; i < n; i++) {
                if (s.charAt(i) == '#') c++;
                else {
                    m = Math.max(c, m);
                    c = 0;
                }
            }
            m = Math.max(c, m);
            System.out.println(m/2 + (m%2));
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