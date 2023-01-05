package baekjoon.bruteforce.crash;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class NAndM2Case2 {

    static BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
    static StringBuilder sb = new StringBuilder();
    static StringTokenizer st;
    static int N, M;
    static boolean[] visited;
    static int[] nums;
    public static void main(String[] args) {
        N = nextInt();
        M = nextInt();

        nums = new int[N];
        recursion(1, 1);

        System.out.println(sb);
    }

    private static void recursion(int idx, int selected) {
        if (selected == M) {
            output();
            return;
        }

        if (idx > N) {
            return;
        }

        nums[selected] = idx;
        recursion(idx + 1, selected + 1);
        nums[selected] = 0;
        recursion(idx + 1, selected);
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
