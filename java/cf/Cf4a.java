import java.util.*;
import java.io.*;

public class Cf4a {
    public static void main(String[] args) {
        FastScanner sc = new FastScanner();
        int w = sc.nextInt();
        if (w%2 == 0 && w > 2) System.out.print("YES");
        else System.out.print("NO");
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

