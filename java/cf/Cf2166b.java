import java.util.*;
import java.io.*;

public class Cf2166b {
    public static void main(String[] args) {
        FastScanner sc = new FastScanner();
        int t = sc.nextInt();
        while (t-- > 0) {
            long a = sc.nextInt(), b = sc.nextInt(), n = sc.nextInt();
            int c = 0;
            if (b >= a) {
                System.out.println(1);
                continue;
            }
            if (b*n > a) {
                n = a / b;
                c++;
            }
            if (b*n <= a) {
                c++;
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
