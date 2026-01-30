import java.util.*;
import java.io.*;

public class Cf2188a {
    public static void main(String[] args) {
        FastScanner sc = new FastScanner();
        int t = sc.nextInt();
        while (t-- > 0) {
            int n = sc.nextInt();
            int m = 0;
            if (n%2 == 0) m = n/2;
            else m = (n+1)/2;
            int x = m+1;
            int i = 1;
            while (m > 0 || x <= n) {
                if (i %2 == 1 && m > 0) {
                    System.out.print(m + " ");
                    m--;
                }
                else if (x <= n) {
                    System.out.print(x + " ");
                    x++;
                }
                i++;

            }
            System.out.println();
        }
    }
}

class Pair {
    int a;
    int b;
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
