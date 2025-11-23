import java.util.*;

public class LC170b {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int num1 = sc.nextInt(), num2 = sc.nextInt();
        if (num2 < 101) System.out.println(0);
        else if (num1 < 101) num1 = 100;
        int c = 0;
        for (int i = num1; i <= num2; i++) c += w(i);
        System.out.println(c);
        sc.close();
    }


    private static int w(int n) {
        int c = 0, pr = n % 10;
        n /= 10;
        int cr = n % 10, ne;
        n /= 10;
        while (n > 0) {
            ne = n % 10;
            n/=10;
            if ((cr < ne && cr < pr) || (ne < cr && pr < cr)) c++;
            cr = ne;
            pr = cr;
        }
        return c;
    }
}
