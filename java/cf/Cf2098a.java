import java.util.*;
import java.io.*;

public class Cf2098a {
    public static void main(String[] args) {
        FastScanner sc = new FastScanner();
        int t = sc.nextInt();
        while (t-- > 0) {
            String s = sc.next();
            Map<Character, Integer> m = new HashMap<>();
            for (int i = 0; i < s.length(); i++) {
                if (m.containsKey(s.charAt(i))) m.put(s.charAt(i), m.get(s.charAt(i)) + 1);
                else m.put(s.charAt(i), 1);
            }
            String r = "";
            for (int i = 0; i < 10; i++) {
                for (int j = 9 - i; j < 10; j++) {
                    if (m.containsKey((char)(j + '0')) && m.get((char)(j + '0')) > 0) {
                        r += (char)(j + '0');
                        m.put((char)(j + '0'), m.get((char)(j + '0')) - 1);
                        break;
                    }
                }
            }
            System.out.println(r);
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

