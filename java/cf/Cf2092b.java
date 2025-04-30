import java.util.*;
import java.io.*;

public class Cf2092b {
    public static void main(String[] args) {
        FastScanner sc = new FastScanner();
        int t = sc.nextInt();
        while (t-- > 0) {
            int n = sc.nextInt();
            String a = sc.next(), b = sc.next();
            int c1 = 0, c2 = 0;
            for (int i = 0; i < n; i++) {
                if (i % 2 == 0) {
                    if (a.charAt(i) == '0') c1++;
                    if (b.charAt(i) == '0') c2++;
                } else {
                    if (a.charAt(i) == '0') c2++;
                    if (b.charAt(i) == '0') c1++;
                }
            }

            if (c1 >= (n + 1) / 2 && c2 >= n / 2) System.out.println("YES");
            else System.out.println("NO");
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

