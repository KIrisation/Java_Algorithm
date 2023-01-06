package baekjoon.bruteforce.crash;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.sql.Array;
import java.util.Arrays;
import java.util.StringTokenizer;

public class NAndM5 {

    static BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
    static StringBuilder sb = new StringBuilder();
    static StringTokenizer st;
    static int N, M;
    static int[] nums;
    static int[] numIdx;
    static boolean[] visited;
    public static void main(String[] args) {
        N = nextInt();
        M = nextInt();

        visited = new boolean[N + 1];
        Arrays.fill(visited, false);

        nums = new int[N + 1];
        for (int i = 1; i <= nums.length - 1; i++) {
            nums[i] = nextInt();
        }
        Arrays.sort(nums);

        numIdx = new int[N + 1];

        recursion(0);
        System.out.println(sb);
    }

    private static void recursion(int idx) {
        if (idx == M) {
            output();
            return;
        }

        for (int i = 1; i <= N; i++) {
            if (!visited[i]) {
                numIdx[idx] = i;
                visited[i] = true;
                recursion(idx + 1);
                visited[i] = false;
            }
        }
    }

    private static void output() {
        for (int i = 0; i < M; i++) {
            sb.append(nums[numIdx[i]]).append(" ");
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
