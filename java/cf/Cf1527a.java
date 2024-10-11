import java.util.*;
import java.io.*;

public class Cf1527a {
    public static void main(String[] args) {
        FastScanner sc = new FastScanner();
        int t = sc.nextInt();
        int n, last = 0;
        while (t-- > 0) {
            n = sc.nextInt();
            for (int i = 0; i < 31; i++) {
                if ((n >> i) == 1) last = i;
            }
            System.out.println((1 << last) - 1);
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

