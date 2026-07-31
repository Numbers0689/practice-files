import java.util.*;
import java.io.*;

public class Hwi001 {
    static String d = "abc";
    public static void main(String[] args) {
        FastScanner sc = new FastScanner();
        List<String> res = new ArrayList<>();

        bt(res, 3, "");
        System.out.println(res.toString());
    }

    public static void bt(List<String> res, int n, String s) {
        if (s.length() == n) {
            res.add(s);
            return;
        }
        for (char dd : d.toCharArray()) {
            if (!s.contains(dd + ""))
            bt(res, n, s+dd);
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