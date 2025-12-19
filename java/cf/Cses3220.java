import java.util.*;
import java.io.*;

public class Cses3220 {
    public static void main(String[] args) {
        FastScanner sc = new FastScanner();
        int n = sc.nextInt(), k = sc.nextInt();
        long x = sc.nextInt(), a = sc.nextInt(), b = sc.nextInt(), c = sc.nextInt();
        long[] xi = new long[n+1];
        xi[1] = x;
        for (int i = 2; i <= n; i++) {
            xi[i] = (a*xi[i-1]+b)%c;
        }

        for (int i = 2; i <= n; i++) xi[i] += xi[i-1];
        long s = 0;
        for (int i = k; i <= n; i++) {
            s ^= xi[i] - xi[i-k];
        }
        System.out.println(s);
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