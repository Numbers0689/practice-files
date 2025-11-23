import java.util.*;
import java.io.*;

public class At433b {
    public static void main(String[] args) {
        FastScanner sc = new FastScanner();
        int n = sc.nextInt();
        int[] a = new int[n];
        for (int i = 0; i < n; i++) a[i] = sc.nextInt();
        int[] r = new int[n];
        for (int i = n-1; i > 0; i--) {
            for (int j = i-1; j >= 0; j--) {
                if (a[i] < a[j]) {
                    r[i] = j+1;
                    break;
                }
            }
        }
        for (int i = 0; i < n; i++) {
            if (r[i] == 0) System.out.println(-1);
            else System.out.println(r[i]);
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
    double nextDouble() {
        return Double.parseDouble(next());
    }
}
