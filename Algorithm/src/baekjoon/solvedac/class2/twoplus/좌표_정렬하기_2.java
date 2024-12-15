package baekjoon.solvedac.class2.twoplus;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.PriorityQueue;

public class 좌표_정렬하기_2 {

    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter writer = new BufferedWriter(new OutputStreamWriter(System.out));

        int N = Integer.parseInt(reader.readLine());
        PriorityQueue<int[]> pq = new PriorityQueue<>((o1, o2) -> {
            if (o1[1] == o2[1]) {
                return o1[0] - o2[0];
            }

            return o1[1] - o2[1];
        });

        for (int i = 0; i < N; i++) {
            int[] point = new int[2];
            String[] s = reader.readLine().split(" ");

            point[0] = Integer.parseInt(s[0]);
            point[1] = Integer.parseInt(s[1]);

            pq.offer(point);
        }

        while (!pq.isEmpty()) {
            int[] poll = pq.poll();

            writer.write(poll[0] + " " + poll[1]);
            writer.newLine();
        }

        writer.flush();
    }
}
