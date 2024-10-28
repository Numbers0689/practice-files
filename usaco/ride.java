/*
ID: firewat1
LANG: JAVA
TASK: ride
*/
import java.io.*;
import java.util.*;

public class ride {
    public static void main(String[] args) throws IOException{
        BufferedReader f = new BufferedReader(new FileReader("ride.in"));
        PrintWriter out = new PrintWriter(new BufferedWriter(new FileWriter("ride.out")));
        String c = f.readLine(), g = f.readLine();
        int v = 1, h = 1;
        for (int i = 0; i < c.length(); i++) {
            v *= (int)(c.charAt(i) - 'A' + 1);
            v %= 47;
        }
        for (int i = 0; i < g.length(); i++) {
            h *= (int)(g.charAt(i) - 'A' + 1);
            h %= 47;
        }
        if (v == h) out.println("GO");
        else out.println("STAY");
        out.close();
    }
}
