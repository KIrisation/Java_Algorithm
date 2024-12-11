package baekjoon.workbook;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class 가운데를_말해요 {

    static BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
    static BufferedWriter writer = new BufferedWriter(new OutputStreamWriter(System.out));
    static StringTokenizer st;

    public static void main(String[] args) throws IOException {
        int N = Integer.parseInt(reader.readLine());

        int mid = Integer.parseInt(reader.readLine());
        int min = Integer.MAX_VALUE;
        int max = Integer.MIN_VALUE;
        writer.write(mid);

        for (int i = 2; i <= N; i++) {
            int curretnNum = Integer.parseInt(reader.readLine());

            if (curretnNum < min) {
                min = curretnNum;
            }

            if (curretnNum > max) {
                max = curretnNum;
            }

            if (min < mid && mid < max) {
                writer.write(mid);
            }
        }
    }
}
