package baekjoon.solvedac.class2.plus;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

/**
 * https://www.acmicpc.net/problem/4153
 */
public class 직각삼각형 {

    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String line;

        while ((line = reader.readLine()) != null) { // EOF 처리
            String[] s = line.split(" ");

            int a = Integer.parseInt(s[0]);
            int b = Integer.parseInt(s[1]);
            int c = Integer.parseInt(s[2]);

            // 종료 조건: "0 0 0" 입력 시 종료
            if (a == 0 && b == 0 && c == 0) {
                break;
            }

            // 세 변 정렬
            int[] triangle = {a, b, c};
            Arrays.sort(triangle);

            // 직각삼각형 판별
            if (Math.pow(triangle[0], 2) + Math.pow(triangle[1], 2) == Math.pow(triangle[2], 2)) {
                System.out.println("right");
            } else {
                System.out.println("wrong");
            }
        }
    }
}
