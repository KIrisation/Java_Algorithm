package baekjoon.solved.class2;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class SquareEscape {

    static BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;
    static int[] nums;

    public static void main(String[] args) {
        nums = new int[5];

        for (int i = 1; i <= 4; i++) {
            nums[i] = nextInt();
        }

        System.out.println(Math.min(caseOne(), caseTwo()));
    }

    private static int caseOne() { // 0에서 최소수가 나오는 경우를 계산
        return Math.min(nums[1], nums[2]);
    }

    private static int caseTwo() { // 두 배열의 차에서 나오는 경우를 계산
        return Math.min(nums[3] - nums[1], nums[4] - nums[2]);
    }

    static String next() {
        while (st == null || !st.hasMoreElements()) {
            try {
                st = new StringTokenizer(reader.readLine());
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        return st.nextToken();
    }

    static int nextInt() {
        return Integer.parseInt(next());
    }
}
