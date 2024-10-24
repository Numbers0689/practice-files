import java.util.*;
import java.io.*;

public class Cf2033f {
    private static final int MOD = 1000000007;
    public static void main(String[] args) {
        FastScanner sc = new FastScanner();
        int t = sc.nextInt();
        for (int i = 0; i < t; i++) {
            long n = sc.nextLong();
            int k = sc.nextInt();
            System.out.println(g(n, k));
        }
    }
    private static long g(long n, int k) {
        List<Integer> indices = new ArrayList<>();
        int a = 0, b = 1;
        int index = 1;

        do {
            int c = (a + b) % k;
            a = b;
            b = c;
            index++;
            if (a % k == 0) {
                indices.add(index);
            }
        } while (!(a == 0 && b == 1)); 
        int periodLength = indices.size();
        long resultIndex = indices.get((int) ((n - 1) % periodLength));
        long occurrences = (n - 1) / periodLength * periodLength + resultIndex;
        return occurrences % MOD;
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

