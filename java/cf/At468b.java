import java.util.*;
import java.io.*;

public class At468b {
    public static void main(String[] args) {
        FastScanner sc = new FastScanner();
        int m = sc.nextInt(), d = sc.nextInt();
        String s = sc.next();
        int uv = 0, pre = -1, cc = 0;
        for (int i = 0; i < s.length(); i++) {
            if (pre == -1 && s.charAt(i) == '.') {
                uv++;
                cc++;
                continue;
            } 
            
            if (s.charAt(i) == 'G') {
                pre = i;
                uv -= Math.min(d, cc);
                cc = 0;
            } else if (i - pre > d) {
                cc++;
                uv++;
            }
        }

        System.out.println(uv);

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
    double nextDouble() {
        return Double.parseDouble(next());
    }
}
