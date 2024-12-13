package baekjoon.solvedac.class2.plus;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;

public class 요세푸스_문제_0 {

    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String[] s = reader.readLine().split(" ");
        int N = Integer.parseInt(s[0]);
        int K = Integer.parseInt(s[1]);

        Queue<Integer> q = new LinkedList<>();
        for (int i = 1; i <= N; i++) {
            q.offer(i);
        }

        StringBuilder sb = new StringBuilder("<");
        int start = 0;
        while (!q.isEmpty()) {
            if (q.size() == 1) {
                sb.append(q.poll());
                break;
            }

            for (int i = 1; i <= K; i++) {
                Integer poll = q.poll();
                if (K == i) {
                    sb.append(poll).append(", ");
                    continue;
                }

                q.offer(poll);
            }
        }

        sb.append(">");
        System.out.println(sb);
    }
}
