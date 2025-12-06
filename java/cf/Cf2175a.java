import java.util.*;
import java.io.*;

public class Cf2175a {
    public static void main(String[] args) {
        FastScanner sc = new FastScanner();
        int t = sc.nextInt();
        while (t-- > 0) {
            int n = sc.nextInt();
            int[] a = new int[n];
            Set<Integer> s = new HashSet<>();
            for (int i = 0; i < n; i++) {
                a[i] = sc.nextInt();
                s.add(a[i]);
            }
            int x = s.size();
            int e = -1;
            Arrays.sort(a);
            for (int i = 0; i < n; i++) {
                if (a[i] >= x) {
                    e = a[i];
                    break;
                }
            }
            if (e < 0) System.out.println(1000);
            else System.out.println(e);
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