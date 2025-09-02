import java.util.*;
import java.io.*;

public class Cf59a {
    public static void main(String[] args) {
        FastScanner sc = new FastScanner();
        String s = sc.next();
        int c = 0;
        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) < 96) c++;
        }
        if (s.length() / 2 >= c) System.out.println(s.toLowerCase());
        else System.out.println(s.toUpperCase());
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

