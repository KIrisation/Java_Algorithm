package baekjoon.solvedac.class1;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

/**
 * 백준 2675번: 문자열 반복
 */
public class StringRepetition {
    static BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
    static List<Integer> repetitions = new ArrayList<>();
    static List<String> results = new ArrayList<>();
    static StringBuilder sb = new StringBuilder();

    public static void main(String[] args) throws IOException {
        input();
        repetition();
        output();
    }

    private static void input() throws IOException {
        int T = Integer.parseInt(reader.readLine()); // 테스트 케이스의 개수
        for (int i = 0; i < T; i++) {
            String s = reader.readLine();
            String[] split = s.split(" ");
            repetitions.add(Integer.parseInt(split[0]));
            results.add(split[1]);
        }
    }

    private static void repetition() {
        for (int i = 0; i < repetitions.size(); i++) {
            String[] split = results.get(i).split("");
            for (String s : split) {
                sb.append(s.repeat(repetitions.get(i)));
            }
            sb.append("\n");
        }
    }

    private static void output() {
        System.out.println(sb.toString());
    }
}
