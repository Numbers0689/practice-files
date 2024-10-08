import java.util.*;
import java.io.*;

public class Cses1 {
    public static void main(String[] args) {
        FastScanner sc = new FastScanner();
        int n = sc.nextInt();
        Set<Integer> h = new HashSet<Integer>();
        for (int i = 0; i < n; i++) {
            h.add(sc.nextInt());
        }
        System.out.print(h.size());
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
