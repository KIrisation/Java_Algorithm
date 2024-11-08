package softeer.lv2;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class 비밀_메뉴 {

    static BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
    static BufferedWriter writer = new BufferedWriter(new OutputStreamWriter(System.out));
    static StringTokenizer st;

    public static void main(String[] args) throws IOException {
        st = new StringTokenizer(reader.readLine());

        int M = Integer.parseInt(st.nextToken()); //비밀 메뉴 조작법을 나타내는 M개의 정수
        int N = Integer.parseInt(st.nextToken()); //사용자의 버튼 조작을 나타내는 N개의 정수
        int K = Integer.parseInt(st.nextToken()); //비밀번호의 범위 1 ~ K 까지의 수

        StringBuilder mToString = new StringBuilder();
        st = new StringTokenizer(reader.readLine());
        for (int i = 0; i < M; i++) {
            mToString.append(st.nextToken());
        }

        StringBuilder nToString = new StringBuilder();
        st = new StringTokenizer(reader.readLine());
        for (int i = 0; i < N; i++) {
            nToString.append(st.nextToken());
        }

        if (N > M) {
            if (nToString.toString().contains(mToString.toString())) {
                writer.write("secret");
                writer.flush();
                return;
            }

            writer.write("normal");
            writer.flush();
        }

        writer.write("normal");
        writer.flush();
    }
}
