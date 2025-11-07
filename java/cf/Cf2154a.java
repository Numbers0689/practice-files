import java.util.*;
import java.io.*;

public class Cf2154a {
    public static void main(String[] args) {
        FastScanner sc = new FastScanner();
        int t = sc.nextInt();
        while (t-- > 0) {
            int n = sc.nextInt();
            int k = sc.nextInt();
            String s = sc.next();
            int c = 0, l = -10000;
            for (int i = 0; i < n; i++) {
                if (s.charAt(i) == '1' && i-l > k-1) c++;
                if (s.charAt(i) == '1') l = i;
            }
            System.out.println(c);
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
