import java.util.*;
import java.io.*;

public class Cf2191a {
    public static void main(String[] args) {
        FastScanner sc = new FastScanner();
        int t = sc.nextInt();
        while (t-- > 0) {
            int n = sc.nextInt();
            Pair[] a = new Pair[n];
            for (int i = 0; i < n; i++) {
                a[i] = new Pair();
                a[i].a = sc.nextInt();
                a[i].b = i%2;
            }
            Arrays.sort(a, new Comparator<Pair>() {
                public int compare(Pair a, Pair b) {
                    return Integer.compare(a.a, b.a);
                }
            });
            int f = 0;
            for (int i = 1; i < n; i++) {
                if (a[i].b == a[i-1].b) {
                    f = 1;
                    break;
                }
            }
            if (f == 1) System.out.println("NO");
            else System.out.println("YES");
        }

    }
}

class Pair {
    public int a, b;
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
