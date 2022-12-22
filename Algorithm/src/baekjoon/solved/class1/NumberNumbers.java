package baekjoon.solved.class1;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

public class NumberNumbers {

    static BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
    public static void main(String[] args) throws IOException {
        int result = 1;
        for (int i = 0; i < 3; i++) {
            result *= Integer.parseInt(reader.readLine());
        }
        String s = String.valueOf(result);

        int cnt = 0;
        List<Integer> cnts = new ArrayList<>();
        for (int i = 0; i <= 9; i++) {
            for (int j = 0; j < s.length(); j++) {
                if (i != s.charAt(j) - '0' && j == s.length() - 1) {
                    cnts.add(cnt);
                    cnt = 0;
                    continue;
                } else if (i == s.charAt(j) - '0' && j == s.length() - 1) {
                    cnts.add(++cnt);
                    cnt = 0;
                    continue;
                }

                if (i == s.charAt(j) - '0') {
                    cnt++;
                }
            }
        }

        for (Integer integer : cnts) {
            System.out.println(integer);
        }
    }
}
