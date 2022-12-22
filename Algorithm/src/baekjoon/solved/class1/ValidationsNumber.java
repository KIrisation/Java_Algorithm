package baekjoon.solved.class1;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class ValidationsNumber {

    static BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

    public static void main(String[] args) throws IOException {
        System.out.println(Arrays.stream(reader.readLine().split(" "))
                                 .map(Integer::parseInt)
                                 .map(i -> i * i)
                                 .mapToInt(j -> j)
                                 .sum() % 10);
    }
}
