package algorithmBasic.graph;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;

public class B_2667 {

    static int n;
    static int count;
    static ArrayList<Integer> result;
    static int[][] arr;
    static boolean[][] visited;
    static int[] dx = {-1, 1, 0, 0};
    static int[] dy = {0, 0, -1, 1};

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        n = Integer.parseInt(br.readLine());
        arr = new int[n][n];
        visited = new boolean[n][n];
        result = new ArrayList<>();

        for (int i = 0; i < n; i++) {
            arr[i] = Arrays.stream(br.readLine().split("")).mapToInt(Integer::parseInt).toArray();
        }

        int totalCount = 0;
        count = 1;

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (!visited[i][j] && arr[i][j] == 1) {
                    totalCount++;
                    dfs(i, j);
                    result.add(count);
                    count = 1;
                }
            }
        }
        Collections.sort(result);
        System.out.println(totalCount);
        for (Integer integer : result) {
            System.out.println(integer);
        }
    }

    static void dfs(int x, int y) {
        visited[x][y] = true;

        for (int i = 0; i < 4; i++) {
            int newX = dx[i]+x;
            int newY = dy[i]+y;
            if (newX < 0 || newY < 0 || newX >= n || newY >= n) {
                continue;
            }
            if (arr[newX][newY] == 1 && !visited[newX][newY]) {
                count++;
                dfs(newX, newY);
            }
        }
    }
}
