import java.util.*;
import java.io.*;

public class Cf2169b {
    public static void main(String[] args) {
        FastScanner sc = new FastScanner();
        int t = sc.nextInt();
        while (t-- > 0) {
            String s = sc.next();
            if (s.length() == 1) {
                System.out.println(1);
                continue;
            }
            boolean f = false;
            for (int i = 0; i < s.length() - 1; i++) {
                if ((s.charAt(i) == '>' && s.charAt(i+1) == '*') || (s.charAt(i) == '*' && s.charAt(i+1) == '<') || (s.charAt(i) == '*' && s.charAt(i+1) == '*') || ((s.charAt(i) == '>' && s.charAt(i+1) == '<'))) {
                    f = true;
                }
            }

            if (!f) {
                int m = 0, c = 1;
                boolean b = false;
                for (int i = 0; i < s.length() - 1; i++) {
                    if (s.charAt(i) == s.charAt(i+1)) c++;
                    else if ((s.charAt(i+1) == '*' || s.charAt(i) == '*') && !b) b = true;
                    else {
                        m = Math.max(m, c);
                        c = 1;
                    }
                }
                m = Math.max(m, c);
                if (b) System.out.println(m + 1);
                else System.out.println(m);
            } else System.out.println(-1);
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
    double nextDouble() {
        return Double.parseDouble(next());
    }
}
