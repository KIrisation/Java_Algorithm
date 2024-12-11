package baekjoon.solvedac.class2;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashSet;
import java.util.Set;
import java.util.StringTokenizer;

public class FindNum {

    static BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
    static StringBuilder sb = new StringBuilder();
    static int N, M;
    static Set<Integer> NNums = new HashSet<>();
    static int[] MNums;
    static StringTokenizer st;
    public static void main(String[] args) throws IOException {
        input();
        calculate();
        System.out.println(sb);
    }

    /**
     * Set 자료구조 풀이
     */
    private static void calculate() {
        for (int mNum : MNums) {
            if (NNums.contains(mNum)) {
                sb.append("1\n");
            } else {
                sb.append("0\n");
            }
        }
    }

    private static void input() throws IOException {
        N = Integer.parseInt(reader.readLine());
        for (int i = 0; i < N; i++) {
            NNums.add(nextInt());
        }

        M = Integer.parseInt(reader.readLine());
        MNums = new int[M];
        for (int i = 0; i < M; i++) {
            MNums[i] = nextInt();
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
