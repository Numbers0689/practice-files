import java.util.*;
import java.io.*;

public class Cf2254c2 {
    public static void main(String[] args) {
        FastScanner sc = new FastScanner();
        int t = sc.nextInt();
        while (t-- > 0) {
            int n = sc.nextInt();
            String s = sc.next(), s1 = sc.next();
            boolean f = true;
            long sum = 0;
            for (int j = 0; j < 2; j++) {
                List<Integer> ca = new ArrayList<>(), cb = new ArrayList<>();
                for (int i = j; i < s.length(); i+=2) {
                    if (s.charAt(i) == '1') ca.add(i);
                    if (s1.charAt(i) == '1') cb.add(i);
                }

                if (ca.size() != cb.size()) {
                    f = false;
                    break;
                }

                for (int k = 0; k < ca.size(); k++) sum += Math.abs(ca.get(k) - cb.get(k));
            }

            if (f) System.out.println(sum/2);
            else System.out.println(-1);

            
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