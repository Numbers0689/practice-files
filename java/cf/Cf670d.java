import java.util.*;
import java.io.*;

public class Cf670d {
    public static void main(String[] args) {
        FastScanner sc = new FastScanner();
        int n = sc.nextInt();
        long k = sc.nextLong();
        long[] a = new long[n];
        long[] b = new long[n];
        for (int i = 0; i < n; i++) a[i] = sc.nextLong();
        for (int i = 0; i < n; i++) b[i] = sc.nextLong();

        long l = 0, r = 2000000000, mid, res = 0;
        while (l <= r) {
            mid = (l + r) / 2;
            if (cur(mid, a, b, k)) {
                res = mid;
                l = mid + 1;
            } else r = mid - 1;
        }

        System.out.println(res);;
    }

    public static boolean cur(long val, long[] a, long[] b, long k) {
        long m = 0;
        for (int i = 0; i < a.length; i++) {
            if (a[i]*val > b[i]) {
                m = val*a[i] - b[i];
                if (m > k) return false;
                k -= m;
            }
        }
        return true;
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