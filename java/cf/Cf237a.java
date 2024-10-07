import java.util.*;
import java.io.*;

public class Cf237a {
    public static void main(String[] args) {
        FastScanner sc = new FastScanner();
        int n = sc.nextInt(), h, m, r = 1, t;
        Set<Integer> s = new HashSet<>();
        for (int i = 0; i < n; i++) {
            h = sc.nextInt();
            m = sc.nextInt();
            t = h*100+m;
            if (s.contains(t)) r++;
            else s.add(t);
        }
        System.out.print(r);
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

