import java.util.*;
import java.io.*;

public class Cf2051d {
    public static void main(String[] args) {
        FastScanner sc = new FastScanner();
        int t = sc.nextInt();
        int r[] = new int[t];
        while (t-- > 0) {
            int n, x, y;
            n = sc.nextInt();
            x = sc.nextInt();
            y = sc.nextInt();

            int[] a = new int[n];
            int sum = 0;
            for (int i = 0; i < n; i++) {
                a[i] = sc.nextInt();
                sum += a[i];
            }

            if (sum <= x) {
                System.out.println(0);
                continue;
            }

            int c = 0;

            for (int i = 0; i < n-1; i++) {
                for (int j = i+1; j < n; j++) {
                    int m = (sum - (a[i] + a[j]));
                    if (m <= y || m >= x ) {
                        c++;
                    }
                }
            }

            r[t] = c;
        }
        for (int e : r) System.out.println(e);
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

