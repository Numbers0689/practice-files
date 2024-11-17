import java.util.*;
import java.io.*;

public class Cf2037b {
    public static void main(String[] args) {
        FastScanner sc = new FastScanner();
        int t = sc.nextInt();
        int k;
        while (t-- > 0) {
            k = sc.nextInt();
            List<Integer> a = new ArrayList<>();
            for (int i = 0; i < k; i++) a.add(sc.nextInt());
            if (k == 3) {
                System.out.println("1 1");
                continue;
            }
            for (int i = 1; i <= ((k-2)/2); i++) {
                if ((k-2) % i == 0 && a.contains(i) && a.contains((k-2)/i)) {
                    System.out.println(i + " " + ((k-2)/i));
                    break;
                }
            }
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