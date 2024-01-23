package algorithmBasic.graph;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class B_2178 {

    static int n;
    static int m;
    static int[][] graph;
    static boolean[][] visited;
    static int[] dx = {-1, 1, 0, 0};
    static int[] dy = {0, 0, -1, 1};

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        graph = new int[n][m];
        visited = new boolean[n][m];

        for (int i = 0; i < n; i++) {
            graph[i] = Arrays.stream(br.readLine().split("")).mapToInt(Integer::parseInt).toArray();
        }

        bfs();
        System.out.println(graph[n-1][m-1]);
    }

    static void bfs() {
        Queue<int[]> queue = new LinkedList<>();
        queue.offer(new int[]{0, 0});
        visited[0][0] = true;

        while (!queue.isEmpty()) {
            int[] poll = queue.poll();
            int curX = poll[0];
            int curY = poll[1];

            if (curX == n-1 && curY == m-1) {
                return;
            }
            for (int i = 0; i < 4; i++) {
                int moveX = curX+dx[i];
                int moveY = curY+dy[i];
                if (moveX < 0 || moveY < 0 || moveX >= n || moveY >= m) {
                    continue;
                }

                if (!visited[moveX][moveY] && graph[moveX][moveY] == 1) {
                    visited[moveX][moveY] = true;
                    graph[moveX][moveY] = graph[curX][curY] + 1;
                    queue.add(new int[]{moveX, moveY});
                }
            }
        }
    }
}
