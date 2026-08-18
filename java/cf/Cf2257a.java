import java.util.*;
import java.io.*;

public class Cf2257a {
    public static void main(String[] args) {
        FastScanner sc = new FastScanner();
        int t = sc.nextInt();
        while (t-- > 0) {
            int n = sc.nextInt(), m = sc.nextInt();
            boolean[] a = new boolean[26];
            for (int i = 0; i < n; i++) {
                String s = sc.next();
                a[s.charAt(0) - 'a'] = true;
            }
            boolean ok = true;
            for (int i = 0; i < m; i++) {
                String ab = sc.next();
                for (char c : ab.toLowerCase().toCharArray()) {
                    if (!a[c - 'a']) ok = false;
                }
            }

            if (ok) System.out.println("YES");
            else System.out.println("NO");
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