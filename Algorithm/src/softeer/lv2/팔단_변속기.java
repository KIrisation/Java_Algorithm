package softeer.lv2;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

/**
 * https://softeer.ai/practice/6283
 */
public class 팔단_변속기 {
    static BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
    static BufferedWriter writer = new BufferedWriter(new OutputStreamWriter(System.out));
    static StringTokenizer st;

    public static void main(String[] args) throws IOException {
        st = new StringTokenizer(reader.readLine());

        int[] gears = new int[8];
        for (int i = 0; i < 8; i++) {
            gears[i] = Integer.parseInt(st.nextToken());
        }

        boolean isAscending = true;
        boolean isDescending = true;

        for (int i = 0; i < 7; i++) {
            if (gears[i] < gears[i + 1]) {
                isDescending = false;
            } else if (gears[i] > gears[i + 1]) {
                isAscending = false;
            }
        }

        if (isAscending) {
            writer.write("ascending");
        } else if (isDescending) {
            writer.write("descending");
        } else {
            writer.write("mixed");
        }

        writer.flush();
    }

}
