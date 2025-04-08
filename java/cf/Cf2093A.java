import java.util.*;
import java.io.*;

public class Cf2093A {
    public static void main(String[] args) {
        FastScanner sc = new FastScanner();
        int k, t = sc.nextInt();
        while (t-- > 0) {
            k = sc.nextInt();
            if (k%2 == 0) System.out.println("NO");
            else System.out.println("YES");
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

