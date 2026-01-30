import java.util.*;
import java.io.*;

public class Cf2188b {
    public static void main(String[] args) {
        FastScanner sc = new FastScanner();
        int t = sc.nextInt();
        while (t-- > 0) {
            int n = sc.nextInt();
            String s = sc.next();
            int curr = 0, ones = 0;
            for (int i = 0; i < n; i++) {
                if (s.charAt(i) == '0') curr++;
                else if (curr == 0) ones++;
                else if (ones == 0) {
                    ones += (curr+1)/3 + 1;
                    curr=0;
                }
                else {
                    ones += (curr) / 3 + 1;
                    curr=0;
                }
            }
            if (curr > 0 && ones == 0) {
                ones += (curr+2)/3;
            } else {
                ones += (curr+1)/3;
            }
            System.out.println(ones);
        }
    }
}

class Pair {
    int a;
    int b;
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
