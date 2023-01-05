package baekjoon.bruteforce.crash;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

/**
 * 백준 15650번: N과 M (2)
 */
public class NAndM2Case1 {

    static BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
    static StringBuilder sb = new StringBuilder();
    static StringTokenizer st;
    static int N, M;
    static boolean[] visited;
    static int[] nums;
    public static void main(String[] args) {
        N = nextInt();
        M = nextInt();

        visited = new boolean[N + 1];

        Arrays.fill(visited, false);

        nums = new int[N + 1];

        BFS(0, 1);

        System.out.println(sb);
    }

    private static void BFS(int cnt, int start) {
        if (cnt == M) {
            output();
            return;
        }

        for (int i = start; i <= N; i++) {
            if (!visited[i]) {
                nums[cnt] = i;
                visited[i] = true;
                BFS(cnt + 1, i + 1);
                visited[i] = false;
            }
        }
    }

    private static void output() {
        for (int i = 0; i < M; i++) {
            sb.append(nums[i]).append(" ");
        }

        sb.append("\n");
    }

    static String next() {
        while (st == null || !st.hasMoreElements()) {
            try {
                st = new StringTokenizer(reader.readLine());
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        return st.nextToken();
    }

    static int nextInt() {
        return Integer.parseInt(next());
    }
}
