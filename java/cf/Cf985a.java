import java.util.*;
import java.io.*;

public class Cf985a {
    public static void main(String[] args) {
        FastScanner sc = new FastScanner();
        int t, l, r, k;
        t = sc.nextInt();
        while (t-- > 0) {
            l = sc.nextInt();
            r = sc.nextInt();
            k = sc.nextInt();
            System.out.println(noOps(l, r, k));
        }
    }
    
    public static int noOps(int l, int r, int k) {
        if (k == 1) return r-l+1;
        else if (r/k < l) return 0;
        else return r/k - l + 1;
    }
}

class FastScanner {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    StringTokenizer st = new StringTokenizer("");

    String next() {
        while (!st.hasMoreTokens()) {
            try {
                st = new StringTokenizer(br.readLine());
            } catch (IOException e) {}
        }
        return st.nextToken();
    }

    int nextInt() {
        return Integer.parseInt(next());
    }

    Long nextLong() {
        return Long.parseLong(next());
    }
}