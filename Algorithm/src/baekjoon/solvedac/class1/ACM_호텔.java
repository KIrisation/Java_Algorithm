package baekjoon.solvedac.class1;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class ACM_호텔 {

    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter writer = new BufferedWriter(new OutputStreamWriter(System.out));
        int T = Integer.parseInt(reader.readLine()); // 테스트 갯수

        StringTokenizer st;
        String[][] rooms;
        for (int i = 0; i < T; i++) {
            st = new StringTokenizer(reader.readLine());

            int H = Integer.parseInt(st.nextToken());
            int W = Integer.parseInt(st.nextToken());
            int target = Integer.parseInt(st.nextToken());
            rooms = new String[H + 1][W + 1];

            StringBuilder sb;
            for (int j = 1; j <= H; j++) {
                for (int k = 1; k <= W; k++) {
                    sb = new StringBuilder();
                    if (k < 10) {
                        rooms[j][k] = sb.append(j).append("0").append(k).toString();
                    } else {
                        rooms[j][k] = sb.append(j).append(k).toString();
                    }
                }
            }

            int cnt = 0;
            for (int j = 1; j <= W; j++) {  // 12
                for (int k = 1; k <= H; k++) { // 6
                    ++cnt;
                    if (target == cnt) {
                        writer.write(rooms[k][j]);
                        writer.newLine();
                        break;
                    }
                }
            }

            writer.flush();
        }
    }
}
