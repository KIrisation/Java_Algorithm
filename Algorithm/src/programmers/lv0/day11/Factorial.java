package programmers.lv0.day11;

public class Factorial {
    public int solution(int n) {
        for (int i = 1; i <= 10; i++) {
            int factorialValue = factorial(i);

            if (n == factorial(i)) {
                return i;
            }

            if (n < factorialValue) {
                return i - 1;
            }
        }

        return n;
    }

    public static int factorial(int i) {
        if (i - 1 == 0) {
            return 1;
        }

        return i * factorial(i - 1);
    }

}
