package baekjoon.solved.class1;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

/**
 * 백준 8958번: OX 퀴즈
 */
public class OXQuiz {

    static BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
    static List<String> quiz = new ArrayList<>();
    static StringBuilder sb = new StringBuilder();
    static List<Integer> scores = new ArrayList<>();
    static List<Integer> result = new ArrayList<>();
    static char o = 'O';
    static char x = 'X';

    public static void main(String[] args) throws IOException {
        input();
        solveQuiz();
        output();
    }

    private static void input() throws IOException {
        int N = Integer.parseInt(reader.readLine());

        for (int i = 0; i < N; i++) {
            quiz.add(reader.readLine());
        }
    }

    private static void solveQuiz() {
        int score = 0;

        for (String s : quiz) {
            for (int i = 0; i < s.length(); i++) {
                if (s.charAt(i) == o) {
                    scores.add(++score);
                } else {
                    score = 0;
                    scores.add(score);
                }
            }

            result.add(scores.stream().mapToInt(i -> i).sum());
            scores.clear();
            score = 0;
        }
    }

    private static void output() {
        for (Integer integer : result) {
            sb.append(integer)
              .append("\n");
        }

        System.out.println(sb);
    }
}
