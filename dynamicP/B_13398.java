package algorithmBasic.dynamicP;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class B_13398 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());

        StringTokenizer st = new StringTokenizer(br.readLine());
        int size = st.countTokens();

        int[] nums = new int[n];
        int[] dp = new int[n];
        int[] dp2 = new int[n];

        for (int i = 0; i < size; i++) {
            nums[i] = Integer.parseInt(st.nextToken());
        }

        dp[0] = nums[0];
        int ans = dp[0];
        for (int i = 1; i < n; i++) {
            dp[i] = Math.max(dp[i - 1] + nums[i], nums[i]);
            ans = Math.max(ans, dp[i]);
        }

        dp2[n-1] = nums[n-1];
        for (int i = n-2; i >= 0; i--) {
            dp2[i] = Math.max(dp2[i + 1] + nums[i], nums[i]);
        }

        for (int i = 1; i < n-1; i++) {
            ans = Math.max(ans, dp[i - 1] + dp2[i + 1]);
        }


        System.out.println(ans);
    }

}
