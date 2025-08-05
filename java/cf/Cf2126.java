import java.util.*;
import java.io.*;

public class Cf2126 {
    public static void main(String[] args) {
        FastScanner sc = new FastScanner();
        int t = sc.nextInt();

        while (t-- > 0) {
            int n = sc.nextInt(), k = sc.nextInt();
            int[] h = new int[n+1];
            for (int i = 1; i <= n; i++) h[i] = sc.nextInt();
            int s = h[k];
            Arrays.sort(h);
            int w = 0;
            for (int i = 1; i <= n; i++) {
                if (h[i] > s) {
                    w += h[i] - s;
                    if (w > s) {
                        System.out.println("NO");
                        break;
                    } else s = h[i];
                }
            }
            if (s == h[n]) System.out.println("YES");
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

