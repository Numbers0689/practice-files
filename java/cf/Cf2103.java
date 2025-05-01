import java.util.*;
import java.io.*;

public class Cf2103 {
    public static void main(String[] args) {
        FastScanner sc = new FastScanner();
        int t = sc.nextInt();
        while (t-- > 0) {
            int n = sc.nextInt();
            String s = sc.next();
            int c = 0;
            for (int i = 0; i < n - 1; i++) {
                if (s.charAt(i) != s.charAt(i+1)) c++;
            }
            int o1 = (s.charAt(0) == '0') ? 0 : 1;
            int o2 = (o1 == 0 && c > 2) ? 1 : 0;
            if (c == 0) System.out.println(n + o1);
            else if (c == 1) System.out.println(n + 1);
            else System.out.println(n + c - 1 - o2);
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

