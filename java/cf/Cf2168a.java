import java.util.*;
import java.io.*;

public class Cf2168a {
    public static void main(String[] args) {
        FastScanner sc = new FastScanner();
        String t = sc.next();
        if (t.equals("first")) {
          int n = sc.nextInt();
          int[] a = new int[n];
          for (int i = 0;i < n; i++) {
            a[i] = sc.nextInt();
            System.out.print(((char) (96 + a[i])));
          }
        } else {
          String s = sc.next();
          System.out.println(s.length());
          for (char c : s.toCharArray()) {
            System.out.print((c - '`') + " ");
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
