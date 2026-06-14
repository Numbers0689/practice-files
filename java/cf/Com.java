import java.util.*;
import java.io.*;

public class Com {
    public static void main(String[] args) {
       List<Integer> ar = new ArrayList<>();
       ar.add(10);

    }
}

class Pair<K, V> {
    private K k;
    private V v;
    public Pair(K k, V v) {
        this.k = k;
        this.v = v;
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