import java.util.*;
import java.io.*;

public class Cf275a {
    public static void main(String[] args) {
        FastScanner sc = new FastScanner();

        int[][] a = new int[3][3], b = new int[3][3];
        for(int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                a[i][j] = sc.nextInt();
                b[i][j] = 1;
            }
        }
        
        b[0][0] = (a[0][0] + a[0][1] + a[1][0]) % 2 == 0 ? 1 : 0;
        b[0][1] = (a[0][0] + a[0][1] + a[1][1] + a[0][2]) % 2 == 0 ? 1 : 0;
        b[0][2] = (a[0][2] + a[0][1] + a[1][2]) % 2 == 0 ? 1 : 0;
        b[1][0] = (a[0][0] + a[1][0] + a[1][1] + a[2][0]) % 2 == 0 ? 1 : 0;
        b[1][1] = (a[0][1] + a[1][0] + a[1][1] + a[1][2] + a[2][1]) % 2 == 0 ? 1 : 0;
        b[1][2] = (a[1][1] + a[0][2] + a[1][2] + a[2][2]) % 2 == 0 ? 1 : 0;
        b[2][0] = (a[2][0] + a[2][1] + a[1][0]) % 2 == 0 ? 1 : 0;
        b[2][1] = (a[2][0] + a[2][1] + a[1][1] + a[2][2]) % 2 == 0 ? 1 : 0;
        b[2][2] = (a[2][2] + a[2][1] + a[1][2]) % 2 == 0 ? 1 : 0;

        for (int i = 0; i < 3; i++) {
            for(int j = 0; j < 3; j++) {
                System.out.print(b[i][j] + " ");
            }
            System.out.println();
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

