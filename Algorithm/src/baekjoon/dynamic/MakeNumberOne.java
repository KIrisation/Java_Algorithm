package baekjoon.dynamic;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

/**
 * 백준 1463번: 1로 만들기
 */
public class MakeNumberOne {

    static BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
    static int N;
    static int[] d;

    static StringBuilder sb = new StringBuilder();
    public static void main(String[] args) throws IOException {
        input();

        d = new int[N + 1];
        d[1] = 0; // 초기 값이 굉장히 중요하다! 초기 값은 주어진거고 이걸 구하면 안됨. 그래서 for 문은 2부터 시작한다.

        for (int i = 2; i <= N; i++) {
            d[i] = d[i - 1] + 1; // d[i] 가 뭐가 가장 작은지 알 수가 없기 때문에 가장 먼저 -1을 하고 시작함. + 1의 의미는 연산을 했다라는 의미임!

            if (i % 2 == 0) { // 일단 2로 나누어 떨어지는 가정을 한 뒤 이미 구해진 tmp 와 값을 비교 한 후 작은 값을 넣어줌. + 1의 의미는 연산을 했다라는 의미임!
                int tmp = d[i / 2] + 1;

                if (tmp < d[i]) {
                    d[i] = tmp;
                }
            }

            if (i % 3 == 0) { // 일단 3로 나누어 떨어지는 가정을 한 뒤 이미 구해진 tmp 와 값을 비교 한 후 작은 값을 넣어줌. + 1의 의미는 연산을 했다라는 의미임!
                int tmp = d[i / 3] + 1;

                if (tmp < d[i]) {
                    d[i] = tmp;
                }
            }
        }

        output();
    }

    static int[] memos;
    public static void main2(String[] args) throws IOException {
        input();
        memos = new int[N + 1];
        Arrays.fill(memos, -1);
        memos[1] = 0;
        recursion(N);
    }


    public static int recursion(int n) {

        if (memos[n] != -1) {
            return memos[n];
        }

        int num = recursion(n - 1) + 1;

        if (n % 3 == 0) {
            int tmp = recursion(n / 3) + 1;

            if (tmp < num) {
                num = tmp;
            }
        }

        if (n % 2 == 0) {
            int tmp = recursion(n / 2) + 1;

            if (tmp < num) {
                num = tmp;
            }
        }

        return memos[n] = num;
    }

    private static void output() {
        sb.append(d[N]);
        System.out.println(sb);
    }

    private static void input() throws IOException {
        N = Integer.parseInt(reader.readLine());
    }
}
