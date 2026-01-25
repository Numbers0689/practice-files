import java.util.*;
import java.io.*;

public class Cf2193a {
    public static void main(String[] args) {
        FastScanner sc = new FastScanner();
        int t = sc.nextInt();
        while (t-- > 0) {
            int n = sc.nextInt();
            int s = sc.nextInt();
            int x = sc.nextInt();
            int sum = 0;
            for (int i = 0; i < n; i++) sum += sc.nextInt();
            if (sum > s) System.out.println("NO");
            else if (sum == s) System.out.println("YES");
            else if ((s - sum) % x == 0) System.out.println("YES");
            else System.out.println("NO");
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
