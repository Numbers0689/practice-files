import java.util.*;
import java.io.*;

public class Cf2237b {

    public static void main(String[] args) {
        FastScanner sc = new FastScanner();
        int t = sc.nextInt();
        while (t-- > 0) {
            int n = sc.nextInt();
            int[] arr = new int[n];
            int[] arr2 = new int[n];
            for (int i = 0; i < n; i++) arr[i] = sc.nextInt();
            for (int i = 0; i < n; i++) arr2[i] = sc.nextInt();
            boolean swapped, ff = false;
            int c = 0;
            for (int i = 0; i < n - 1; i++) {
                swapped = false;
                
                for (int j = 0; j < n - i - 1; j++) {
                    if (arr[j] > arr[j + 1]) {
                        int temp = arr[j];
                        arr[j] = arr[j + 1];
                        arr[j + 1] = temp;
                        c++;
                        swapped = true;
                    }
                }
                
                if (!swapped) {
                    break;
                }
            }
            for (int i = 0; i < n; i++) {
                if (arr[i] > arr2[i]) {
                    ff = true;
                    break;
                }
            }
            if (ff) {
                System.out.println(-1);
            } else System.out.println(c);
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
