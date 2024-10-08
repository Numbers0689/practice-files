import java.util.*;
import java.io.*;

public class Cf237a {
    public static void main(String[] args) {
        FastScanner sc = new FastScanner();
        int n = sc.nextInt();
        int h, m, h0, m0, c = 1, max = 1;
        h = sc.nextInt();
        m = sc.nextInt();
        while (--n > 0) {
            h0 = sc.nextInt();
            m0 = sc.nextInt();
            if (h == h0 && m == m0) c++;
            else {
                c = 1;
                h = h0;
                m = m0;
            }
            if (c > max) max = c;
        }
        System.out.print(max);
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

