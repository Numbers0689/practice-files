import java.util.*;
import java.io.*;

public class Cf977c {
    public static void main(String[] args) {
        FastScanner sc = new FastScanner();
        int n = sc.nextInt(), k = sc.nextInt(), r, c = 0;
        int[] a = new int[n];
        for (int i = 0; i < n; i++) a[i] = sc.nextInt();
        Arrays.sort(a);
        if (k == 0) r = a[0] - 1;
        else r = a[k-1];
        for (int i = 0; i < n; i++) if (a[i] <= r) c++;
        if (c != k || r < 1) System.out.println(-1);
        else System.out.println(r);
        
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
