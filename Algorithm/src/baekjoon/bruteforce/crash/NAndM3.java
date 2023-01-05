package baekjoon.bruteforce.crash;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/**
 * 백준 15651번: N과 M (3)
 */
public class NAndM3 {

    static BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
    static StringBuilder sb = new StringBuilder();
    static StringTokenizer st;
    static int N, M;
    static int[] nums;
    public static void main(String[] args) {
        N = nextInt();
        M = nextInt();

        nums = new int[N + 1];

        recursion(0);

        System.out.println(sb);
    }

    private static void recursion(int cnt) {
        if (cnt == M) {
            output();
            return;
        }

        for (int i = 1; i <= N; i++) {
            nums[cnt] = i;
            recursion(cnt + 1);
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
