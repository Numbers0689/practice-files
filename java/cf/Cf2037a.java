import java.util.*;
import java.io.*;

public class Cf2037a {
    public static void main(String[] args) {
        FastScanner sc = new FastScanner();
        int t = sc.nextInt();
        int n, k;
        while (t-- > 0) {
            n = sc.nextInt();
            int[] a = new int[n];
            for(int i = 0; i < n; i++) a[i] = sc.nextInt();
            k = 0;
            HashSet<Integer> s = new HashSet<>();
            for (int i = 0; i < n-1; i++) {
                for (int j = i+1; j < n; j++) {
                    if (a[i] == a[j] && !s.contains(i) && !s.contains(j)) {
                        k++;
                        s.add(i);
                        s.add(j);
                    }    
                }
            }
            System.out.println(k);
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