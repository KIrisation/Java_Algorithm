package baekjoon.nandm;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.StringTokenizer;

/**
 * 문제 자연수 N과 M이 주어졌을 때, 아래 조건을 만족하는 길이가 M인 수열을 모두 구하는 프로그램을 작성하시오.
 * <p>
 * 1부터 N까지 자연수 중에서 중복 없이 M개를 고른 수열 입력 첫째 줄에 자연수 N과 M이 주어진다. (1 ≤ M ≤ N ≤ 8)
 * <p>
 * 출력 한 줄에 하나씩 문제의 조건을 만족하는 수열을 출력한다. 중복되는 수열을 여러 번 출력하면 안되며, 각 수열은 공백으로 구분해서 출력해야 한다.
 * <p>
 * 수열은 사전 순으로 증가하는 순서로 출력해야 한다.
 */
public class N과_M_1 {

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

        recursive(nArrays, m,  new LinkedList<>(), new boolean[nArrays.size()]);
    }

    private static void recursive(List<Integer> nArrays, int m, LinkedList<Integer> out, boolean[] visited) {
        // 1. 출력 조건
        if (m == 0) { // 다 뽑았으면.
            for (Integer value : out) {
                System.out.print(value + " ");
            }

            System.out.println();
            return;
        }

        for (int i = 0; i < nArrays.size(); i++) {
            if (visited[i]) {
                continue;
            }

            visited[i] = true;
            out.add(nArrays.get(i));
            recursive(nArrays, m - 1, out, visited);
            visited[i] = false;
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
}
