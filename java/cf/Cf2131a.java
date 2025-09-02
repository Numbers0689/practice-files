import java.util.*;
import java.io.*;

public class Cf2131a {
    public static void main(String[] args) {
        FastScanner sc = new FastScanner();
        int t = sc.nextInt();

        while (t-- > 0) {
            int n = sc.nextInt();
            int[] a = new int[n], b = new int[n];

            for (int i = 0; i < n; i++) a[i] = sc.nextInt();
            for (int i = 0; i < n; i++) b[i] = sc.nextInt();

            Boolean df = false, ff = false;
            int c = 0;
            do {
                c++;
                df = false;
                ff = false;

                for (int i = 0; i < n; i++) {
                    if (a[i] > b[i] && !df) {
                        a[i]--;
                        df = true;
                    }
                    else if (a[i] < b[i] && !ff) {
                        a[i]++;
                        ff = true;
                    }
                }
            } while(df);
            System.out.println(c);
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

