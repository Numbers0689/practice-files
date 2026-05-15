import java.util.*;
import java.io.*;

public class Cf2227c {
    public static void main(String[] args) {
        FastScanner sc = new FastScanner();
        int t = sc.nextInt();
        while (t-- > 0) {
            int n = sc.nextInt();
            int[] a = new int[n];
            for (int i = 0; i < n; i++) a[i] = sc.nextInt();
            List<Integer> l = new ArrayList<>(), r = new ArrayList<>(), s = new ArrayList<>(), rem = new ArrayList<>();
            for (int i = 0; i < n; i++) {
                if (a[i] % 2 == 0 && a[i] % 3 == 0) l.add(a[i]);
                else if (a[i] % 2 == 0) r.add(a[i]);
                else if (a[i] % 3 == 0) s.add(a[i]);
                else rem.add(a[i]);
            }
            for (int i = 0; i < l.size(); i++) {
                System.out.print(l.get(i) + " ");
            }
            for (int i = 0; i < r.size(); i++) {
                System.out.print(r.get(i) + " ");
            }
            for (int i = 0; i < rem.size(); i++) {
                System.out.print(rem.get(i) + " ");
            }
            for (int i = 0; i < s.size(); i++) {
                System.out.print(s.get(i) + " ");
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
