package baekjoon.solvedac.class2.twoplus;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.HashMap;
import java.util.Map;

public class FizzBuzz {

    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter writer = new BufferedWriter(new OutputStreamWriter(System.out));

        String[] s = new String[3];

        s[0] = reader.readLine();
        s[1] = reader.readLine();
        s[2] = reader.readLine();

        Map<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < 3; i++) {
            if (Character.isDigit(s[i].charAt(0))) {
                map.put(i, Integer.parseInt(s[i]));
            }
        }

        int value = 0;
        for (Map.Entry<Integer, Integer> nums : map.entrySet()) {
            int idx1 = nums.getKey();
            int value1 = nums.getValue();

            if (idx1 == 0) {
                value += value1 + 3;
                break;
            } else if (idx1 == 1) {
                value += value1 + 2;
                break;
            } else if (idx1 == 2) {
                value += value1 + 1;
            }
        }

        if (value % 3 == 0) {
            if (value % 5 == 0) {
                System.out.println("FizzBuzz");
            } else {
                System.out.println("Fizz");
            }
        } else if (value % 5 == 0) {
            System.out.println("Buzz");
        } else {
            System.out.println(value);
        }
    }
}
