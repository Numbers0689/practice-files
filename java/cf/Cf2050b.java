import java.util.*;
import java.io.*;

public class Cf2050b {
    public static void main(String[] args) {
        FastScanner sc = new FastScanner();
        int t = sc.nextInt();
        while (t-- > 0) {
            int n = sc.nextInt();
            long ods = 0, evs = 0, odn = 0, evn = 0;
            for (int i = 0; i < n; i++) {
                if ((i&1) == 0) {
                    evs += sc.nextInt();
                    evn++;
                } else {
                    ods += sc.nextInt();
                    odn++;
                }
            }
            if (ods%odn != 0 || evs%evn != 0 || evs/evn != ods/odn) System.out.println("NO");
            else System.out.println("YES");

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