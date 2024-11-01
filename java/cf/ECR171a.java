import java.util.*;
import java.io.*;

public class ECR171a {
    public static void main(String[] args) {
        FastScanner sc = new FastScanner();
        int t = sc.nextInt(), x, y, k ;
        for (int i = 0; i < t; i++) {
            x = sc.nextInt();
            y = sc.nextInt();
            k = sc.nextInt();
            if (k <= x && k <= y) {
                System.out.println("0 " + k + " 0 0");
                System.out.println("0 0 0 " + k);
            } else {
                System.out.println("0 " + k + " 0 " + (k-x));
                System.out.println("0 " + (k-y) + " 0 " + k);
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

