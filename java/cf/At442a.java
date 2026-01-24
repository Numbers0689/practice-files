import java.util.*;
import java.io.*;

public class At442a {
    public static void main(String[] args) {
        FastScanner sc = new FastScanner();
            String s = sc.next();
            int ct = 0;
            for (char c : s.toCharArray()) {
                if (c == 'i' || c == 'j') ct++;
            }
            System.out.println(ct);
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
