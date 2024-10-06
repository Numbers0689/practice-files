import java.util.*;
import java.io.*;

public class Cf2021b {
    public static void main(String[] args) {
        FastScanner sc = new FastScanner();
        
        int t = sc.nextInt();
        
        for (int tc = 0; tc < t; tc++) {
            int n = sc.nextInt();
            int x = sc.nextInt();
            Set<Integer> p = new HashSet<>();

            for (int i = 0; i < n; i++) p.add(sc.nextInt());
            int mex = 0; 

            while (p.contains(mex)) mex++;

            Set<Integer> r = new HashSet<>(p);
            for (int num : p) {
                int u = num;
                while (u < mex) {
                    u += x;
                    r.add(u);
                }
            }
            while (r.contains(mex)) mex++;
            System.out.println(mex);
        }
    }
}

class FastScanner {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    StringTokenizer st = new StringTokenizer("");

    String next() {
        while (!st.hasMoreTokens())
            try {
                st = new StringTokenizer(br.readLine());
            } catch (IOException e) {
                e.printStackTrace();
            }
        return st.nextToken();
    }

    int nextInt() {
        return Integer.parseInt(next());
    }

    long nextLong() {
        return Long.parseLong(next());
    }
}
