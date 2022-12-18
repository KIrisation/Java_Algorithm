package baekjoon.recursion;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class MergeSort1 {

}

class MainMergeSort1 {

    static FastReader scan = new FastReader();
    static StringBuilder sb = new StringBuilder();
    static List<Integer> result = new ArrayList<>();
    static int[] tmp;
    static List<Integer> answer = new ArrayList<>();

    static int N, K;
    static void input() {
        // 배열의 크기
        N = scan.nextInt();
        // 저장 횟수
        K = scan.nextInt();
        // 배열의 원소
        for (int i = 0; i < N; i++) {
            result.add(scan.nextInt());
        }

        tmp = new int[N];
    }

    static void output() throws IOException {
        scan.output();
    }

    public static void main(String[] args) throws IOException {
        input();
        mergeSort(0, result.size() - 1);
        output();
    }

    private static void mergeSort(int start, int end) {
        if (start < end) {
            int middle = (start + end) / 2;
            mergeSort(start, middle); // 전반부 정렬
            mergeSort(middle + 1, end); // 후반부 정렬
            merge(start, middle, end);
        }
    }

    private static void merge(int start, int middle, int end) {
        int i = start;
        int j = middle + 1;
        int t = 0;

        while (i <= middle && j <= end) {
            if (result.get(i) <= result.get(j)) {
                tmp[t] =  result.get(i++);
            } else {
                tmp[t] = result.get(j++);
            }

            ++t;
        }

        while (i <= middle) {   // 왼쪽 배열 부분이 남은 경우
            tmp[t] = result.get(i++);

            t++;
        }

        while (j <= end) { // 오른쪽 배열 부분이 남은 경우
            tmp[t] = result.get(j++);

            t++;
        }

        i = start;
        t = 0;

        while (i <= end) { // 결과를 result 리스트에 저장
            result.set(i, tmp[t]);
            answer.add(tmp[t]);
            i++;
            t++;
        }
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
            if (answer.size() < K) {
                bw.write(String.valueOf(-1));
            } else {
                bw.write(String.valueOf(answer.get(K - 1)));
            }

            bw.flush();
        }
    }
}

