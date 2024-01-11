package algorithmBasic.dynamicP;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class B_1932 {

    static int[][] nums;
    static Integer[][] dp;
    static int n;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine());
        nums = new int[n+1][n+1];

        for (int i = 1; i <= n; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int size = st.countTokens();
            for (int j = 1; j <= size; j++) {
                nums[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        // 왼쪽 위 or 바로 위 선택 가능 (단, 인덱스 범위가 0이거나 n일 경우 X)
        dp = new Integer[n+1][n+1];
        for (int i = 1; i <= n; i++) {
            dp[n][i] = nums[n][i];
        }

        System.out.println(recur(1, 1));
    }

    static int recur(int depth, int idx) {
        if (depth == n) {
            return dp[depth][idx];
        }
        if (dp[depth][idx] == null) {
            dp[depth][idx] = Math.max(recur(depth + 1, idx), recur(depth + 1, idx + 1))+nums[depth][idx];
        }
        return dp[depth][idx];
    }
}
