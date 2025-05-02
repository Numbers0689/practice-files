import java.util.*;
import java.io.*;

public class Cf2108c {
    public static void main(String[] args) {
        FastScanner sc = new FastScanner();
        int t = sc.nextInt();
        while (t-- > 0) {
            int n = sc.nextInt();
            ArrayList<Integer> a = new ArrayList<>();
            a.add(Integer.MIN_VALUE);
            for (int i = 1; i <= n; i++) {
                int m = sc.nextInt();
                if (m != a.get(a.size()-1)) a.add(m);
            }
            a.add(Integer.MIN_VALUE);
            int c = 0;
            for (int i = 1; i < a.size() - 1; i++) {
                if (a.get(i) > a.get(i-1) && a.get(i) > a.get(i + 1)) c++;
            }

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

