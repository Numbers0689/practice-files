import java.util.*;
import java.io.*;

public class Ti1100 {
    public static void main(String[] args) {
        FastScanner sc = new FastScanner();
        int n = sc.nextInt();
        Pair[] p = new Pair[n];
        for (int i = 0; i < n; i++) {
            p[i] = new Pair();
            p[i].a = sc.nextInt();
            p[i].b = sc.nextInt();
        }
        Arrays.sort(p, new Comparator<Pair>() {
            @Override
            public int compare(Pair x, Pair y) {
                return Integer.compare(x.b, y.b);
            }
        });
        for (int i = n-1; i >= 0; i--) {
            System.out.println(p[i].a + " " + p[i].b);
        }
    }
}

class Pair {
    int a;
    int b;
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
