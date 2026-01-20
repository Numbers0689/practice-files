import java.util.*;
import java.io.*;

public class Cf2185c {
    public static void main(String[] args) {
        FastScanner sc = new FastScanner();
        int t = sc.nextInt();
        while (t-- > 0) {
            int n = sc.nextInt();
            Set<Integer> s = new HashSet<>();
            for (int i = 0; i < n; i++) s.add(sc.nextInt());
            int[] a = new int[s.size()];
            int in = 0;
            for (int i : s) a[in++] = i;
            Arrays.sort(a);
            int curr = 0, ans = 0;
            for (int i = 0; i < a.length; i++) {
                if (i == 0 || a[i] != a[i-1] + 1) curr = 0;
                curr++;
                ans = Math.max(ans, curr);
            }
            System.out.println(ans);
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
