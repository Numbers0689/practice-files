import java.util.*;
import java.io.*;

public class Cf2130 {
    
    public static void main(String[] args) {
        FastScanner sc = new FastScanner();
        int t = sc.nextInt();
        
        while (t-- > 0) {
            int n = sc.nextInt();
            int[] s = new int[n];
            for (int i = 0; i < n; i++) {
                s[i] = sc.nextInt();
            }
            
            System.out.println(solve(s, n));
        }
    }
    
    public static int solve(int[] s, int n) {
        Map<Integer, Integer> memo = new HashMap<>();
        return dp(s, n, (1 << n) - 1, memo);
    }
    
    private static int dp(int[] s, int n, int mask, Map<Integer, Integer> memo) {
        if (mask == 0) return 0;
        
        if (memo.containsKey(mask)) {
            return memo.get(mask);
        }
        
        int maxScore = 0;
        
        for (int subset = mask; subset > 0; subset = (subset - 1) & mask) {
            List<Integer> elements = new ArrayList<>();
            
            for (int i = 0; i < n; i++) {
                if ((subset & (1 << i)) != 0) {
                    elements.add(s[i]);
                }
            }
            
            int sum = elements.stream().mapToInt(Integer::intValue).sum();
            int mex = calculateMex(elements);
            
            int newMask = mask ^ subset;
            int scoreWithSum = sum + dp(s, n, newMask, memo);
            int scoreWithMex = mex + dp(s, n, newMask, memo);
            
            maxScore = Math.max(maxScore, Math.max(scoreWithSum, scoreWithMex));
        }
        
        memo.put(mask, maxScore);
        return maxScore;
    }
    
    private static int calculateMex(List<Integer> elements) {
        Set<Integer> present = new HashSet<>(elements);
        int mex = 0;
        while (present.contains(mex)) {
            mex++;
        }
        return mex;
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