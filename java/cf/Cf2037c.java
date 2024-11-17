import java.util.*;
import java.io.*;

public class Cf2037c {
    public static void main(String[] args) {
        FastScanner sc = new FastScanner();
        int t = sc.nextInt(); 
        while (t-- > 0) {
            int n = sc.nextInt();
            List<Integer> result = findPermutation(n);
            if (result.isEmpty()) {
                System.out.println(-1);  
            } else {
                for (int num : result) {
                    System.out.print(num + " ");
                }
                System.out.println();
            }
        }
    }

    static boolean[] isComposite, used;

    static void sieve(int n) {
        isComposite = new boolean[2 * n + 1];
        for (int i = 2; i * i <= 2 * n; i++) {
            if (!isComposite[i]) {
                for (int j = i * i; j <= 2 * n; j += i) {
                    isComposite[j] = true;
                }
            }
        }
        isComposite[0] = isComposite[1] = true;  
    }

    static List<Integer> findPermutation(int n) {
        sieve(n);
        used = new boolean[n + 1];
        used[1] = true;
        List<Integer> permutation = new ArrayList<>();
        permutation.add(1);
        if (helper(n, permutation)) {
            return permutation;
        }
        return new ArrayList<>();  
    }

    static boolean helper(int n, List<Integer> p) {
        if (p.size() == n) return true;  

        for (int i = 2; i <= n; i++) {
            if (!used[i] && isComposite[i + p.get(p.size() - 1)]) {
                used[i] = true;
                p.add(i);
                if (helper(n, p)) return true;  
                p.remove(p.size() - 1);
                used[i] = false; 
            }
        }
        return false;
    }
}

class FastScanner {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    StringTokenizer st = new StringTokenizer("");

    String next() {
        while (!st.hasMoreTokens()) {
            try {
                st = new StringTokenizer(br.readLine());
            } catch (IOException e) {}
        }
        return st.nextToken();
    }

    int nextInt() {
        return Integer.parseInt(next());
    }
}
