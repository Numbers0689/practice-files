import java.util.*;
import java.io.*;

public class Cf2020a {
    public static void main(String[] args) {
        FastScanner sc = new FastScanner();
        int t = sc.nextInt();
        int n, k, c;
        for (int i = 0; i < t; i++) {
            n = sc.nextInt();
            k = sc.nextInt();
            c = 0;
            if (k == 1 || n < k) {
                System.out.println(n); 
                continue;
            }
            while (n > 0) {
                c += n%k;
                n /= k;
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
}

