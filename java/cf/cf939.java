import java.util.*;
import java.io.*;

public class cf939 {
    public static void main(String[] args) {
        FastScanner sc = new FastScanner();
        int n = sc.nextInt();
        int[] a = new int[n];
        for (int i = 0; i < n; i++) a[i] = sc.nextInt();
        for (int i = 1; i <= n; i++) {
            if (a[a[a[i-1]-1]-1] == i) {
                System.out.println("YES");
                return;
            }
        }
        System.out.println("NO");
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