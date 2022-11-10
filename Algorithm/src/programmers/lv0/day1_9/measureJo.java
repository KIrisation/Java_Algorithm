package programmers.lv0.day1_9;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class measureJo {

    public static void main(String[] args) {
        List<Integer> list = new ArrayList<>();

        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();

        for (int i = 1; i * i <= n; i++) {
            if (n % i == 0) {
                list.add(i);
                list.add(n / i);
            }
        }

        for (Integer integer : list) {
            System.out.println(integer);
        }
    }

}

