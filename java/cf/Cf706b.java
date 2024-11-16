import java.util.*;
import java.io.*;

public class Cf706b {
    public static void main(String[] args) {
        FastScanner sc = new FastScanner();
        int n = sc.nextInt(), q;
        int[] a = new int[n];
        for (int i = 0; i < n; i++) a[i] = sc.nextInt();
        Arrays.sort(a);
        q = sc.nextInt();
        for (int i = 0; i < q; i++) {
            int x = sc.nextInt();
            if (x < a[0]) {
                System.out.println(0);
                continue;
            }
            System.out.println(bs(x, a, n)+1);
        }
    }

    public static int bs(int x, int[] a, int n) {
        int l = -1, r = n;
        while (l+1 < r) {
            int m = l + (r-l)/2;
            if (x < a[m]) r = m;
            else l = m;
        }

        return l;
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