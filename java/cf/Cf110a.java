import java.util.*;
import java.io.*;

public class Cf110a {
    public static void main(String[] args) {
        FastScanner sc = new FastScanner();
        long n = sc.nextLong();
        int s = 0;
        while (n > 0) {
            long d = n % 10;
            n /= 10;
            if (d == 7 || d == 4) s++;
        }

        if (s == 4 || s == 7) System.out.println("YES");
        else System.out.println("NO");
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

