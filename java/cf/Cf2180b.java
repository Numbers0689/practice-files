import java.util.*;
import java.io.*;

public class Cf2180b {
    public static void main(String[] args) {
        FastScanner sc = new FastScanner();
        int t = sc.nextInt();
        while (t-- > 0) {
            int n = sc.nextInt();
            String[] a = new String[n];
            for (int i = 0; i < n; i++) a[i] = sc.next();
            String s = a[0];
            for (int i = 1; i < n; i++) {
                if (s.compareTo(a[i]) < 0) s = s + a[i];
                else s = a[i] + s;
            }
            System.out.println(s);
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