import java.util.*;
import java.io.*;

public class Cf977b {
    public static void main(String[] args) {
        FastScanner sc = new FastScanner();
        int n = sc.nextInt(), v, mv = 1;
        String s = sc.next(), m, k;
        TreeMap<String, Integer> t = new TreeMap<>();
        m = s.substring(0, 2);
        for (int i = 0; i < n - 1; i++) {
            k = s.substring(i, i + 2);
            if (t.containsKey(k)) {
                v = t.get(k);
                t.put(k, v + 1);
                if ((v+1) > mv) {
                    m = k;
                    mv = v+1;
                }
            }
            else t.put(k, 1);
        }
        System.out.println(m);
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

