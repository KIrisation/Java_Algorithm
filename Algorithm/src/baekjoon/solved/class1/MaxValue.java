package baekjoon.solved.class1;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

/**
 *  백준 2562번: 최댓 값
 */
public class MaxValue {

    static BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

    public static void main(String[] args) throws IOException {
        int[] result = new int[9];
        for (int i = 0; i < 9; i++) {
            result[i] = Integer.parseInt(reader.readLine());
        }

        int max = Arrays.stream(result).max().orElseThrow();
        System.out.println(max);

        for (int i = 0; i < result.length; ++i) {
            if (max == result[i]) {
                System.out.println(i + 1);
                break;
            }
        }
    }
}
