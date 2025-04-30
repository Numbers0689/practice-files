import java.util.*;
import java.io.*;

public class Cf2055b {
    public static void main(String[] args) {
        FastScanner sc = new FastScanner();
        int t = sc.nextInt();
        while (t-- > 0) {
            int n = sc.nextInt();
            int[] a = new int[n];
            int[] b = new int[n];
            for (int i = 0; i < n; i++) a[i] = sc.nextInt();
            for (int i = 0; i < n; i++) b[i] = sc.nextInt();
            int neg = 0, ind = -1, min = Integer.MAX_VALUE;
            for (int i = 0; i < n; i++) {
                if (a[i] < b[i]) {
                    neg++;
                    ind = b[i] - a[i];
                } else {
                    min = min < (a[i] - b[i]) ? min : (a[i] - b[i]);
                }
            }

            if (neg > 1) System.out.println("NO");
            else if (neg == 0) System.out.println("YES");
            else if (ind <= min) System.out.println("YES");
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

