import java.util.*;
import java.io.*;

public class Cf2126d {
    static class Casino implements Comparable<Casino> {
        int l, r, real;

        Casino(int l, int real, int r) {
            this.l = l;
            this.real = real;
            this.r = r;
        }

        public int compareTo(Casino other) {
            return Integer.compare(this.l, other.l);
        }
        
    }
    public static void main(String[] args) {
        FastScanner sc = new FastScanner();
        int t = sc.nextInt();
        while (t-- > 0) {
            int n = sc.nextInt(), k = sc.nextInt();
            Casino[] c = new Casino[n];
            for (int i = 0; i < n; i++) {
                int l = sc.nextInt();
                int r = sc.nextInt();
                int real = sc.nextInt();

                c[i] = new Casino(l, real, r);
            }

            Arrays.sort(c);
            int curr = k;
            for (int i = 0; i < n; i++) {
                if (c[i].l > curr) break;
                curr = Math.max(curr, c[i].real);
            }
            System.out.println(curr);
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
            } catch(IOException e) {}
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
