import java.util.*;
import java.io.*;

public class Cf233a {
    public static void main(String[] args) {
        FastScanner sc = new FastScanner();
        int n = sc.nextInt();
        if (n % 2 == 1) {
            System.out.println(-1);
            return;
        }

        for (int i = 2, j = 1; i <= n && j <= n; j+=2, i+=2) {
            System.out.print(i + " "+ j + " ");
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
