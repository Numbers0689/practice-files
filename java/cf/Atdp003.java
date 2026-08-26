import java.util.*;
import java.io.*;

public class Atdp003 {
    public static void main(String[] args) {
        FastScanner sc = new FastScanner();
            int n = sc.nextInt();
            int k = sc.nextInt();
            int[] h = new int[n];
            for (int i = 0; i < n; i++) h[i] = sc.nextInt();
            
            int[] dp = new int[n];
            Arrays.fill(dp, Integer.MAX_VALUE);
            dp[n-1] = 0;
            dp[n-2] = Math.abs(h[n-1] - h[n-2]);
            
            for (int i = n-3; i >= 0; i--) {
                for (int j = 1; i + j < n && j <= k; j++) {
                    dp[i] = Math.min(dp[i], dp[i+j] +  Math.abs(h[i] - h[i+j]));
                }
            }
            
            System.out.println(dp[0]);
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