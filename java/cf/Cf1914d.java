import java.util.*;
import java.io.*;

public class Cf1914d {
    public static void main(String[] args) {
        FastScanner sc = new FastScanner();
        int t = sc.nextInt();
        while (t-- > 0) {
            int n = sc.nextInt();
            int[] a = new int[n];
            int[] b = new int[n];
            int[] c = new int[n];
            for (int i = 0; i < n; i++) a[i] = sc.nextInt();
            for (int i = 0; i < n; i++) b[i] = sc.nextInt();
            for (int i = 0; i < n; i++) c[i] = sc.nextInt();

            int ans = 0;
            for (int i : get3(a)) {
                for (int j : get3(b)) {
                    for (int k : get3(c)) {
                        if (i != j && i != k && j != k)
                        ans = Math.max(ans, a[i] + b[j] + c[k]);
                    }
                }
            }
            System.out.println(ans);
        }
    }

    private static int[] get3(int[] a) {
        int m1 = -1, m2 = -1, m3 = -1;
        for (int i = 0; i < a.length; i++) {
            if (m1 == -1 || a[i] > a[m1]) {
                m3 = m2;
                m2 = m1;
                m1 = i;
            } else if (m2 == -1 || a[i] > a[m2]) {
                m3 = m2;
                m2 = i;
            } else if (m3 == -1 || a[i] > a[m3]) m3 = i;
        }

        return new int[]{m1, m2, m3};
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