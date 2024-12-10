import java.util.*;
import java.io.*;

public class Cf2050a {
    public static void main(String[] args) {
        FastScanner sc = new FastScanner();
        int t = sc.nextInt();
        int n,m;
        while(t-- > 0) {
            n = sc.nextInt();
            m = sc.nextInt();
            int x = 0;
            String s;
            for (int i = 0; i < n; i++) {
                s = sc.next();
                m -= s.length();
                if (m >= 0) x++;
            }
            System.out.println(x);
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

