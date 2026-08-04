import java.util.*;
import java.io.*;

public class Cf2248b {
    public static void main(String[] args) {
        FastScanner sc = new FastScanner();
        int t = sc.nextInt();
        while (t-- > 0) {
            int n = sc.nextInt(), m = sc.nextInt();
            int[] a = new int[n], b = new int[m];
            for (int i = 0; i < n; i++) a[i] = sc.nextInt();
            for (int i = 0; i < m; i++) b[i] = sc.nextInt();

            Arrays.sort(a);
            Arrays.sort(b);
            if (n < 2*m) {
                System.out.println("NO");
                continue;
            }

            int i = 0;
            while (i < m && a[i] < b[i] && b[i] < a[n-m+i]) i++;

            if (i < m) System.out.println("NO");
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