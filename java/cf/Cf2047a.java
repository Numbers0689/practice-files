import java.util.*;
import java.io.*;

public class Cf2047a {
    public static void main(String[] args) {
        FastScanner sc = new FastScanner();
        int t = sc.nextInt();

        Set<Integer> s = new HashSet<>();
        int k = 1;
        while (k*k <= 100000) {
            s.add(k*k);
            k+=2;
        }

        while (t-- > 0) {
            int n = sc.nextInt();
            int[] a = new int[n];
            for (int i = 0; i < n; i++ ) a[i] = sc.nextInt();
            int r = 0, curr = 0;
            for (int u : a) {
                curr += u;
                if (s.contains(curr)) r++;
            }
            System.out.println(r);
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

