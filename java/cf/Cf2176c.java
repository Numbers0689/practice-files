import java.util.*;
import java.io.*;

public class Cf2176c {
    public static void main(String[] args) {
        FastScanner sc = new FastScanner();
        int t = sc.nextInt();
        while (t-- > 0) {
            int n = sc.nextInt();
            Integer[] odd = new Integer[n];
            Integer[] even = new Integer[n];
            int e = 0, o = 0;
            for (int i = 0; i < n; i++) {
                int tm = sc.nextInt();
                if (tm % 2 == 0) even[e++] = tm;
                else odd[o++] = tm;
            }
            Arrays.sort(even, Collections.reverseOrder());
            Arrays.sort(odd, Collections.reverseOrder());
            int[] dp = new int[n];
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