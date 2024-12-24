package baekjoon.solvedac.class3.refactor;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

public class 케빈_베이컨의_6단계_법칙_Refactor {

    static int N;
    static int M;
    static ArrayList<Integer>[] graph;
    static int[] dist;
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter writer = new BufferedWriter(new OutputStreamWriter(System.out));

        String[] s = reader.readLine().split(" ");
        N = Integer.parseInt(s[0]);
        M = Integer.parseInt(s[1]);
        dist = new int[N + 1];
        graph = new ArrayList[N + 1]; // 카운트 체크

        for (int i = 1; i <= N; i++) {
            graph[i] = new ArrayList<>();
        }

        for (int i = 1; i <= N; i++) {
            s = reader.readLine().split(" ");
            int first = Integer.parseInt(s[0]);
            int second = Integer.parseInt(s[1]);

            graph[first].add(second);
            graph[second].add(first);
        }

        int minCnt = Integer.MAX_VALUE;
        int minIdx = 0;

        for (int i = 1; i <= N; i++) {
            int cnt = bfs(i);

            if (minCnt > cnt) {
                minCnt = cnt;
                minIdx = i;
            }
        }

        writer.write(String.valueOf(minIdx));
        writer.flush();
    }

    static int bfs(int start) {
        Arrays.fill(dist, -1); // 방문여부 및 카운터 초기화
        int cnt = 0;
        Queue<Integer> q = new LinkedList<>();
        q.offer(start);
        dist[start] = 0;

        while (!q.isEmpty()) {
            int y = q.poll();

            for (int x : graph[y]) {
                if (dist[x] != -1) {
                    continue;
                }

                dist[x] = dist[y] + 1;
                cnt += dist[x];
                q.offer(x);
            }
        }

        return cnt;
    }
}
