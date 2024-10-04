import java.util.*;
import java.io.*;

public class Cf791a {
    public static void main(String[] args) {
        FastScanner sc = new FastScanner();
        int a = sc.nextInt();
        int b = sc.nextInt();
        int y = 0;
        while (a <= b) {
            a *= 3;
            b *= 2;
            y++;
        }
        System.out.print(y);
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

