package baekjoon.solvedac.class2.twoplus;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.PriorityQueue;

/**
 * 시간 초과
 */
public class 수_정렬하기_3_Fail {

    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter writer = new BufferedWriter(new OutputStreamWriter(System.out));
        int N = Integer.parseInt(reader.readLine());

        PriorityQueue<Integer> pq = new PriorityQueue<>();
        for (int i = 0; i < N; i++) {
            pq.offer(Integer.parseInt(reader.readLine()));
        }

        while (!pq.isEmpty()) {
            writer.write(pq.poll());
        }

        writer.flush();
    }
}
