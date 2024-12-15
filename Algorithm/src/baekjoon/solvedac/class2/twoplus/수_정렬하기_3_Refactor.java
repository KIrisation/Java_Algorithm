package baekjoon.solvedac.class2.twoplus;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class 수_정렬하기_3_Refactor {

    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter writer = new BufferedWriter(new OutputStreamWriter(System.out));

        int N = Integer.parseInt(reader.readLine());

        int[] cnt = new int[10001];
        for (int i = 0; i < N; i++) {
            ++cnt[Integer.parseInt(reader.readLine())];
        }

        for (int i = 1; i < N; i++) {
            while (cnt[i] != 0) {
                writer.write(String.valueOf(i));
                writer.newLine();
                --cnt[i];
            }
        }

        writer.flush();
    }
}
