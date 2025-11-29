import java.util.*;
import java.io.*;

public class Cf2170a {
    public static void main(String[] args) {
        FastScanner sc = new FastScanner();
        int t = sc.nextInt();
        while (t-- > 0) {
            int n = sc.nextInt();
            if (n == 1) System.out.println(1);
            else if (n == 2) System.out.println(9);
            else if (n == 3) System.out.println(29);
            else if (n == 4) System.out.println(56);
            else {
                int x = (n-1)*n - 1;
                int s = 5*x;
                System.out.println(s);
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