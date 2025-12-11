import java.util.*;
import java.io.*;

public class Cf2176b {
    public static void main(String[] args) {
        FastScanner sc = new FastScanner();
        int t = sc.nextInt();
        while (t-- > 0) {
            int n = sc.nextInt();
            String s = sc.next();
            int m = 0;
            int d = 0;
            for (int i = 0; i < n; i++) {
                if (s.charAt(i) == '0')  {
                    m++;
                } else {
                    d = d < m ? m : d;
                    m = 0;
                }
            }
            d = d < m ? m : d;
            System.out.println(d);
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