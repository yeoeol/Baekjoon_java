package algorithmBasic.graph;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class B_4963 {

    static int[] dx = {1, -1, 0, 0, -1, 1, 1, -1};
    static int[] dy = {0, 0, -1, 1, 1, 1, -1, -1};
    static int[][] arr;
    static boolean[][] visited;
    static int count;
    static int y;
    static int x;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        while (true) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            y = Integer.parseInt(st.nextToken());
            x = Integer.parseInt(st.nextToken());
            arr = new int[x][y];
            visited = new boolean[x][y];
            count = 0;

            if (x == 0 && y == 0) {
                break;
            }

            for (int i = 0; i < x; i++) {
                arr[i] = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
            }

            for (int i = 0; i < x; i++) {
                for (int j = 0; j < y; j++) {
                    if (arr[i][j] == 1 && !visited[i][j]) {
                        count++;
                        dfs(i, j);
                    }
                }
            }
            System.out.println(count);
        }
    }

    static void dfs(int curX, int curY) {
        visited[curX][curY] = true;

        for (int i = 0; i < 8; i++) {
            int newX = curX+dx[i];
            int newY = curY+dy[i];

            if (newX < 0 || newY < 0 || newX >= x || newY >= y) {
                continue;
            }

            if (arr[newX][newY] == 1 && !visited[newX][newY]) {
                dfs(newX, newY);
            }
        }
    }
}
