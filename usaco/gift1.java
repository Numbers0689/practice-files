/*
ID: firewat1
LANG: JAVA
TASK: gift1
*/
import java.io.*;
import java.util.*;

class gift1 {
  public static void main (String [] args) throws IOException {
    FastScanner sc = new FastScanner("gift1.in");
    PrintWriter out = new PrintWriter(new BufferedWriter(new FileWriter("gift1.out")));
    LinkedHashMap<String, Integer> ls = new LinkedHashMap<>();
    int np = sc.nextInt(), t, r;
    String s;
    for (int i = 0; i < np; i++) ls.put(sc.next(), 0);
    for (int i = 0; i < np; i++) {
        s = sc.next();
        t = sc.nextInt();
        r = sc.nextInt();
        if (r != 0) ls.put(s, ls.get(s)-t+(t%r));
        for (int j = 0; j < r; j++) {
            s = sc.next();
            ls.put(s, ls.get(s)+(t/r));
        }
    }
    for (Map.Entry<String,Integer> e: ls.entrySet()) {
        out.println(e.getKey() + " " + e.getValue());
    }
    out.close();
  }
}

class FastScanner {
    BufferedReader br;
    StringTokenizer st;
    FastScanner(String s) {
        try {
            br = new BufferedReader(new FileReader(s));
        } catch (FileNotFoundException e) {}
        st = new StringTokenizer("");
    }

    String next() {
        while (!st.hasMoreTokens())
            try {
                st = new StringTokenizer(br.readLine());
            } catch(IOException e) {}
        return st.nextToken();
    }

    int nextInt() {
        return Integer.parseInt(next());
    }

    long nextLong() {
        return Long.parseLong(next());
    }
}