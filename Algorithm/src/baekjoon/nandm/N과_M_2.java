package baekjoon.nandm;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.StringTokenizer;

public class N과_M_2 {

    static BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
    static StringBuilder sb = new StringBuilder();
    static StringTokenizer st;

    public static void main(String[] args) {
        int n = nextInt();
        int m = nextInt();

        recursive(n, m, new LinkedList<>(), 1);
    }

    private static void recursive(int n, int m, LinkedList<Integer> lists, int num) { // 4 2
        if (lists.size() == m) {
            for (Integer value : lists) {
                System.out.print(value + " ");
            }

            System.out.println();
            return;
        }

        if (n < num) {
            return;
        }

        // num을 안뽑을거임.
        recursive(n, m, lists, num + 1);

        lists.add(num);
        // num을 뽑을거임.
        recursive(n, m, lists, num + 1);
        lists.removeLast();



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
