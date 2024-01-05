package algorithmBasic.daynamicP;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class B_15988 {

    // dp[n] = dp[n-1] + dp[n-2] + dp[n-3]
    // dp[n] : n을 1,2,3을 이용해서 만드는 경우의 수
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());

        long[] dp = new long[1000001];
        dp[1] = 1;
        dp[2] = 2;
        dp[3] = 4;

        for (int i = 4; i <= 1000000; i++) {
            dp[i] = (dp[i-1]+dp[i-2]+dp[i-3]) % 1000000009;
        }
        for (int i = 0; i < T; i++) {
            System.out.println(dp[Integer.parseInt(br.readLine())]);
        }
    }
}
