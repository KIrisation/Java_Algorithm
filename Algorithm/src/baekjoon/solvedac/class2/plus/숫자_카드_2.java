package baekjoon.solvedac.class2.plus;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.HashMap;
import java.util.Map;

public class 숫자_카드_2 {

    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter writer = new BufferedWriter(new OutputStreamWriter(System.out));

        int N = Integer.parseInt(reader.readLine());
        Map<String, Integer> map = new HashMap<>();
        String[] s = reader.readLine().split(" ");
        for (int i = 0; i < N; i++) {
            int value = map.getOrDefault(s[i], 0);
            if (value == 0) {
                map.put(s[i], 1);
            } else {
                map.put(s[i], value + 1);
            }
        }

        int M = Integer.parseInt(reader.readLine());
        String[] s1 = reader.readLine().split(" ");
        for (int i = 0; i < M; i++) {
            writer.write((map.getOrDefault(s1[i], 0)) + " ");
        }

        writer.flush();
    }
}
