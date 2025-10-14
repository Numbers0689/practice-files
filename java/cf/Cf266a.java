import java.util.*;
import java.io.*;

public class Cf266a {
    public static void main(String[] args) {
        FastScanner sc = new FastScanner();
        int n = sc.nextInt();
        String s = sc.next();
        if (n == 1) {
            System.out.println(0);
            return;
        }
        int c = 0;
        for (int i = 1; i < n; i++) {
            if (s.charAt(i) == s.charAt(i-1)) c++;
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

