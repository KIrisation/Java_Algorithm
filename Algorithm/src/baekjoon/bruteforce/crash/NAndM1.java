package baekjoon.bruteforce.crash;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.StringTokenizer;

/**
 * 백준 15649번: N과 M (1)
 */
public class NAndM1 {

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

        DFS(0);
        System.out.println(sb);
    }

    public static void DFS(int cnt) { // 현재 cnt개 까지 수를 택했음.
        if (cnt == M) { // 끝까지 탐색했다면 출력
            output();
            return;
        }

        for (int i = 1; i <= N; i++) {
            if (!visited[i]) {
                nums[cnt] = i;
                visited[i] = true;
                DFS(cnt + 1);
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
