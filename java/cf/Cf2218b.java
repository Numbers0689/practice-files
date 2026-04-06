import java.util.*;
import java.io.*;

public class Cf2218b {
    public static void main(String[] args) {
        FastScanner sc = new FastScanner();
        int t = sc.nextInt();
        while (t-- > 0) {
            int n = 7;
            int[] a = new int[n];

            for (int i = 0; i < n; i++) a[i] = sc.nextInt();

            Arrays.sort(a);
            int s = 0;
            for (int i = 0; i < 6; i++) {
                s += -a[i];
            }
            System.out.println(s + a[6]);
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
