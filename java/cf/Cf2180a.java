import java.util.*;
import java.io.*;

public class Cf2180a {
    public static void main(String[] args) {
        FastScanner sc = new FastScanner();
        int t = sc.nextInt();
        while (t-- > 0) {
            int l = sc.nextInt(), a = sc.nextInt(), b = sc.nextInt();
            Set<Integer> s = new HashSet<>();
            int m = a;
            a = (a+b) % l;
            while (!s.contains(a)) {
                m = Math.max(m, a);
                s.add(a);
                a = (a+b) % l;
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