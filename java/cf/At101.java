import java.util.*;
import java.io.*;

public class At101 {
    public static void main(String[] args) {
        FastScanner sc = new FastScanner();
        String s = sc.next();
        if (s.substring(s.length()-3).equals("san")) System.out.print("Yes");
        else System.out.print("No");
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

