import java.util.*;
import java.io.*;

public class Cf466A {
    public static void main(String[] args) {
        FastScanner sc = new FastScanner();
        int n, m, a, b;
        n = sc.nextInt();
        m = sc.nextInt();
        a = sc.nextInt();
        b = sc.nextInt();
        if (m*a > b) System.out.print((n/m)*b + Math.min((n%m)*a, b));
        else System.out.print(n*a);
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

