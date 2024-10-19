package baekjoon.nandm;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.StringTokenizer;

public class N과_M_1_3try {

    static BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
    static StringBuilder sb = new StringBuilder();
    static StringTokenizer st;
    static int n;
    static int m;

    public static void main(String[] args) {
        n = nextInt();
        m = nextInt();

        recursive(-1, new LinkedList<>());
    }

    private static void recursive(int now, LinkedList<Integer> outs) {
        if (outs.size() == m) {
            for (Integer out : outs) {
                System.out.print(out + " ");
            }

            System.out.println();
            return;
        }

        for (int i = 1; i <= n; i++) {
//            if (outs.size() == m) {
//                recursive(outs.getLast(), outs);
//                outs.removeLast();
//            }
//
//            outs.add(i);
//            // 이미 출력된 값에 대해서는 중복으로 출력해서는 안됨.
//            recursive(outs.getLast(), outs);
//            outs.removeLast();

            if (!outs.contains(i)) { // 중복된 숫자 제외
                outs.add(i);          // 숫자 추가
                recursive(i, outs);   // 재귀 호출
                outs.removeLast();    // 재귀 호출 후 마지막 숫자 제거
            }
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
