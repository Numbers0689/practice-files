import java.util.*;
import java.io.*;

public class Cf732a {
    public static void main(String[] args) {
        FastScanner sc = new FastScanner();
        int k = sc.nextInt();
        int r = sc.nextInt();
        int l = k%10;
        for (int i = 1; i < 10; i++) {
            if ((l*i)%10 == r || (l*i)%10 == 0) {
                System.out.print(i);
                break;
            }
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

