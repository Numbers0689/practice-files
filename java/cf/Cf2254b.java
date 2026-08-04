import java.util.*;
import java.io.*;

public class Cf2254b {
    public static void main(String[] args) {
        FastScanner sc = new FastScanner();
        int t = sc.nextInt();
        while (t-- > 0) {
            int n = sc.nextInt();
            String s = sc.next();

            int c = 1;
            for (int i = 1; i < n; i++) {
                if (s.charAt(i) == s.charAt(i-1)) continue;
                c++;
            }
            boolean fix = false, fix1 = false;
            for (int i = 1; i < n-1; i++) {
                if (s.charAt(i-1) == s.charAt(i+1) && s.charAt(i) != s.charAt(i-1) && s.charAt(i) != s.charAt(i+1)) {
                    fix = true;
                    break;
                }

                if (s.charAt(i) != s.charAt(i-1) && s.charAt(i) != s.charAt(i+1) && s.charAt(i-1) != s.charAt(i+1)) fix1 = true;
            }

            if (fix) System.out.println(c-2);
            else if (fix1) System.out.println(c-1);
            else System.out.println(c);
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