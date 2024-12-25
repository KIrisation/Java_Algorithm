package baekjoon.solvedac.class3;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

/**
 * https://www.acmicpc.net/problem/1541
 */
public class 잃어버린_괄호 {

    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter writer = new BufferedWriter(new OutputStreamWriter(System.out));

        int sum = Integer.MAX_VALUE;
        String[] subtraction = reader.readLine().split("-");
        for (String subtractGroup : subtraction) {
            int temp = 0;

            String[] addition = subtractGroup.split("\\+");

            for (String adddtionNum : addition) {
                temp += Integer.parseInt(adddtionNum);
            }

            if (sum == Integer.MAX_VALUE) {
                sum = temp;
            } else {
                sum -= temp;
            }
        }

        writer.write(sum);
        writer.flush();
    }
}
