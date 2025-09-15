import java.util.*;
import java.io.*;

public class Cf1900a {
    public static void main(String[] args) {
        FastScanner sc = new FastScanner();
        int t = sc.nextInt();
        while (t-- > 0) {
            int n = sc.nextInt();
            String a = sc.next();
            int e = 0, m = 0;
            for (int i = 0; i < n; i++) {
                if (a.charAt(i) == '.') e++;
                else {
                    if (e > 0) m += e/2 + e%2;
                    if (e == 2) m++;
                    if (e > 2) {
                        m = 2;
                        e = 0;
                        break;
                    }
                    e = 0;
                }
            }

            if (e > 0) m += e/2 + e%2;
            if (e == 2) m++;
            if (e > 2) {
                m = 2;
                e = 0;
            }
            System.out.println(m);
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

