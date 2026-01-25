import java.util.*;
import java.io.*;

public class Cf2193b {
    public static void main(String[] args) {
        FastScanner sc = new FastScanner();
        int t = sc.nextInt();
        while (t-- > 0) {
            int n = sc.nextInt();
            int[] a = new int[n];
            Integer[] b = new Integer[n];
            for (int i = 0; i < n; i++) {
                b[i] = a[i] = sc.nextInt();
            }

            Arrays.sort(b, Collections.reverseOrder());
            int r = 0, v = 0, l = 0;
            for (int i = 0; i < n; i++) {
                if (a[i] != b[i] && v == 0) {
                    v = b[i];
                    l = i;
                } else if (v == a[i]) {
                    r = i;
                    break;
                }
            }
            for (int i = 0; i < l; i++) {
                System.out.print(a[i]+ " ");
            }
            for (int i = r; i >= l; i--) {
                System.out.print(a[i] + " ");
            }
            for (int i = r+1; i < n; i++) {
                System.out.print(a[i] + " ");
            }
            System.out.println();
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
