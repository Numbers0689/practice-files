import java.util.*;
import java.io.*;

public class At442b {
    public static void main(String[] args) {
        FastScanner sc = new FastScanner();
            int q = sc.nextInt();
            int v = 0;
            boolean p = false;
            for (int i = 0; i < q; i++) {
                int a = sc.nextInt();
                switch (a) {
                    case 1:
                        v++;
                        break;
                    case 2:
                        if (v > 0) v--;
                        break;
                    case 3:
                        p = !p;
                        break;
                }
                if (v >= 3 && p) System.out.println("Yes");
                else System.out.println("No");
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
