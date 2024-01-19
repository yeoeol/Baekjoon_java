package algorithmBasic.graph;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class B_1707 {

    static int V;
    static int E;
    static ArrayList<Integer>[] graph;
    static int[] color;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int k = Integer.parseInt(br.readLine());
        while (k-->0) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            V = Integer.parseInt(st.nextToken());
            E = Integer.parseInt(st.nextToken());
            graph = new ArrayList[V +1];
            color = new int[V +1];

            for (int i = 1; i <= V; i++) {
                graph[i] = new ArrayList<>();
            }

            for (int i = 0; i < E; i++) {
                st = new StringTokenizer(br.readLine());
                int u = Integer.parseInt(st.nextToken());
                int v = Integer.parseInt(st.nextToken());
                graph[u].add(v);
                graph[v].add(u);
            }

            boolean flag = false;
            for (int i = 1; i <= V; i++) {
                if (color[i] == 0) {
                    flag = bfs(i);
                }
                if (!flag) {
                    break;
                }
            }
            if (flag) {
                System.out.println("YES");
            }
            else {
                System.out.println("NO");
            }
        }
    }

    private static boolean bfs(int now) {
        Queue<Integer> queue = new LinkedList<>();
        queue.offer(now);
        color[now] = 1;

        while (!queue.isEmpty()) {
            int cur = queue.poll();

            for (Integer integer : graph[cur]) {
                if (color[integer] == color[cur]) {
                    return false;
                }
                if (color[integer] == 0) {
                    color[integer] = color[cur] * -1;
                    queue.offer(integer);
                }
            }
        }
        return true;
    }
}
