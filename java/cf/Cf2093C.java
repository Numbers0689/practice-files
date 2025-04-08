import java.util.*;
import java.io.*;

public class Cf2093C {
    public static void main(String[] args) {
        FastScanner sc = new FastScanner();
        int x, k, t = sc.nextInt();
        while (t-- > 0) {
            x = sc.nextInt();
            k = sc.nextInt();

            if (isPrime(x) && k == 1) System.out.println("YES");
            else System.out.println("NO");
        }
    }

    public static boolean isPrime(int x) {
        if (x < 2) return false;
        long val = x;
        for (long i = 2; i * i <= val; i++) {
            if (val % i == 0) return false;
        }
        return true;
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

