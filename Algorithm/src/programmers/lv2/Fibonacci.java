package programmers.lv2;

import java.util.Arrays;

public class Fibonacci {

    public static void main(String[] args) {

    }

    static int[] memos;

    public int solution(int n) { //  TOP DOWN 방식의 재귀 문제점: 중복된 계산을 하게 된다. -> Memoization 으로 해결.
        int answer = 0;
        memos = new int[n + 1];
        Arrays.fill(memos, -1);
        memos[0] = 0;
        memos[1] = 1;
        answer = recursion(n);

        return answer;
    }

    public int recursion(int n) {
        if (memos[n] != -1) {
            return memos[n];
        }

        return memos[n] = (recursion(n - 1) + recursion(n - 2)) % 1234567;
    }

    static int[] fibonacci;

    public int solution2(int n) { // Bottom Up 방식
        fibonacci = new int[n + 1];

        fibonacci[0] = 0;
        fibonacci[1] = 1;

        for (int i = 2; i <= n; i++) {
            fibonacci[i] = (fibonacci[i - 1] + fibonacci[i - 2]) % 1234567;
        }

        return fibonacci[n];
    }
}
