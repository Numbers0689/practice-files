import java.util.*;
import java.io.*;

public class Cf2137c {
    public static void main(String[] args) {
        FastScanner sc = new FastScanner();
        int t = sc.nextInt();
        while (t-- > 0) {
            int b = sc.nextInt(), a = sc.nextInt();
            int s = -1;
            if (((a + b) & 1) == 0) s = a+b;
            if (a%2 == 1 && b%2==1) s = Math.max(s, a*b+1);
            else if (a%2==0 && (a%4==0 || b%2==0)) s = Math.max(s, 2 + Math.floorDiv((a*b), 2));
            System.out.println(s);
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

