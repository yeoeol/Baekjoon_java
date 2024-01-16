package algorithmBasic.dynamicP;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class B_11053 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());

        StringTokenizer st = new StringTokenizer(br.readLine());
        int size = st.countTokens();

        int[] nums = new int[n];
        int[] dp = new int[n];

        for (int i = 0; i < size; i++) {
            nums[i] = Integer.parseInt(st.nextToken());
        }

        dp[0] = 1;
        for (int i = 1; i < n; i++) {
            dp[i] = 1;
            for (int j = 0; j < i; j++) {
                if ((nums[j] < nums[i]) && (dp[i] <= dp[j])) {
                    dp[i] = dp[j]+1;
                }
            }
        }

//        for (int i : dp) {
//            System.out.print(i+" ");
//        }
        System.out.println(Arrays.stream(dp).max().getAsInt());
    }
}
