import java.util.*;
import java.io.*;

public class Cf2032a {
    public static void main(String[] args) {
        FastScanner sc = new FastScanner();
        int t = sc.nextInt(), z, o, n;
        while (t-- > 0) {
            n = sc.nextInt();
            z = 0; 
            o = 0;
            for (int i = 0; i < 2*n; i++) {
                if (sc.nextInt() == 1) o++;
                else z++;
            }
            System.out.println((o%2) + " " + (Math.min(z,o)));
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