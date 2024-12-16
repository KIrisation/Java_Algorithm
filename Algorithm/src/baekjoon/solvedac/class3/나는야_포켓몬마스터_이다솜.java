package baekjoon.solvedac.class3;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.HashMap;
import java.util.Map;

public class 나는야_포켓몬마스터_이다솜 {

    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter writer = new BufferedWriter(new OutputStreamWriter(System.out));
        String[] s = reader.readLine().split(" ");
        int N = Integer.parseInt(s[0]);
        int M = Integer.parseInt(s[1]);

        Map<Integer, String> dicName = new HashMap<>();
        Map<String, Integer> dicIdx = new HashMap<>();
        for (int i = 1; i <= N; i++) {
            String name = reader.readLine();
            dicName.put(i, name);
            dicIdx.put(name, i);
        }

        for (int i = 0; i < M; i++) {
            String s1 = reader.readLine();

            if (Character.isDigit(s1.charAt(0))) {
                writer.write(dicName.get(Integer.parseInt(s1)));
            } else {
                writer.write(String.valueOf(dicIdx.get(s1)));
            }

            writer.newLine();
        }

        writer.flush();
    }
}
