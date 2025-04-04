import java.util.*;
import java.io.*;

public class Cf2065b {
    public static void main(String[] args) {
        FastScanner sc = new FastScanner();
        int t = sc.nextInt();

        while (t-- > 0) {
            String s = sc.next();
            boolean f = false;
            for (int i = 1; i < s.length(); i++) {
                if (s.charAt(i) == s.charAt(i-1)) {
                    f = true;
                }
            }

            if (f) System.out.println(1);
            else System.out.println(s.length());
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

