import java.util.*;
import java.io.*;

public class Cf1915c {
    public static void main(String[] args) {
        FastScanner sc = new FastScanner();
        int t = sc.nextInt();
        while (t-- > 0) {
            int n = sc.nextInt();
            long s = 0;
            for (int i = 0; i < n; i++) s += sc.nextInt();
            if (bs(s)) System.out.println("YES");
            else System.out.println("NO");
        }
    }

    public static Boolean bs(long x) {
        long l = 0, r = 1000000000;
        while (l <= r) {
            long mid = l + (r - l) / 2;
            if (mid*mid == x) return true;
            else if (mid*mid > x) r = mid - 1;
            else l = mid + 1;
        }
        return false;
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

