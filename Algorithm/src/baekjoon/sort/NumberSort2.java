package baekjoon.sort;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.StringTokenizer;

public class NumberSort2 {

}

class MainNumberSort2 {

    static FastReader scan = new FastReader();
    static int N;
    static List<Integer> result = new ArrayList<>();

    public static void main(String[] args) throws IOException {
        input();
        Collections.sort(result);
        output();
    }

    static void input() {
        N = scan.nextInt();

        for (int i = 0; i < N; i++) {
            result.add(scan.nextInt());
        }
    }

    static void output() throws IOException {
        scan.output();
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

        void output() throws IOException {
            for (int i = 0; i < result.size(); i++) {
                bw.write(String.valueOf(result.get(i)));
                bw.write("\n");
            }

            bw.flush();
        }
    }
}
