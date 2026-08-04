import java.util.*;
import java.io.*;

public class Cf2254a {
    public static void main(String[] args) {
        FastScanner sc = new FastScanner();
        int t = sc.nextInt();
        while (t-- > 0) {
            int[] a = new int[3];
            for (int i = 0; i < 3; i++) a[i] = sc.nextInt();

            Arrays.sort(a);
            boolean f = true;
            for (int i = 1; i < 3; i++) {
                if (a[i] == a[i-1]) {
                    System.out.println(0);
                    f = false;
                    break;
                }
            }

            if (!f) continue;

            System.out.println(a[2] - a[1] > a[1] - a[0] ? a[1] - a[0] : a[2] - a[1]);
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