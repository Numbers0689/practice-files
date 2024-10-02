import java.util.*;
import java.io.*;

public class Cf71A {
    public static void main(String[] args) {
        FastScanner sc = new FastScanner();
        int n = sc.nextInt(), l;
        String s;
        for (int i = 0; i < n; i++) {
            s = sc.next();
            l = s.length();
            if (l > 10) System.out.println(s.charAt(0) + Integer.toString(l-2) + s.charAt(l-1));
            else System.out.println(s);
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

