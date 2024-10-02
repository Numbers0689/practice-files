
import java.util.*;
import java.io.*;

public class Cf750a {
    public static void main(String[] args) {
        FastScanner sc = new FastScanner();
        int n = sc.nextInt();
        int k = sc.nextInt();
        int c = 240 - k, i;
        for (i = 1; i <= n; i++) {
            c -= 5*i;
            if (c < 0) break;
        }
        System.out.print(i-1);
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