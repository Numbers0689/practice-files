import java.util.*;
import java.io.*;

public class Cf2185d {
    public static void main(String[] args) {
        FastScanner sc = new FastScanner();
        int t = sc.nextInt();
        while (t-- > 0) {
            int n = sc.nextInt(), m = sc.nextInt(), h = sc.nextInt();
            int[] a = new int[n], ai = new int[n];
            int[] u = new int[n];
            for (int i = 0; i < n; i++) {
                ai[i] = a[i] = sc.nextInt();
                u[i] = -1;
            }
            int b, c, ui = -1;
            for (int i = 0; i < m; i++) {
                b = sc.nextInt();
                c = sc.nextInt();
                b--;
                int v = u[b] < ui ? ai[b] : a[b];
                if (v + c > h) {
                    ui = i;
                    a[b] = ai[b];
                } else {
                    a[b] = v + c;
                    u[b] = i;
                }

            }
            for (int i = 0; i < n; i++) {
                if (u[i] > ui) System.out.print(a[i] + " ");
                else System.out.print(ai[i] + " ");
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
