package algorithmBasic.dynamicP;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class B_2156 {
    static Integer[] dp;
    static int[] num;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        dp = new Integer[n+1];
        num = new int[n+1];
        for (int i = 1; i <= n; i++) {
            num[i] = Integer.parseInt(br.readLine());
        }
        dp[0] = 0;
        dp[1] = num[1];

        if (n > 1) {
            dp[2] = num[1]+num[2];
        }

        System.out.println(recur(n));
    }

    static int recur(int N) {
        if (dp[N] == null) {
            dp[N] = Math.max(Math.max(recur(N - 2), recur(N - 3) + num[N - 1]) + num[N], recur(N - 1));
        }
        return dp[N];
    }
}
