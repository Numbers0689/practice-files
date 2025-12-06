import java.util.*;
import java.io.*;

public class Cf2175c {
    public static void main(String[] args) {
        FastScanner sc = new FastScanner();
        int t = sc.nextInt();
        while (t-- > 0) {
            String s = sc.next();
            String tt = sc.next();
            int[] ts = new int[26];
            for (char c : tt.toCharArray()) {
                ts[c - 'a']++;
            }
            boolean f = false;
            for (char c : s.toCharArray()) {
                if (ts[c-'a'] > 0) ts[c-'a']--;
                else {
                    System.out.println("Impossible");
                    f = true;
                    break;
                }
            }

            if (!f) {
                int i = 0;
                int ls = s.length();
                for (int j = 0; j < 26; j++) {
                    while (i < ls && s.charAt(i) <= 'a' + j) {
                        System.out.print(s.charAt(i));
                        i++;
                    }
                    while (ts[j] > 0) {
                        System.out.print((char) ('a' + j));
                        ts[j]--;
                    }
                }

                if (i < ls - 1) System.out.print(s.substring(i));
                System.out.println();
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