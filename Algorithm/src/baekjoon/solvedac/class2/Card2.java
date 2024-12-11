package baekjoon.solvedac.class2;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

/**
 * 백준 2164번: 카드2
 */
public class Card2 {

    static BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
    static StringBuilder sb = new StringBuilder();
    static StringTokenizer st;
    static int N;
    static Queue<Integer> queue = new LinkedList<>();
    public static void main(String[] args) {
        N = nextInt();

        for (int i = 1; i <= N; i++) {
            queue.offer(i);
        }

        while (true) {
            if (queue.size() == 1) {
                break;
            }

            queue.poll();
            Integer poll = queue.poll();
            queue.offer(poll);

        }

        System.out.println(queue.poll());
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
