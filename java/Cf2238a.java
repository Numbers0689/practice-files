import java.util.*;
import java.io.*;

public class Cf2238a {
    public static void main(String[] args) {
        FastScanner sc = new FastScanner();
        int t = sc.nextInt();
        while (t-- > 0) {
            int n = sc.nextInt(), c = sc.nextInt();
            int[] a = new int[n], b = new int[n];
            int res = 0;
            for (int i = 0; i < n; i++) a[i] = sc.nextInt();
            for (int i = 0; i < n; i++) b[i] = sc.nextInt();
            boolean f = false;
            for (int i = 0; i < n; i++) {
                if (a[i] < b[i]) f = true;
                res += a[i] - b[i];
            }

            if (f) {
                f = false;
                Arrays.sort(a);
                Arrays.sort(b);
                res += c;
                for (int i = 0; i < n; i++) {
                    if (a[i] < b[i]) f = true;
                }
            }

            if (f) System.out.println(-1);
            else System.out.println(res);
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
