import java.util.*;
import java.io.*;

public class Cf2037d {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();

        while (t-- > 0) {
            int n = sc.nextInt();
            int m = sc.nextInt();
            int L = sc.nextInt();

            // Input hurdles
            int[][] hurdles = new int[n][2];
            for (int i = 0; i < n; i++) {
                hurdles[i][0] = sc.nextInt(); // li
                hurdles[i][1] = sc.nextInt(); // ri
            }

            // Input power-ups
            ArrayList<int[]> powerUps = new ArrayList<>();
            for (int i = 0; i < m; i++) {
                powerUps.add(new int[]{sc.nextInt(), sc.nextInt()}); // xi, vi
            }

            // Solve for this test case
            System.out.println(minPowerUps(n, m, L, hurdles, powerUps));
        }
    }

    private static int minPowerUps(int n, int m, int L, int[][] hurdles, ArrayList<int[]> powerUps) {
        int pos = 1; // Starting position
        int collected = 0; // Count of power-ups collected
        int hurdleIndex = 0;
        int powerUpIndex = 0;
        int jumpPower = 1; // Default jump power
        PriorityQueue<Integer> pq = new PriorityQueue<>(); // Min-heap for power-ups

        while (pos < L) {
            // Add all power-ups at or before the current position to the priority queue
            while (powerUpIndex < m && powerUps.get(powerUpIndex)[0] <= pos) {
                pq.add(powerUps.get(powerUpIndex)[1]);
                powerUpIndex++;
            }

            // Process the current hurdle if it starts at or before the current position
            if (hurdleIndex < n && hurdles[hurdleIndex][0] <= pos) {
                // Check if we can cross the hurdle
                while (pos + jumpPower <= hurdles[hurdleIndex][1] && !pq.isEmpty()) {
                    jumpPower += pq.poll();
                    collected++;
                }

                // If we still cannot cross the hurdle, it's impossible to proceed
                if (pos + jumpPower <= hurdles[hurdleIndex][1]) {
                    return -1;
                }

                // Move to the end of the hurdle
                pos = hurdles[hurdleIndex][1] + 1;
                hurdleIndex++;
            } else {
                // Normal movement to the next hurdle or to the end
                pos++;
            }
        }

        return collected;
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

    Long nextLong() {
        return Long.parseLong(next());
    }
}