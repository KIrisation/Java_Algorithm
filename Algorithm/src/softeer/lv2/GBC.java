package softeer.lv2;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class GBC {

    static BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
    static BufferedWriter writer = new BufferedWriter(new OutputStreamWriter(System.out));
    static StringTokenizer st;

    public static void main(String[] args) throws IOException {
        st = new StringTokenizer(reader.readLine());
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        int[] standard = new int[100];
        int before = 0;
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(reader.readLine());
            int length = Integer.parseInt(st.nextToken());
            int speed = Integer.parseInt(st.nextToken());

            for (int j = before; j < before + length; j++) {
                standard[j] = speed;
            }
            before += length;
        }

        int[] limit = new int[100];
        before = 0;
        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(reader.readLine());
            int length = Integer.parseInt(st.nextToken());
            int speed = Integer.parseInt(st.nextToken());

            for (int j = before; j < before + length; j++) {
                limit[j] = speed;
            }

            before += length;
        }

        int answer = 0;
        for (int i = 0; i < 100; i++) {
            answer = Math.max(limit[i] - standard[i], answer);
        }

        writer.write(String.valueOf(answer));
        writer.flush();
    }
}
