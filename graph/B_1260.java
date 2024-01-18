package algorithmBasic.graph;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class B_1260 {

    static boolean[] visited;
    static ArrayList<ArrayList<Integer>> graph = new ArrayList<>();
    static int n;
    static int m;
    static int v;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        v = Integer.parseInt(st.nextToken());

        for (int i = 0; i <= n; i++) {
            graph.add(new ArrayList<>());
        }

        for (int i = 0; i < m; i++) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            graph.get(a).add(b);
            graph.get(b).add(a);
        }

        //sort
        for (int i = 1; i <= n; i++) {
            Collections.sort(graph.get(i));
        }

        //dfs
        visited = new boolean[n+1];
        dfs(v, 1);
        System.out.println();

        //bfs
        visited = new boolean[n+1];
        bfs(v);
    }

    static void dfs(int cur, int depth) {
        System.out.print(cur+" ");
        visited[cur] = true;

        for (Integer i : graph.get(cur)) {
            if (!visited[i]) {
                dfs(i, depth+1);
            }
        }
    }

    static void bfs(int cur) {
        Queue<Integer> queue = new LinkedList<>();
        queue.offer(cur);
        visited[cur] = true;

        while (!queue.isEmpty()) {
            cur = queue.poll();
            System.out.print(cur + " ");
            for (Integer i : graph.get(cur)) {
                if (!visited[i]) {
                    visited[i] = true;
                    queue.offer(i);
                }
            }
        }


    }
}
