import java.util.*;
import java.io.*;

public class At102 {
    public static void main(String[] args) {
        FastScanner sc = new FastScanner();
        String s = sc.next();
        String t = sc.next();
        if (s.equals(t)) System.out.print(0);
        else {
            int i = 0, j = 0;
            while (i < s.length() && j < t.length()) {
                if (s.charAt(i) != t.charAt(j)) {
                    System.out.print(i+1);
                    return;
                }
                i++;
                j++;
            }
            System.out.print(i+1);
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

