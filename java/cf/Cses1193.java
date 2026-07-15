import java.util.*;
import java.io.*;

public class Cses1193 {
    private static char[][] graph;
    private static int[][] dirs = {{1, 0}, {-1, 0}, {0, 1}, {0, -1}};
    private static int n, m;
    private static int len = 0;
    public static void main(String[] args) {
        solve();
    }

    private static void solve() {
        FastScanner sc = new FastScanner();
        n = sc.nextInt();
        m = sc.nextInt();

        graph = new char[n][m];
        int r = 0, c = 0;
        for (int i = 0; i < n; i++) {
            String line = sc.next();
            for (int j = 0; j < m; j++) {
                graph[i][j] = line.charAt(j);
                if (line.charAt(j) == 'A') {
                    r = i;
                    c = j;
                }
            }
        }

        System.out.println(bfs(r, c));
        System.out.println(len);
    }

    private static boolean bfs(int r, int c) {
        Queue<int[]> q = new ArrayDeque<>();
        graph[r][c] = 'o';
        q.offer(new int[]{r, c});

        while (!q.isEmpty()) {
            int[] node = q.poll();
            len++;
            for (int[] dir : dirs) {
                int i = node[0] + dir[0], j = node[1] + dir[1];
                if (i < 0 || i >= n || j < 0 || j >= m) continue;
                if (graph[i][j] == 'B') return true;
                if (graph[i][j] != '.') continue;
                graph[i][j] = 'o';
                q.offer(new int[]{i, j});
            }
        }

        return false;
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