package softeer.lv2;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class 지도_자동_구축 {

    static BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
    static BufferedWriter writer = new BufferedWriter(new OutputStreamWriter(System.out));
    static StringTokenizer st;

    public static void main(String[] args) throws IOException {
        int N = Integer.parseInt(reader.readLine());

        long[] answers = new long[16];
        answers[0] = 4;

        for (int i = 1; i <= 15; i++) {
            answers[i] = (long) Math.pow(((long) Math.sqrt(answers[i - 1])) + ((long) Math.pow(2, i - 1)), 2);
        }

        writer.write(String.valueOf(answers[N]));
        writer.flush();
    }
}