import java.util.*;
import java.io.*;

public class Cf2132 {
    public static void main(String[] args) {
        FastScanner sc = new FastScanner();
        int t = sc.nextInt();
        while (t-- > 0) {
            int n = sc.nextInt();
            String a = sc.next();
            int m = sc.nextInt();
            String b = sc.next();
            String c = sc.next();

            StringBuilder ans = new StringBuilder(a);
            for (int i = 0; i < b.length(); i++) {
                if (c.charAt(i) == 'V') {
                    ans.insert(0, b.charAt(i));
                } else ans.append(b.charAt(i));
            }
            System.out.println(ans.toString());
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

