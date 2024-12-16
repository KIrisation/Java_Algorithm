package baekjoon.solvedac.class3;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;

public class 듣보잡 {

    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter writer = new BufferedWriter(new OutputStreamWriter(System.out));
        String[] s = reader.readLine().split(" ");
        int N = Integer.parseInt(s[0]);
        int M = Integer.parseInt(s[1]);

        Map<String, Integer> map = new HashMap<>();
        for (int i = 0; i < N; i++) { // 듣도 못한
            map.put(reader.readLine(), 1);
        }

        List<String> list = new ArrayList<>();
        for (int i = 0; i < M; i++) { // 보도 못한
            String name = reader.readLine();

            if (map.containsKey(name)) {
                list.add(name);
            }
        }

        list.sort(Comparator.naturalOrder());

        writer.write(String.valueOf(list.size()));
        writer.newLine();

        for (String string : list) {
            writer.write(string);
            writer.newLine();
        }

        writer.flush();
    }
}
