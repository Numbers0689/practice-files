import java.util.*;
import java.io.*;

public class Cf2044c {
    public static void main(String[] args) {
        FastScanner sc = new FastScanner();
        int t = sc.nextInt();
        while (t-- > 0) {
            int m, a, b, c;
            m = sc.nextInt();
            a = sc.nextInt();
            b = sc.nextInt();
            c = sc.nextInt();
            long sum = 0;
            if (a >= m) sum += m;
            else {
                if (c >= m-a) {
                    sum += m;
                    c -= m-a;
                } else {
                    sum += c + a;
                    c = 0;
                }
            }
            if (b >= m) sum += m;
            else {
                if (c >= m-b) {
                    sum += m;
                } else {
                    sum += c + b;
                }
            }
            System.out.println(sum);
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

