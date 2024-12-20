package baekjoon.solvedac.class3;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.LinkedList;
import java.util.Queue;

public class DFS와BFS {

    static BufferedWriter writer = new BufferedWriter(new OutputStreamWriter(System.out));

    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String[] s = reader.readLine().split(" ");

        int N = Integer.parseInt(s[0]);

        int M = Integer.parseInt(s[1]);
        int start = Integer.parseInt(s[2]);

        if (N == 1) {
            String[] s1 = reader.readLine().split(" ");
            writer.write(s1[0] + " " + s1[1]);
            writer.flush();
            return;
        }

        int[][] nodes = new int[N + 1][N + 1];

        for (int i = 1; i <= M; i++) {
            String[] s1 = reader.readLine().split(" ");

            int node = Integer.parseInt(s1[0]);
            int next = Integer.parseInt(s1[1]);

            nodes[node][next] = 1;
            nodes[next][node] = 1;
        }

        int[] visited = new int[N + 1];

        dfs(nodes, start, visited);
        writer.flush();
        writer.newLine();

        Queue<Integer> q = new LinkedList<>();
        int[] visitedQ = new int[N + 1];
        q.offer(start);
        writer.write(start + " ");
        visitedQ[start] = 1;

        while (!q.isEmpty()) {
            int current = q.poll();

            for (int i = 1; i <= nodes.length - 1; i++) {
                if (nodes[current][i] == 1 && visitedQ[i] == 0) {
                    visitedQ[i] = 1;
                    writer.write(i + " ");
                    q.offer(i);
                }
            }
        }

        writer.flush();
    }

    public static void dfs(int[][] nodes, int node, int[] visited) throws IOException {
        if (visited[node] == 1) {
            return;
        }

        visited[node] = 1;
        writer.write(node + " ");

        for (int i = 1; i <= nodes[0].length - 1; i++) {
            if (nodes[node][i] == 1) {
                dfs(nodes, i, visited);
            }
        }
    }
}
