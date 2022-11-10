package programmers.lv0.day1_9;

import java.util.Arrays;

public class ArraySlice {
    /**
     * 1 부터 3 까지 만 가지고 있기
     * 0
     */
    public static int[] solution(int[] numbers, int num1, int num2) {
        num2 += 1;
        int[] ints = Arrays.copyOfRange(numbers, num1, num2);
        return ints;
    }

    public static void main(String[] args) {
        int[] numbers = {1,2, 3, 4, 5};
        int num1 = 1;
        int num2 = 3;

        int[] solution = solution(numbers, num1, num2);

        for (int j : solution) {
            System.out.print(j);
        }
    }
}
