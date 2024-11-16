package softeer.lv3;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

/**
 * https://softeer.ai/practice/9495
 *
 * [한양대 HCPC 2023] Hanyang Popularity Exceeding Competition
 */
public class 인기도_경쟁 {

    static BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
    static BufferedWriter writer = new BufferedWriter(new OutputStreamWriter(System.out));
    static StringTokenizer st;

    public static void main(String[] args) throws IOException {
        st = new StringTokenizer(reader.readLine());

        int N = Integer.parseInt(st.nextToken());
        int[][] famousPeople = new int[N][2];

        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(reader.readLine());

            famousPeople[i][0] = Integer.parseInt(st.nextToken());
            famousPeople[i][1] = Integer.parseInt(st.nextToken());
        }

        int currentPopularity = 0;

        for (int i = 0; i < N; i++) {
            int Pi = famousPeople[i][0];
            int Ci = famousPeople[i][1];

            if (Math.abs(Pi - currentPopularity) <= Ci) {
                currentPopularity++;
            }
        }

        writer.write(currentPopularity);
        writer.flush();
    }
}
