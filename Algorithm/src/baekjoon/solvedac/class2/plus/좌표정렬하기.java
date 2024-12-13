package baekjoon.solvedac.class2.plus;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.PriorityQueue;

public class 좌표정렬하기 {

    static class Point {
        int x;
        int y;

        public Point(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }

    public static void main(String[] args) throws IOException {
        PriorityQueue<Point> pq = new PriorityQueue<>((o1, o2) -> {
            if (o1.x == o2.x) {
                return o1.y - o2.y;
            }

            return o1.x - o2.x;
        });
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(reader.readLine());

        for (int i = 0; i < N; i++) {
            String[] s = reader.readLine().split(" ");

            int x = Integer.parseInt(s[0]);
            int y = Integer.parseInt(s[1]);

            pq.offer(new Point(x, y));
        }

        while (!pq.isEmpty()) {
            Point poll = pq.poll();
            System.out.println(poll.x + " " + poll.y);
        }
    }
}
