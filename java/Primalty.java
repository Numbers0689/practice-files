import java.io.*;
import java.util.*;

class Primalty {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        sieve(n);
    }

    public static void sieve(int n) {
        int[] primes = new int[n+1];
        for (int i = 2; i <= n; i++) {
            if (primes[i] == 0) {
                for (int j = i*i; j <= n; j+=i) {
                    primes[j] = 1;
                }
            }
            System.out.println(primes[i] +" "+ i);
        }
    }
}