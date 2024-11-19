import java.util.*;
import java.io.*;

public class Cf2037c {
    public static void main(String[] args) {
        FastScanner sc = new FastScanner();
        int t = sc.nextInt(); 
        while (t-- > 0) {
            int n = sc.nextInt();
            if (n < 5) {
                System.out.println(-1);
                continue;
            }
            for (int i = 2; i < n+1; i+=2) if (i != 4) System.out.print(i + " ");
            System.out.print("4 5 ");
            for(int i = 1; i < n+1; i+=2) if (i != 5) System.out.print(i + " ");
            System.out.println();
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
}
