import java.util.*;
import java.io.*;

public class Cf2023d {
    public static void main(String[] args) {
        FastScanner sc = new FastScanner();
        int t = sc.nextInt();
        for (int i = 0; i < t; i++) {
            int n = sc.nextInt();
            int[] a = new int[n];
            for (int j = 0; j < n; j++) a[j] = sc.nextInt();
            System.out.println(max(a));
        }
    }

    private static int max(int[] a) {
        int ps = 0;
        int c = 0;
        Set<Integer> ss = new HashSet<>();
        ss.add(0); 
        for (int num : a) {
            ps += num;
            if (ss.contains(ps)) {
                c++;
                ss.clear();
                ss.add(0); 
                ps = 0;   
            }
            ss.add(ps);
        }
        return c;
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

