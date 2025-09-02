import java.util.*;
import java.io.*;

public class Cf315a {
    public static void main(String[] args) {
        FastScanner sc = new FastScanner();
        int n = sc.nextInt();
        int[] a = new int[1001];
        int[] b = new int[1001];
        int[] c = new int[1001];

        for (int i = 0; i < n; i++) {
            a[i] = sc.nextInt();
            b[i] = sc.nextInt();
            c[b[i]] += 1;
        }
        int co = 0;
        for (int i = 0; i < n; i++) {
            c[b[i]] -= 1;
            if (c[a[i]] == 0) co++;
            c[b[i]] += 1;
        }
        System.out.println(co);
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

