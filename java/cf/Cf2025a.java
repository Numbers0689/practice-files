import java.util.*;
import java.io.*;

public class Cf2025a {
    public static void main(String[] args) {
        FastScanner sc = new FastScanner();
        int tc = sc.nextInt();
        String s, t;
        for (int i = 0; i < tc; i++) {
            s = sc.next();
            t = sc.next();
            int j = 0, k = 0, c = 0, sl = s.length(), tl = t.length(), m = 0;
            while (j < sl && k < tl) {
                if (s.charAt(j) == t.charAt(k)) {
                    c++;
                    j++;
                    k++;
                } else if (c > 0) {
                    c++;
                    m = 1;
                    break;
                } else break;
            }
            if ((k == tl || j == sl) && (c > 0) && (m == 0)) c++;
            c += (sl - j) + (tl - k);
            System.out.print(c);
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

