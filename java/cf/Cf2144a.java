import java.util.*;
import java.io.*;

public class Cf2144a {
    public static void main(String[] args) {
        FastScanner sc = new FastScanner();
        int t = sc.nextInt();
        while (t-- > 0) {
            int n = sc.nextInt();
            int[] a = new int[n];
            for (int i = 0; i < n; i++) a[i] = sc.nextInt();
            int s = 0;
            for (int i : a) s += i;
            if (s%3 != 0) {
                System.out.println("0 0");
                continue;
            }
            int s1 = a[0] % 3, r = -1, s2 = 0;
            for (int i = 1; i < n; i++) {
                s2 += a[i];
                if (s2%3 != s1 || (s2 % 3 == 0 && s1 == 0)) {
                    r = i + 1;
                    break;
                }
            }
            System.out.println("1 " + r);
            
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

