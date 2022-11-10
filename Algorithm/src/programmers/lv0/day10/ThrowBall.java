package programmers.lv0.day10;

public class ThrowBall {

    public static void main(String[] args) {
        System.out.println(solution(new int[]{1, 2, 3, 4}, 2));
    }

    public static int solution(int[] numbers, int k) {
        int cursor = 0;
        int cnt = 1;

        while (true) {
            if (cnt == k) {
                break;
            }

            if (cursor == numbers.length - 1) {
                cursor = 1;
                cnt++;
                continue;
            }

            if (cursor == numbers.length - 2) {
                cursor = 0;
                cnt++;
                continue;
            }

            cursor += 2;
            cnt++;
        }

        return numbers[cursor];
    }
}
