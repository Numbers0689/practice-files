import java.util.*;
import java.io.*;

public class Cses1146 {
    public static void main(String[] args) {
        FastScanner sc = new FastScanner();
        long t = sc.nextLong();
        long c = 0;
        for (long i = 1; i <= t; i++) {
            long n = i;
            while (n > 0) {
                c += n & 1;
                n = n >> 1;
            }
        }
        System.out.println(c);
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