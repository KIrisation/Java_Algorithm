package baekjoon.nandm;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.List;
import java.util.StringTokenizer;

public class N과_M_1_2try {

    static BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
    static StringBuilder sb = new StringBuilder();
    static StringTokenizer st;

    public static void main(String[] args) {
        int n = nextInt(); // 1부터 n까지의 수를 선택
        int m = nextInt(); // 선택된 수를 m개 만큼 뽑음

        recursive(n, m,new boolean[n], new LinkedList<>());
    }

    private static void recursive(int n, int m, boolean[] visited, LinkedList<Integer> nArrays) {
        if (m == 0) {
            for (Integer nArray : nArrays) {
                System.out.print(nArray + " ");
            }

            System.out.println();
            return;
        }

        for (int i = 0; i < n; i++) {
            if (visited[i]) {
                continue;
            }

            visited[i] = true;
            nArrays.add(i + 1);
            recursive(n, m - 1, visited, nArrays);
            visited[i] = false;
            nArrays.removeLast();
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
