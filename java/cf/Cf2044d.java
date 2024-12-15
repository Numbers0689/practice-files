import java.util.*;
import java.io.*;

public class Cf2044d {
    public static void main(String[] args) {
        FastScanner sc = new FastScanner();
        int t = sc.nextInt();
        while (t-- > 0) {
            int n = sc.nextInt();
            List<Integer> a = new ArrayList<>();
            Set<Integer> s = new HashSet<>();
            for (int i = 0; i < n; i++) {
                a.add(sc.nextInt());
                s.add(a.get(i));
            }
            int m = 0;
            for (int i = 0; i < n; i++) {
                
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

