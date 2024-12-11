package baekjoon.solvedac.class1;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Constants {

    static BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
    public static void main(String[] args) throws IOException {
        String s = reader.readLine();
        String[] split = s.split(" ");

        StringBuilder firstNum = new StringBuilder(split[0]);
        StringBuilder secondNum = new StringBuilder(split[1]);

        int firstNumParsing = Integer.parseInt(firstNum.reverse().toString());
        int secondNumParsing = Integer.parseInt(secondNum.reverse().toString());

        System.out.println(Math.max(firstNumParsing, secondNumParsing));
    }
}
