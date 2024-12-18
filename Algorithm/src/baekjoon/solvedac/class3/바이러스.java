package baekjoon.solvedac.class3;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.LinkedList;
import java.util.Queue;

public class 바이러스 {

    static int parasiteNum;

    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter writer = new BufferedWriter(new OutputStreamWriter(System.out));

        int N = Integer.parseInt(reader.readLine()); // 컴퓨터 대수
        int M = Integer.parseInt(reader.readLine()); // 네트워크에 연결된 컴퓨터쌍 수

        int[][] networks = new int[N + 1][N + 1]; // 4
        int[] visited = new int[N + 1];

        for (int i = 0; i < M; i++) {
            String[] s = reader.readLine().split(" ");

            int startIdx = Integer.parseInt(s[0]);
            int endIdx = Integer.parseInt(s[1]);

            networks[startIdx][endIdx] = 1;
            networks[endIdx][startIdx] = 1;
        }

        visited[1] = 1;
        dfs(networks, 1, visited);

        //BFS 풀이
        Queue<Integer> q = new LinkedList<>();
        // 시작 노드 방문 처리
        visited[1] = 1;
        q.offer(1);

        while (!q.isEmpty()) {
            int current = q.poll();

            for (int i = 1; i <= N; i++) {
                // current와 연결되어 있고, 아직 방문하지 않은 노드라면
                if (networks[current][i] == 1 && visited[i] == 0) {
                    ++visited[i];
//                    ++parasiteNum;
                    q.offer(i);
                }
            }
        }

        System.out.println(parasiteNum);
    }

    public static void dfs(int[][] networks, int target, int[] visited) {
        int[] network = networks[target];

        for (int i = 1; i < network.length; i++) {
            if (visited[i] == 0 && network[i] == 1) {
                visited[i] = 1;
                ++parasiteNum;
                dfs(networks, i, visited);
            }
        }
    }
}
