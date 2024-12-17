package baekjoon.solvedac.class3;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.HashMap;
import java.util.Map;

public class 비밀번호_찾기 {

    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter writer = new BufferedWriter(new OutputStreamWriter(System.out));

        String[] s = reader.readLine().split(" ");

        int N = Integer.parseInt(s[0]);
        int M = Integer.parseInt(s[1]);

        Map<String, String> map = new HashMap<>();
        for (int i = 0; i < N; i++) {
            String[] s1 = reader.readLine().split(" ");
            map.put(s1[0], s1[1]);
        }

        for (int i = 0; i < M; i++) {
            writer.write(map.get(reader.readLine()));
            writer.newLine();
        }

        writer.flush();
    }
}
