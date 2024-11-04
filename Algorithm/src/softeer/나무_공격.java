package softeer;

import java.io.*;
import java.util.*;

public class 나무_공격 {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    static StringTokenizer st;

    public static void main(String[] args) throws IOException {
        st = new StringTokenizer(br.readLine());

        int n = Integer.parseInt(st.nextToken()); // 행
        int m = Integer.parseInt(st.nextToken()); // 열

        int[][] maps = new int[n + 1][m + 1];
        int cnt = 0;
        for (int i = 1; i <= n; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 1; j <= m; j++) {
                maps[i][j] = Integer.parseInt(st.nextToken());

                if (maps[i][j] ==  1) {
                    cnt++;
                }
            }
        }

        bw.write(Arrays.deepToString(maps));
        bw.write(cnt);

        st = new StringTokenizer(br.readLine());
        int firstAttackPoint1 = Integer.parseInt(st.nextToken());
        int firstAttackPoint2 = Integer.parseInt(st.nextToken());

        for (int i = firstAttackPoint1; i <= firstAttackPoint2; i++) { // 행
            for (int j = 1; j <= m; j++) {
                if (maps[i][j] ==  1) {
                    maps[i][j] = 0;
                    j = m;
                    cnt--;
                }
            }
        }

        st = new StringTokenizer(br.readLine());
        int secondAttackPoint1 = Integer.parseInt(st.nextToken());
        int secondAttackPoint2 = Integer.parseInt(st.nextToken());

        for (int i = secondAttackPoint1; i <= secondAttackPoint2; i++) {
            for (int j = 1; j <= m; j++) {
                if (maps[i][j] ==  1) {
                    maps[i][j] = 0;
                    j = m;
                    cnt--;
                }
            }
        }

        bw.write(cnt);
        bw.flush();
        bw.close();
    }
}
