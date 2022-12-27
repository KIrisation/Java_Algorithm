package programmers.lv2;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

public class FindPrimeNumber {

    private static boolean[] visit;
    private static int cnt = 0;
    private static Set<Integer> set = new HashSet<>();

    public static void main(String[] args) {
        solution("17");
    }

    public static int solution(String numbers) {
        visit = new boolean[numbers.length()];

        Arrays.fill(visit, false);
        recursion("", numbers);

        for (Integer integer : set) {
                checkPrimeNum(integer);
        }

        return cnt;
    }

    private static void recursion(String tmp, String numbers) {
        if (tmp.length() != 0) {
            set.add(Integer.parseInt(tmp));
        }

        for (int i = 0; i < numbers.length(); i++) {
            if (!visit[i]) {
                visit[i] = true;
                recursion(tmp + numbers.charAt(i), numbers);
                visit[i] = false;
            }
        }
    }

    private static void checkPrimeNum(int tmp) {
        if (tmp < 2) {
            return;
        }

        for (int j = 2; j * j <= tmp; j++) {
            if (tmp % j == 0) {
                return;
            }
        }

        cnt++;
    }
}
