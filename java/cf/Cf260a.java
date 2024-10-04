import java.util.*;
import java.io.*;

public class Cf260a {
    public static void main(String[] args) {
        FastScanner sc = new FastScanner();
        int a, b, n;
        a = sc.nextInt();
        b = sc.nextInt();
        n = sc.nextInt();
        for (int i = 0; i <= 9; i++) {
            if ((a*10 + i)%b == 0) {
                a = a*10 + i;
                System.out.print(a);
                System.out.print("0".repeat(n-1));
                return;
            } 
        }
        System.out.print(-1);
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

