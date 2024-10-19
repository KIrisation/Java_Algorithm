package baekjoon.nandm;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.StringTokenizer;

public class N과_M_3 {

    static BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
    static StringBuilder sb = new StringBuilder();
    static StringTokenizer st;

    public static void main(String[] args) {
        int n = nextInt();
        List<Integer> nArrays = new ArrayList<>();
        for (int i = 1; i <= n; i++) {
            nArrays.add(i);
        }

        int m = nextInt();

        recursive(nArrays, m,  new LinkedList<>());
        System.out.println(sb);
    }

    private static void recursive(List<Integer> nArrays, int m, LinkedList<Integer> out) {
        // 1. 출력 조건
        if (m == 0) { // 다 뽑았으면.
            for (Integer value : out) {
                output(value);
            }

            sb.append("\n");
            return;
        }

        for (int i = 0; i < nArrays.size(); i++) {
            out.add(nArrays.get(i));
            recursive(nArrays, m - 1, out);
            out.removeLast();
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

    private static void output(Integer value) {
        sb.append(value).append(" ");
    }
}
