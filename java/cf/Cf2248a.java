import java.util.*;
import java.io.*;

public class Cf2248a {
    public static void main(String[] args) {
        FastScanner sc = new FastScanner();
        int t = sc.nextInt();
        while (t-- > 0) {
            char[] s = sc.next().toCharArray();
            boolean f1 = true, f0 = true;
            
            for (int i = 0; i < s.length; i++) {
                if (f1 && s[i] == '1') {
                    f1 = false;
                    continue;
                }
                if (f0 && s[i] == '0') {
                    f0 = false;
                    continue;
                }
                System.out.print(s[i]);
            }
            System.out.println();
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