package baekjoon.solvedac.class3.fail;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Arrays;

/**
 * 순수하게 2차원 배열로는 풀 수 없었던 문제였던것 같은데
 * 피드백이 필요한 코드임.
 * 그래프로 BFS를 호출하는 코드로 리팩터링 예정
 */
public class 케빈_베이컨의_6단계_법칙_Fail {

    static int min = Integer.MAX_VALUE;
    static int result = 0;
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter writer = new BufferedWriter(new OutputStreamWriter(System.out));

        String[] s = reader.readLine().split(" ");
        int N = Integer.parseInt(s[0]);
        int M = Integer.parseInt(s[1]);

        int[][] friends = new int[N + 1][N + 1];
        int[] answers = new int[N + 1];
        for (int i = 0; i < M; i++) {
            s = reader.readLine().split(" ");
            int first = Integer.parseInt(s[0]);
            int second = Integer.parseInt(s[1]);

            friends[first][second] = 1;
            friends[second][first] = 1;
        }

        for (int i = 1; i <= N; i++) {
            // 찾아야 할 친구번호
            dfs(friends, 1 /*찾을 idx*/, 1, 1, answers);
        }

        System.out.println(Arrays.toString(answers));

    }

    public static void dfs(int[][] friends, int findIdx, int y, int x, int[] answers) {
        for (int i = y; i <= friends.length - 1; i++) {
            for (int j = x; j <= friends[0].length - 1; j++) {
                if (i == findIdx && friends[findIdx][j] == 1) {
                    ++answers[findIdx];
                } else if (friends[i][j] == 1){
                    dfs(friends, findIdx, i, j, answers);
                }
            }
        }
    }
}
