package algorithmBasic.dynamicP;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class B_11054 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        StringTokenizer st = new StringTokenizer(br.readLine());
        int size = st.countTokens();

        int[] nums = new int[n];
        int[] dpFront = new int[n];
        int[] dpRear = new int[n];

        for (int i = 0; i < size; i++) {
            nums[i] = Integer.parseInt(st.nextToken());
        }

        for (int i = 0; i < n; i++) {
            dpFront[i] = 1;
            for (int front = 0; front < i; front++) {
                if ((nums[front] < nums[i]) && (dpFront[i] <= dpFront[front])) {
                    dpFront[i] = dpFront[front]+1;
                }
            }

        }
        for (int i = n-1; i >= 0; i--) {
            dpRear[i] = 1;
            for (int rear = n-1; rear > i; rear--) {
                if ((nums[rear] < nums[i]) && (dpRear[i] <= dpRear[rear])) {
                    dpRear[i] = dpRear[rear]+1;
                }
            }
        }

        int max = -1;
        for (int i = 0; i < n; i++) {
            max = Math.max(dpFront[i]+dpRear[i], max);
        }
        System.out.println(max-1);

//        for (int i : dpFront) {
//            System.out.print(i+" ");
//        }
//        System.out.println();
//        for (int i : dpRear) {
//            System.out.print(i+" ");
//        }
    }
}
