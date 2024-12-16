import java.util.*;
import java.io.*;

public class Cf2044d {
    public static void main(String[] args) {
        FastScanner sc = new FastScanner();
        int t = sc.nextInt();
        while (t-- > 0) {
            int n = sc.nextInt();
            int[] a = new int[n];
            Set<Integer> s = new HashSet<>();
            int[] b = new int[n];
            for (int i = 0; i < n; i++) {
                a[i] = sc.nextInt();
                if (!s.contains(a[i])) {
                    b[i] = a[i];
                    s.add(a[i]);
                } else {
                    int num = (int) (Math.random() * (n) + 1);
                    while (s.contains(num)) {
                        num = (int) (Math.random() * (n) + 1);
                    }
                    b[i] = num;
                    s.add(num);
                }
                System.out.print(b[i] + " ");
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

