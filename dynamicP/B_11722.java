package algorithmBasic.dynamicP;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class B_11722 {
    public static void main(String[] args) throws IOException {
        //dp[i] -> i번째 항까지의 감소하는 부분수열의 최대 길이
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());
        int[] nums = new int[n];
        int[] dp = new int[n];

        StringTokenizer st = new StringTokenizer(br.readLine());
        int count = st.countTokens();
        for (int i = 0; i < count; i++) {
            nums[i] = Integer.parseInt(st.nextToken());
        }

        dp[0] = 1;
        for (int i = 1; i < n; i++) {
            dp[i] = 1;
            for (int j = 0; j < i; j++) {
                if ((nums[j] > nums[i]) && (dp[i] <= dp[j])) {
                    dp[i] = dp[j] + 1;
                }
            }
        }

        System.out.println(Arrays.stream(dp).max().getAsInt());

//        Arrays.stream(dp).forEach(o -> System.out.println(o));
    }
}
