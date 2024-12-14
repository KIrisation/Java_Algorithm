package baekjoon.solvedac.class2.twoplus;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class 벌집 {

    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter writer = new BufferedWriter(new OutputStreamWriter(System.out));

        int N = Integer.parseInt(reader.readLine());

        int cnt = 1;
        int area = 2;

        if (N == 1) {
            writer.write("1");
            writer.flush();
            return;
        }

        while (area <= N) {
            area = area + (6 * cnt);
            cnt++;
        }

        writer.write(String.valueOf(cnt));
        writer.flush();
    }
}
