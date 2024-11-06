package softeer.lv2;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.StringTokenizer;

/**
 * @https://softeer.ai/practice/7374
 */
public class 진정한_효도 {

    private static final BufferedReader READER = new BufferedReader(new InputStreamReader(System.in));
    private static final BufferedWriter WRITER = new BufferedWriter(new OutputStreamWriter(System.out));
    private static StringTokenizer st;
    public static List<Integer> row = new ArrayList<>();

    public static void main(String[] args) throws IOException {
        int[][] ground = new int[3][3];
        int currentCost;
        int answer = 4;
        for (int i = 0; i < 3; i++) {
            st = new StringTokenizer(READER.readLine());
            for (int j = 0; j < 3; j++) {
                int height = Integer.parseInt(st.nextToken());
                ground[i][j] = height;
                row.add(height);
            }

            Collections.sort(row);
            if (row.get(0) == row.get(2)) {
                System.out.println(0);
                return;
            } else {
                currentCost = (row.get(2) - row.get(0)) + (row.get(2) - row.get(1));
            }
            if (currentCost < answer) {
                answer = currentCost;
            }
            row.clear();
        }

        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                row.add(ground[j][i]);
            }
            Collections.sort(row);
            if (row.get(0) == row.get(2)) {
                System.out.println(0);
                return;
            } else {
                currentCost = (row.get(2) - row.get(0)) + (row.get(2) - row.get(1));
            }
            if (currentCost < answer) {
                answer = currentCost;
            }
            row.clear();
        }

        WRITER.write(String.valueOf(answer));
        WRITER.flush();
        WRITER.close();
    }
}
