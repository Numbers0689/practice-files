import java.util.*;
import java.io.*;

public class Cf59e {
    public static void main(String[] args) {
        FastScanner sc = new FastScanner();
        int n, m, k;
        ArrayList<ArrayList<Integer>> adj = new ArrayList<>();
        n = sc.nextInt();
        m = sc.nextInt();
        k = sc.nextInt();
        for (int i = 0; i < m; i++) {
            adj.get(sc.nextInt()).add(sc.nextInt());
        }
        for (int u : adj.get(1)) System.out.println(u);
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