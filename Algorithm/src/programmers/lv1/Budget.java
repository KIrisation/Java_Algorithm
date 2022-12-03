package programmers.lv1;

import java.util.Arrays;

/**
 * 입출력 예
 * <p>
 * d	budget	result [1,3,2,5,4]	9	3 [2,2,3,3]	10	4
 */
public class Budget {

    public static void main(String[] args) {
        System.out.println(solution(new int[]{100, 100, 100, 100}, 9));
    }

    public static int solution(int[] d, int budget) {
        Arrays.sort(d);
        int departmentCnt = 0;

        if (d[0] == budget) {
            return ++departmentCnt;
        }

        if (d[0] > budget) {
            return departmentCnt;
        }

        int sum = d[0];
        ++departmentCnt;
        for (int i = 1; i < d.length; i++) {
            sum += d[i];

            if (sum > budget) {
                return departmentCnt;
            }

            ++departmentCnt;
        }

        return departmentCnt;
    }
}
