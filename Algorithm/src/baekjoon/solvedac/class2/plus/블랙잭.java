package baekjoon.solvedac.class2.plus;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * https://www.acmicpc.net/problem/2798
 *
 * 주석 코드 같은 경우
 * 문제 요구사항 분석이 미흡하여, 처리하지 않아도 될 내용을 처리하다보니 코드가 정상적인 동작을 하지 않았음
 *
 * 1. 3개 이상의 입력만 주어짐에도 3개 이하의 처리.
 * 2. M의 값을 초과하는 입력값은 주어지지 않음에도 절대 값을 이용하여 잘못된 값 처리를 했음.
 */
public class 블랙잭 {
//    static List<Integer> answers = new ArrayList<>();
    static int M;
    static int maxSum = Integer.MIN_VALUE;

    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String[] s = reader.readLine().split(" ");
        
        int N = Integer.parseInt(s[0]); // 카드수
        M = Integer.parseInt(s[1]); // 타겟숫자
        int[] deck = new int[N];
        boolean[] visited = new boolean[N];
        String[] nums = reader.readLine().split(" ");
        for (int i = 0; i < N; i++) {
            deck[i] = Integer.parseInt(nums[i]);
        }

//        int sum = 0;
//        if (M <= 3) {
//            for (int i : deck) {
//                sum += i;
//            }
//
//            System.out.println(sum);
//            return;
//        }
        
        dfs(deck, visited, 0, 0);
        System.out.println(maxSum);

//        int min = Math.abs(M - answers.get(0));
//        int idx = -1;
//        for (int i = 1; i < answers.size(); i++) {
//            int abs = Math.abs(M - answers.get(i));
//            if (min > abs) {
//                min = abs;
//                idx = i;
//            }
//        }

//        System.out.println(answers.get(idx);
    }
    
    public static void dfs(int[] deck, boolean[] visited, int cnt, int sum) {
        if (cnt == 3) {
            if (sum <= M) {
                maxSum = Math.max(maxSum, sum);
            }

            return;
        }

        for (int i = 0; i < deck.length; i++) {
            if (!visited[i]) {
                visited[i] = true;
                dfs(deck, visited, cnt + 1, sum + deck[i]);
                visited[i] = false;
            }
        }
    }
}
