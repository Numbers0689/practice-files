import java.util.*;
import java.io.*;

public class At0001 {
    public static void main(String[] args) {
        FastScanner sc = new FastScanner();
        int n, l, r;
        String s;
        n = sc.nextInt();
        l = sc.nextInt();
        r = sc.nextInt();
        s = sc.next();
        for (int i = l-1; i <= r-1; i++) {
            if (s.charAt(i) != 'o') {
                System.out.println("No");
                return;
            }
        }
        System.out.println("Yes");
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

