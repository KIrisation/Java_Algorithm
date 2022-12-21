package baekjoon.sort;

import java.util.Arrays;
import java.util.Comparator;
import java.util.Scanner;
import java.util.stream.Collectors;

public class SortInside {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String N = scanner.next();

        String sortedN = Arrays.stream(N.split(""))
                               .sorted(Comparator.reverseOrder())
                               .collect(Collectors.joining());

        System.out.println(sortedN);
    }
}
