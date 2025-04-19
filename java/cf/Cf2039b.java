import java.util.*;
import java.io.*;

public class Cf2039b {
    public static void main(String[] args) {
        FastScanner sc = new FastScanner();
        int t = sc.nextInt();
        while (t-- > 0) {
            String s = sc.next();
            int c = 0;
            boolean p = false;
            for (int i = s.length() - 1; i >= 0; i--) {
                if (s.charAt(i) != '0') p = true;
                else if (p) c++;
            }
            System.out.println(s.length()-c-1);
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

