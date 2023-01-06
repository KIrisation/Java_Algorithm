package baekjoon.bruteforce.crash;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class NAndM4 {

    static BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
    static StringBuilder sb = new StringBuilder();
    static StringTokenizer st;
    static int N, M;
    static int[] nums;
    static boolean[] visited;

    public static void main(String[] args) {
        N = nextInt();
        M = nextInt();

        nums = new int[N + 1];
        visited = new boolean[N + 1];
        Arrays.fill(visited, false);

        recursion(0, 1);

        System.out.println(sb);
    }

    private static void recursion(int cnt, int idx) {
        if (cnt == M) {
            output();
            return;
        }

        for (int i = idx; i <= N; i++) {
            nums[cnt] = i;
            recursion(cnt + 1, i);
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
