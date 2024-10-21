import java.util.*;
import java.io.*;

public class Cf2024a {
    public static void main(String[] args) {
        FastScanner sc = new FastScanner();
        int t = sc.nextInt();
        int m, p, x, c;
        for (int i = 0; i < t; i++) {
            m = sc.nextInt();
            p = sc.nextInt();
            if (m >= p) {
                System.out.println(m);
                continue;
            } else {
                x = 0;
                c = 0;
                while (m < p && m > 0) {
                    x++;
                    m--;
                    p = p - 2*x;
                    if (m >= p) {
                        System.out.println(m);
                        c = 1;
                        break;
                    }
                }
            }
            if (m == 0 && c == 0) System.out.println(0);
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

