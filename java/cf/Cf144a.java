import java.util.*;
import java.io.*;

public class Cf144a {
    public static void main(String[] args) {
        FastScanner sc = new FastScanner();
        int n = sc.nextInt();
        int[] a = new int[n];
        for (int i = 0; i < n; i++) a[i] = sc.nextInt();
        int max = 0, min = 0;
        for (int i = 0; i < n; i++) {
            if (a[i] > a[max]) max = i;
            if (a[i] <= a[min]) min = i;
        }
        if (max > min) {
            System.out.println(Math.abs(0 - max) + (n - min - 1) - 1);
        } else {
            System.out.println((max - 0) + (n - min - 1));
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
