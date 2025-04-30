import java.util.*;
import java.io.*;

public class Cf2092a {
    public static void main(String[] args) {
        FastScanner sc = new FastScanner();
        int t = sc.nextInt();
        while (t-- > 0) {
            int n = sc.nextInt();
            int[] a = new int[n];
            int max = 0, min = Integer.MAX_VALUE;
            for (int i = 0; i < n; i++) {
                a[i] = sc.nextInt();
                if (a[i] > max) max = a[i];
                if (a[i] < min) min = a[i];
            }
            System.out.println(max - min);
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

