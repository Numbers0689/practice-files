import java.util.*;
import java.io.*;

public class At0002 {
    public static void main(String[] args) {
        FastScanner sc = new FastScanner();
        String s = sc.next();
        boolean f = true;
        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) == '.' && f) {
                System.out.print('o');
                f = false;
            } else if (s.charAt(i) == '#') {
                System.out.print('#');
                f = true;
            } else {
                System.out.print('.');
            }
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

