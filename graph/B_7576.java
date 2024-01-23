package algorithmBasic.graph;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class B_7576 {

    static Queue<int[]> queue = new LinkedList<>();
    static int n;
    static int m;
    static int[][] graph;
    static int[] dx = {-1, 1, 0, 0};
    static int[] dy = {0, 0, -1, 1};
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        m = Integer.parseInt(st.nextToken());
        n = Integer.parseInt(st.nextToken());

        graph = new int[n][m];

        for (int i = 0; i < n; i++) {
            graph[i] = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
        }
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (graph[i][j] == 1) {
                    queue.add(new int[]{i, j});
                }
            }
        }
        bfs();
        int max = -1;
        for (int[] ints : graph) {
            for (int anInt : ints) {
                if (anInt == 0) {
                    System.out.println(-1);
                    return;
                }
                max = Math.max(max, anInt);
            }
        }
        System.out.println(max-1);
    }

    static void bfs() {

        while (!queue.isEmpty()) {
            int[] poll = queue.poll();
            int nowX = poll[0];
            int nowY = poll[1];

            for (int i = 0; i < 4; i++) {
                int moveX = nowX + dx[i];
                int moveY = nowY + dy[i];

                if (moveX < 0 || moveY < 0 || moveX >= n || moveY >= m) {
                    continue;
                }
                if (graph[moveX][moveY] == 0) {
                    graph[moveX][moveY] = graph[nowX][nowY] + 1;
                    queue.add(new int[]{moveX, moveY});
                }
            }
        }
    }
}
