package baekjoon.solvedac.class2;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class TreeCut {

    static BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;
    static int N; // 나무 수
    static int M; // 가져갈 나무 길이 합의 최소 값
    static int max;
    static int result;
    static int[] trees; // 나무 들

    public static void main(String[] args) {
        input();

        int left = 1;
        int right = max;
        while (left <= right) {
            long sum = 0;
            int middle = (left + right) / 2;

            for (int i = 1; i <= N; i++) {
                if (middle >= trees[i]) {
                    continue;
                }

                sum += trees[i] - middle;
            }

            if (sum >= M) {
                left = middle + 1;
            } else {
                right = middle - 1;
            }

            result = right;
        }

        System.out.println(result);
    }

    private static void input() {
        N = nextInt();
        trees = new int[N + 1];
        M = nextInt();

        max = Integer.MIN_VALUE;

        for (int i = 1; i <= N; i++) {
            trees[i] = nextInt();

            max = Math.max(max, trees[i]);
        }
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
