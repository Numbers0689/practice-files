import java.util.*;
import java.io.*;

public class Cf2155a {
    public static void main(String[] args) {
        FastScanner sc = new FastScanner();
        int t = sc.nextInt();
        while (t-- > 0) {
            int n = sc.nextInt();
            int w = n, l = 0, c = 0;
            while (w > 1 || l > 1) {
                if (l > 1) {
                    c += l/2;
                    l = l/2 + l%2;
                }
                if (w > 1) {
                    c += w/2;
                    l += w/2;
                    w = w/2 + w%2;
                }
            }
            System.out.println(c+1);
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
