package programmers.lv2;

import java.util.Arrays;

public class BigestNumber {

    public static void main(String[] args) {
        solution(new int[]{6, 10, 2});
    }
    public static String solution(int[] numbers) {
        String[] stringNumbers =
                Arrays.stream(numbers).mapToObj(String::valueOf).toArray(String[]::new);

        Arrays.sort(stringNumbers, (o1, o2) -> {
                int compareResult = (o1 + o2).compareTo(o2 + o1);

                if (compareResult > 0) {
                    return - 1;
                } else if (compareResult == 0) {
                    return 0;
                }

                return 1;
        });

        return String.join("", stringNumbers);
    }
}
