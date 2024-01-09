package algorithmBasic.daynamicP;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class B_9465 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int T = Integer.parseInt(br.readLine());

        for (int t = 0; t < T; t++) {

            int n = Integer.parseInt(br.readLine());
            int[][] stickers = new int[2][n+1];
            int[][] dp = new int[2][n+1];

            for (int i = 0; i < 2; i++) {
                StringTokenizer st = new StringTokenizer(br.readLine());
                for (int j = 1; j <= n; j++) {
                    stickers[i][j] = Integer.parseInt(st.nextToken());
                }
            }

            //
            dp[0][1] = stickers[0][1];
            dp[1][1] = stickers[1][1];

            for (int k = 2; k <= n; k++) {
                dp[0][k] = Math.max(dp[1][k-1], dp[1][k-2]) + stickers[0][k];
                dp[1][k] = Math.max(dp[0][k-1], dp[0][k-2]) + stickers[1][k];
            }

            System.out.println(Math.max(dp[0][n], dp[1][n]));
        }
    }
}
