import java.util.*;
import java.io.*;

public class Cf2036a {
    public static void main(String[] args) {
        FastScanner sc = new FastScanner();
        int t = sc.nextInt();
        while (t-- > 0) {
            int n = sc.nextInt();
            int[] a = new int[n];
            String ans = "YES";
            a[0] = sc.nextInt();
            for (int i = 1; i < n; i++) {
                a[i] = sc.nextInt();
                int x = Math.abs(a[i] - a[i-1]);
                if (!(x == 5 || x == 7)) ans = "NO";
            }
            System.out.println(ans);
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

