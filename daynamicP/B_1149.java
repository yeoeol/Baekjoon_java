package algorithmBasic.daynamicP;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class B_1149 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());
        int[][] map = new int[n+1][3];
        int[][] dp = new int[n+1][3];

        for (int i = 1; i <= n; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            for (int j = 0; j < 3; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        // dp[i][j] : (i, j)까지 각각 다른 색으로 칠하는 최솟값
        for (int i = 1; i <= n; i++) {
            dp[i][0] = map[i][0];
            dp[i][1] = map[i][1];
            dp[i][2] = map[i][2];

            dp[i][0] += Math.min(dp[i-1][1], dp[i-1][2]);
            dp[i][1] += Math.min(dp[i-1][0], dp[i-1][2]);
            dp[i][2] += Math.min(dp[i-1][0], dp[i-1][1]);
        }

        System.out.println(Math.min(Math.min(dp[n][0], dp[n][1]), dp[n][2]));
    }
}
