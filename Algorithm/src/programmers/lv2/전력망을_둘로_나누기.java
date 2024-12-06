package programmers.lv2;

import java.util.ArrayList;

public class 전력망을_둘로_나누기 {
    static ArrayList<Integer>[] graph;
    static int min = Integer.MAX_VALUE;
    static int cnt;

    public int solution(int n, int[][] wires) {
        graph = new ArrayList[n + 1];
        for (int i = 1; i <= n; i++) {
            graph[i] = new ArrayList<>();
        }

        for (int[] wire : wires) {
            int v1 = wire[0];
            int v2 = wire[1];

            graph[v1].add(v2);
            graph[v2].add(v1);
        }

        for (int[] wire : wires) {
            int v1 = wire[0];
            int v2 = wire[1];

            boolean[] visited = new boolean[n + 1];

            graph[v1].remove(v2);
            graph[v2].remove(v1);

            cnt = 0;
            dfs(1, visited);
            int count = cnt;

            graph[v1].add(v2);
            graph[v2].add(v1);

            int diff = Math.abs(count - (n - count));
            min = Math.min(min, diff);
        }

        return min;
    }

    public void dfs(int node, boolean[] visited) {
        visited[node] = true;
        ++cnt;

        for (int next : graph[node]) {
            if (!visited[next]) {
                dfs(next, visited);
            }
        }
    }}
