package algorithmBasic.graph;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class B_13023 {

    static boolean[] visited;
    static ArrayList<Integer>[] graph;
    static int n;
    static int m;
    static boolean flag;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());

        graph = new ArrayList[n];

        for (int i = 0; i < n; i++) {
            graph[i] = new ArrayList<>();
        }

        flag = false;
        for (int i = 0; i < m; i++) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            graph[a].add(b);
            graph[b].add(a);
        }

        for (int i = 0; i < n; i++) {
            visited = new boolean[n];
            if (flag) {
                break;
            }
            dfs(i, 1);
        }

        System.out.println(flag ? 1 : 0);
    }

    static void dfs(int N, int depth) {
        if (depth >= 5) {
            flag = true;
            return;
        }
        visited[N] = true;

        for (Integer integer : graph[N]) {
            if (!visited[integer]) {
                dfs(integer, depth+1);
            }
        }

        visited[N] = false;
    }
}
