import java.util.*;
import java.io.*;

public class Hwi001 {
    public static void main(String[] args) {
        FastScanner sc = new FastScanner();
        int n = sc.nextInt();
        int[] a = new int[n];
        for (int i = 0; i < n; i++) a[i] = sc.nextInt();
        int q = sc.nextInt();
        int sum = 0;
        System.out.println(Arrays.toString(a));
        for (int i = 0; i < q; i++) {
            int s = sc.nextInt();
            int l = sc.nextInt(), r = sc.nextInt();
            if (s == 1) {
                for (int j = l; j <= r; j++) {
                    a[j] = (j-l+1)*a[l];
                }
            } else {
                for (int j = l; j <= r; j++) {
                    sum += a[j];
                }
            }
        }
        System.out.println(Arrays.toString(a));
        System.out.println(sum);
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