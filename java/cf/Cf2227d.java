import java.util.*;
import java.io.*;

public class Cf2227d {
    static int n;
    static int[] a;
    public static void main(String[] args) {
        FastScanner sc = new FastScanner();
        int t = sc.nextInt();
        while (t-- > 0) {
            n = sc.nextInt();
            a = new int[2 * n];
            int x = -1, y = -1;
            for (int i = 0; i < 2 * n; i++) {
                a[i] = sc.nextInt();
                if (a[i] == 0) {
                    if (x >= 0) y = i;
                    else x = i;
                }
            }

            int ans = Math.max(solve(x, x), solve(y, y));
            ans = Math.max(ans, solve((x + y)/2, (x + y + 1)/2));
            System.out.println(ans);
        }
    }

    public static int solve(int l, int r) {
        TreeSet<Integer> s = new TreeSet<>();
        for (int i = 0; i <= n; i++) s.add(i);

        while (l >= 0 && r < 2 * n && a[l] == a[r]) {
            s.remove(a[l]);
            l--;
            r++;
        }

        return s.first();
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
