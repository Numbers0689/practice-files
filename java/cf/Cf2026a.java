import java.util.*;
import java.io.*;

public class Cf2026a {
    public static void main(String[] args) {
        FastScanner sc = new FastScanner();
        int t = sc.nextInt(), n, x, j;
        for (int i = 0; i < t; i++) {
            n = sc.nextInt();
            j = 0;
            x = 0;
            while (n >= Math.abs(x)) {
                j++;
                if (j % 2 == 0) x += 2*j-1;
                else x -= (2*j-1);
            }
            if (j % 2 == 0) System.out.println("Kosuke");
            else System.out.println("Sakurako");
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

