import java.util.*;
import java.io.*;

public class Cf80a {
    public static void main(String[] args) {
        FastScanner sc = new FastScanner();
        int n = sc.nextInt(), m = sc.nextInt();
        for (int i = n+1; i <= m; i++) {
            int p = 1;
            for (int j = 2; j < i; j++) {
                if (i%j == 0) {
                    p = 0;
                    break;
                }
            }
            if (p == 1 && i == m) {
                System.out.println("YES");
                return;
            } else if (p == 1 && i != m) break;
        }
        System.out.println("NO");
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

