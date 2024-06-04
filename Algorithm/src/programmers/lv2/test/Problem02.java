package programmers.lv2.test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Problem02 {

    static int[][] TRIANGLE_SNAIL;
    static int NUM;

    static int CURRENT_X;
    static int CURRENT_Y;

    public static void main(String[] args) {
        Problem02 problem02 = new Problem02();

        int[] solution = problem02.solution(1);

        System.out.println(Arrays.deepToString(TRIANGLE_SNAIL));
        System.out.println(Arrays.toString(solution));
    }

    public int[] solution(int n) {
        TRIANGLE_SNAIL = new int[n][n];
        init();

        while (true) {

            if (!down()) {
                break;
            }

            if (!right()) {
                break;
            }

            if (!diagonal()) {
                break;
            }
        }

        List<Integer> result = new ArrayList<>();

        for (int[] row : TRIANGLE_SNAIL) {
            for (int num : row) {
                if (num == 0) {
                    continue;
                }

                result.add(num);
            }
        }

        return result.stream()
                     .mapToInt(Integer::intValue)
                     .toArray();
    }

    public void init() {
        TRIANGLE_SNAIL[CURRENT_Y][CURRENT_X] = ++NUM;
    }

    public boolean down() {
        ++CURRENT_Y;

        if (isFinish()) {
            return false;
        }

        while (CURRENT_Y < TRIANGLE_SNAIL.length && TRIANGLE_SNAIL[CURRENT_Y][CURRENT_X] == 0 ) {
            TRIANGLE_SNAIL[CURRENT_Y][CURRENT_X] = ++NUM;
            ++CURRENT_Y;
        }

        --CURRENT_Y;

        return true;
    }

    public boolean right() {
        ++CURRENT_X;

        if (isFinish()) {
            return false;
        }

        while (CURRENT_X < TRIANGLE_SNAIL[CURRENT_Y].length && TRIANGLE_SNAIL[CURRENT_Y][CURRENT_X] == 0) {
            TRIANGLE_SNAIL[CURRENT_Y][CURRENT_X] = ++NUM;
            ++CURRENT_X;
        }

        --CURRENT_X;

        return true;
    }

    public boolean diagonal() {
        --CURRENT_Y;
        --CURRENT_X;

        if (isFinish()) {
            return false;
        }

        while (TRIANGLE_SNAIL[CURRENT_Y][CURRENT_X] == 0) {
            TRIANGLE_SNAIL[CURRENT_Y][CURRENT_X] = ++NUM;
            --CURRENT_Y;
            --CURRENT_X;

        }

        ++CURRENT_Y;
        ++CURRENT_X;

        return true;
    }

    public boolean isFinish() {
        if (CURRENT_Y >= TRIANGLE_SNAIL.length) {
            return true;
        }

        if (CURRENT_X >= TRIANGLE_SNAIL[0].length) {
            return true;
        }

        return TRIANGLE_SNAIL[CURRENT_Y][CURRENT_X] != 0;
    }
}
