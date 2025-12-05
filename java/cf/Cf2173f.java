import java.util.*;
import java.io.*;

public class Cf2173f {
    public static void main(String[] args) {
        FastScanner sc = new FastScanner();
        int t = sc.nextInt();
        while (t-- > 0) {
            int n = sc.nextInt();
            int q = sc.nextInt();
            int[] a = new int[n];
            for (int i = 0; i < n; i++) a[i] = sc.nextInt();
            for (int i = 0; i < q; i++) {
                int l = sc.nextInt(), r = sc.nextInt(), x = sc.nextInt();
                long cnt = 0, sum = 0;
                for (int j = l-1; j < r; j++) {
                    sum += a[j];
                    if (sum >= x) {
                        sum = 0;
                        cnt++;
                    }
                }
                System.out.println(cnt + " " + sum);
            }
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