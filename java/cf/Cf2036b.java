import java.util.*;
import java.io.*;

public class Cf2036b {
    public static void main(String[] args) {
        FastScanner sc = new FastScanner();
        int t = sc.nextInt();
        int n, k;
        while (t-- > 0) {
            n = sc.nextInt();
            k = sc.nextInt();
            int[] b = new int[k];
            for (int i = 0; i < k; i++) {
                int j = sc.nextInt(), c = sc.nextInt();
                b[j - 1] += c;
            }
            Arrays.sort(b);
            long a = 0;
            for (int i = k-1, count = 0; i >= 0 && count < n; i--, count++) {
                a += b[i];
            }
            System.out.println(a);
        }
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