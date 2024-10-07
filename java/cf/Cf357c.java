import java.util.*;
import java.io.*;

public class Cf357c {
    public static void main(String[] args) {
        FastScanner sc = new FastScanner();
        int n, m;
        int[] f = new int[3];
        n = sc.nextInt();
        m = sc.nextInt();
        int[] s = new int[n+1];
        for (int i = 0; i < m; i++) {
            f[0] = sc.nextInt();
            f[1] = sc.nextInt();
            f[2] = sc.nextInt();
            for (int j = f[0]; j <= f[1]; j++) {
                if (j == f[2]) continue;
                if (s[j] == 0) s[j] = f[2];
            }
        }

        for (int i = 1; i <= n; i++) {
            if (s[i] != 0) System.out.print(s[i] + " ");
            else System.out.print("0 ");
        }
    }
}

class FastScanner {
    BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
    StringTokenizer st=new StringTokenizer("");
    String next() {
        while (!st.hasMoreTokens())
            try { 
                st=new StringTokenizer(br.readLine());				               
            } catch (IOException e) {}
        return st.nextToken();
    }
    
    int nextInt() {
        return Integer.parseInt(next());
    }
    long nextLong() {
        return Long.parseLong(next());
    }
}
