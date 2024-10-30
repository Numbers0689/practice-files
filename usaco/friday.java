/*
ID: firewat1
LANG: JAVA
TASK: friday
*/
import java.io.*;
import java.util.*;

class friday {
  public static void main (String [] args) throws IOException {
    FastScanner sc = new FastScanner("friday.in");
    PrintWriter out = new PrintWriter(new BufferedWriter(new FileWriter("friday.out")));
    int N = sc.nextInt();
    int[] days = {0, 0, 0, 0, 0, 0, 0};
    int[] months = {31,28,31,30,31,30,31,31,30,31,30,31};
    int day = 0;
    for (int y = 1900; y < 1900+N; y++) {
        for (int m : months) {
            days[day%7]++;
            if (m==28 && (y%400==0 || (y%100!=0 && y%4==0))) {
                day+=29;
                continue;
            }
            day+=m;
        }
    }
    out.println(days[0] + " " + days[1] + " " + days[2] + " " + days[3] + " " + days[4] + " " + days[5] + " " + days[6]);
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