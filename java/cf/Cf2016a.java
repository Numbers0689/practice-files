import java.util.*;
import java.io.*;

public class Cf2016a {
    public static void main(String[] args) {
        FastScanner sc = new FastScanner();
        int t = sc.nextInt();
        while (t-- > 0) {
            int n = sc.nextInt();
            String s = sc.next();
            int o = 0, z = 0;
            for (int i = 0; i < n; i++) {
                if (s.charAt(i) == '1') o++;
                else z++;
            }
            if (o <= 0) System.out.println(z);
            else System.out.println((o-1)*(n-z) + z + o*z);
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

