import java.util.*;
import java.io.*;

public class Cf61a {
    public static void main(String[] args) {
        FastScanner sc = new FastScanner();
        String a = sc.next();
        String b = sc.next();
        StringBuilder r = new StringBuilder("");
        for (int i = 0; i < a.length(); i++) {
            if (a.charAt(i) == b.charAt(i)) r.append("0");
            else r.append("1");
        }
        System.out.println(r.toString());
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

