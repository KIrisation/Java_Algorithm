package baekjoon.solvedac.class2.twoplus;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class 덩치_Refactor {

    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter writer = new BufferedWriter(new OutputStreamWriter(System.out));
        int N = Integer.parseInt(reader.readLine());
        int[][] people = new int[N][2];
        for (int i = 0; i < N; i++) {
            String[] s = reader.readLine().split(" ");

            int weight = Integer.parseInt(s[0]);
            int height = Integer.parseInt(s[1]);

            people[i][0] = weight;
            people[i][1] = height;
        }

        for (int i = 0; i < N; i++) {
            int rank = 1;

            for (int j = 0; j < N; j++) {
                if (i == j) {
                    continue;
                }

                if (people[i][0] < people[j][0] && people[i][1] < people[j][1]) {
                    ++rank;
                }
            }

            writer.write(rank + " ");
        }

        writer.flush();
    }
}
