package algorithmBasic.graph;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class B_7562 {

    static boolean[][] visited;
    static int[] dx = {-2, -1, 1, 2, 2, 1, -1, -2};
    static int[] dy = {1, 2, 2, 1, -1, -2, -2, -1};
    static int destX;
    static int destY;
    static int l;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(br.readLine());

        while (t-->0) {
            l = Integer.parseInt(br.readLine());
            visited = new boolean[l][l];

            StringTokenizer st = new StringTokenizer(br.readLine());
            int x = Integer.parseInt(st.nextToken());
            int y = Integer.parseInt(st.nextToken());
            st = new StringTokenizer(br.readLine());
            destX = Integer.parseInt(st.nextToken());
            destY = Integer.parseInt(st.nextToken());

            System.out.println(bfs(x, y));
        }
    }

    static int bfs(int curX, int curY) {
        Queue<Point> queue = new LinkedList<>();
        queue.offer(new Point(curX, curY, 0));
        visited[curX][curY] = true;
        while (!queue.isEmpty()) {
            Point poll = queue.poll();
            if (poll.x == destX && poll.y == destY) {
                return poll.cnt;
            }

            for (int i = 0; i < 8; i++) {
                int moveX = poll.x + dx[i];
                int moveY = poll.y + dy[i];
                if (moveX < 0 || moveY < 0 || moveX >= l || moveY >= l) {
                    continue;
                }

                if (!visited[moveX][moveY]) {
                    visited[moveX][moveY] = true;
                    queue.offer(new Point(moveX, moveY, poll.cnt +1));
                }
            }
        }
        return -1;
    }

    static class Point {
        int x;
        int y;
        int cnt;

        public Point(int x, int y, int cnt) {
            this.x = x;
            this.y = y;
            this.cnt = cnt;
        }
    }
}
