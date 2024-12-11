package baekjoon.solvedac.class2;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class FindNum2 {

    static BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
    static StringBuilder sb = new StringBuilder();
    static int N, M;
    static int[] NNums;
    static int[] MNums;
    static StringTokenizer st;
    public static void main(String[] args) throws IOException {
        input();
        calculate();
        System.out.println(sb);
    }

    private static void calculate() {
        Arrays.sort(NNums); // 기준 배열이다. 기준 배열? 이 배열에 다른 배열의 값이 존재하는지 안하는지 알아 낼 것이기 때문.
        // 이분탐색을 할거니깐 무조건 정렬!!

        for (int MNum : MNums) { // MNum 의 수가 NNums 에 있는지 판단해야 한다.
            int leftIdx = 0;
            int rightIdx = NNums.length - 1;

            while (true) {
                if (leftIdx > rightIdx) {
                    sb.append("0\n");
                    break;
                }

                int middleIdx = (leftIdx + rightIdx) / 2;

                if (NNums[middleIdx] == MNum) {
                    sb.append("1\n");
                    break;
                } else if (NNums[middleIdx] > MNum) {
                    rightIdx = middleIdx - 1;
                } else {
                    leftIdx = middleIdx + 1;
                }
            }
        }

    }

    private static void input() throws IOException {
        N = Integer.parseInt(reader.readLine());
        NNums = new int[N];
        for (int i = 0; i < N; i++) {
            NNums[i] = nextInt();
        }

        M = Integer.parseInt(reader.readLine());
        MNums = new int[M];
        for (int i = 0; i < M; i++) {
            MNums[i] = nextInt();
        }
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
