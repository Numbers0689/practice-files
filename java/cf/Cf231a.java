import java.util.*;
import java.io.*;

public class Cf231a {
    public static void main(String[] args) {
        FastScanner sc = new FastScanner();
        int n = sc.nextInt(), s = 0, c = 0;
        for (int i = 0; i < n; i++) {
            s = 0;
            for (int j = 0; j < 3; j++) s += sc.nextInt();
            if (s > 1) c++;
        }
        System.out.print(c);
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

