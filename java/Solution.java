import java.io.*;
import java.util.*;

public class Solution {

    public static void main(String[] args) {
        /* Enter your code here. Read input from STDIN. Print output to STDOUT. Your class should be named Solution. */
        Scanner sc = new Scanner(System.in);
        String s = sc.next();
        int t = 1;
        for (int i = 0; i < s.length()/2; i++) {
            t *= Integer.parseInt("" + s.charAt(i)) + Integer.parseInt("" + s.charAt(s.length() - 1 - i));
        }
        if (s.length() % 2 == 1)  t *= Integer.parseInt("" + s.charAt(s.length() / 2));
        System.out.println(t);
    }
}