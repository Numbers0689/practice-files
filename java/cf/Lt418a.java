import java.util.*;
import java.io.*;

public class Lt418a {
    public static void main(String[] args) {
        FastScanner sc = new FastScanner();
        int[] nums = new int[3];
        for (int i = 0; i < 3; i++) {
            nums[i] = sc.nextInt();
        }
        String[] bs = new String[3];
        for (int i = 0; i < 3; i++) {
            bs[i] = Integer.toBinaryString(nums[i]);
        }
        Arrays.sort(bs, (a, b) -> (b + a).compareTo(a + b));
        StringBuilder r = new StringBuilder();
        for (String b : bs) {
            r.append(b);
        }
        System.out.println(Integer.parseInt(r.toString(), 2));
        // int l = 0, r = 0;
        // System.out.print(r);
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

