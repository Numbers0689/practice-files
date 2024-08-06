import java.util.Arrays;

public class Eve {
    public static void main(String[] args) {
        int[] a = {1,2,3,4,5,0,0,0,1,1,0,1};
        System.out.println(Arrays.toString(evenOdd(a)));
    }

    public static int[] evenOdd(int[] a) {
        int n = a.length;
        int[] r = new int[n];
        int s = 0, e = n-1;

        for (int i : a) {
            if (i%2 == 0) {
                r[s++]  = i;
            } else {
                r[e--] = i;
            }
        }

        return r;
    }
}
