import java.util.*;
import java.io.*;

public class Cf977a {
    public static void main(String[] args) {
        FastScanner sc = new FastScanner();
        int n = sc.nextInt(), k = sc.nextInt();
        for (int i = 0; i < k; i++) {
            if (n % 10 != 0) n--;
            else n /= 10;
        }
        System.out.print(n);
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

