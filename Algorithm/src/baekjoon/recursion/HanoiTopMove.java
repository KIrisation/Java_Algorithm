package baekjoon.recursion;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class HanoiTopMove {

}


/**
 * 세 개의 장대가 있고 첫 번째 장대에는 반경이 서로 다른 n개의 원판이 쌓여 있다. 각 원판은 반경이 큰 순서대로 쌓여있다. 이제 수도승들이 다음 규칙에 따라 첫 번째 장대에서 세 번째 장대로 옮기려 한다.
 * <p>
 * 1. 한 번에 한 개의 원판만을 다른 탑으로 옮길 수 있다. 2. 쌓아 놓은 원판은 항상 위의 것이 아래의 것보다 작아야 한다.
 * <p>
 * 이 작업을 수행하는데 필요한 이동 순서를 출력하는 프로그램을 작성하라. 단, 이동 횟수는 최소가 되어야 한다.
 * <p>
 * 해당 문제의 핵심은 분할정복이다.
 */
class MainHanoiTopMove {

    static FastReader scan = new FastReader();

    static int N, K;

    static List<String> result = new ArrayList<>();

    static void input() {
        // 쌓인 원판의 개수
        N = scan.nextInt();
    }
    static void output() throws IOException {
        scan.output();
    }

    public static void main(String[] args) throws IOException {
        input();
        recursionHanoi(1, 3, N);
        output();
    }

    private static void recursionHanoi(int start, int end, int cnt) throws IOException {

        if (cnt == 1) {
            result.add(start + " " + end);
            K += 1;
            return;
        }

        recursionHanoi(start, 6 - (start + end), cnt - 1); // 맨 아래의 블록을 제외한 나머지 블록들을 end 가 아닌 다른 곳으로 이동
        recursionHanoi(start, end, 1); // 맨 아래의 블록을 end 로 이동.
        recursionHanoi(6 - (start + end), end, cnt - 1); // 맨 아래의 블록을 제외한 나머지 블록들을 end 로 이동.
    }

    private static int recursionHanoi1(int cnt) throws IOException {
        if (cnt == 1) {
            return 1;
        }

        return recursionHanoi1(cnt - 1) + recursionHanoi1(1) + recursionHanoi1(cnt - 1);
    }


    static class FastReader {

        BufferedReader br;
        BufferedWriter bw;
        StringTokenizer st;

        public FastReader() {
            br = new BufferedReader(new InputStreamReader(System.in));
            bw = new BufferedWriter(new OutputStreamWriter(System.out));
        }

        String next() {
            while (st == null || !st.hasMoreElements()) {
                try {
                    st = new StringTokenizer(br.readLine());
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
            return st.nextToken();
        }

        int nextInt() {
            return Integer.parseInt(next());
        }

        String nextLine() {
            String str = "";
            try {
                str = br.readLine();
            } catch (IOException e) {
                e.printStackTrace();
            }
            return str;
        }

        public void output() throws IOException {
            bw.write(K + "\n");
            for (String s : result) {
                bw.write(s + "\n");
            }
            bw.flush();
        }
    }
}