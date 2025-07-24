import java.io.*;
import java.util.*;

public class Np1 {
    public static void main(String[] args) {
        FastScanner sc = new FastScanner();
        int n = sc.nextInt();
        int c = sc.nextInt();

        if (c < n-1 || c > ((n*(n+1)/2)-1)) System.out.println("not possible");
        else System.out.println(cons(n, c, 1));
    }

    static String cons(int n, int c, int m) {
        if (n == 1) return Integer.toString(m);
        else {
            if (((c- 1) >= n - 2) && ((c - 1) <= n*(n-1)/2-1)) return Integer.toString(m) + " " +cons(n-1, c-1, m+1);
            else {
                int d = c - n*(n-1)/2+1;
                String y = cons(n-1, c-d, m+1);
                StringBuilder ns = new StringBuilder(Integer.toString(m));
                ns.append(" ");
                ns.append(y);
                StringBuilder ans = new StringBuilder(ns.substring(0, d));
                ans.reverse().toString().concat(ns.substring(d));
                return ans.toString();
            }
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
